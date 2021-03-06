package lexer;

public final class DisjunctiveExpression {
	private final Factor factor;
	private final boolean positive;

	private DisjunctiveExpression(Factor factor, boolean positive) {
		this.factor = factor;
		this.positive = positive;
	}

	public static final class Builder {

		public static final DisjunctiveExpression build(LocationalToken token, DisjunctiveLexer lexer)
				throws ParserException {
			boolean positive = true;

			LocationalToken tokenTemp;

			if (Token.Type.NOT.equals(token.getTokenType())) {
				positive = false;
				ParserException.verify(lexer.nextValid());
				tokenTemp = lexer.nextValid().get();// add verification

			} else {
				tokenTemp = token;
			}
			Factor factor;
			if (tokenTemp.getTokenType().equals(Token.Type.ID)) {
				factor = Identifier.Builder.build(tokenTemp);
			} else {
				factor = CompoundFactor.Builder.build(tokenTemp, lexer);
			}
			return new DisjunctiveExpression(factor, positive);
		}
	}

	public final DisjunctiveExpression negate() {
		return new DisjunctiveExpression(factor, !positive);
	}

	public final String conjunctiveRepresentation() {
		if (factor.conjunctiveRepresentation().isNegation() == (positive)) {
			return ("NOT " + factor.conjunctiveRepresentation().getRepresentation());
		}
		return factor.conjunctiveRepresentation().getRepresentation(); // TODO: Make sure this is right
	}
}
