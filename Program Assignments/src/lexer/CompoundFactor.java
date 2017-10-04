package lexer;

import java.util.Optional;

public class CompoundFactor implements Factor {

	// TODO: change all Identifiers to DisjunctiveExpressions
	private final DisjunctiveExpression leftExpression;
	private final DisjunctiveExpression rightExpression;

	private CompoundFactor(DisjunctiveExpression leftExpression, DisjunctiveExpression rightExpression) {
		this.leftExpression = leftExpression;
		this.rightExpression = rightExpression;
	}

	public static final class Builder {

		public static final CompoundFactor build(LocationalToken token, DisjunctiveLexer lexer) throws ParserException {
			ParserException.verify(Token.Type.OPEN, token);

			DisjunctiveExpression left = buildDisjunctiveExpression(lexer);
			verifyType(lexer, Token.Type.AND);

			DisjunctiveExpression right = buildDisjunctiveExpression(lexer);
			verifyType(lexer, Token.Type.CLOSE);

			return new CompoundFactor(left, right);
		}

		private static void verifyType(DisjunctiveLexer lexer, Token.Type expectedType) throws ParserException {
			Optional<LocationalToken> tokenTemp;
			tokenTemp = lexer.nextValid();
			ParserException.verify(tokenTemp);
			ParserException.verify(expectedType, tokenTemp.get());
		}

		private static DisjunctiveExpression buildDisjunctiveExpression(DisjunctiveLexer lexer) throws ParserException {
			Optional<LocationalToken> tokenTemp;
			tokenTemp = lexer.nextValid();
			ParserException.verify(tokenTemp);
			ParserException.verify(Token.Type.ID, tokenTemp.get());

			return DisjunctiveExpression.Builder.build(tokenTemp.get(), lexer);
		}

	}

	@Override
	public String toString() {
		return "CompoundFactor [leftExpression=" + leftExpression + ", rightExpression=" + rightExpression + "]";
	}

	@Override
	public ConjunctiveRepresentation conjunctiveRepresentation() {
		return new ConjunctiveRepresentation("( " + leftExpression.conjunctiveRepresentation() + " OR "
				+ rightExpression.conjunctiveRepresentation() + " )", true);
	}

}
