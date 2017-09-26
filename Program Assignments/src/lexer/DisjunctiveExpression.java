package lexer;

public final class DisjunctiveExpression {
	private final Factor factor;
	private final boolean positive;

	private DisjunctiveExpression() {

	}

	public static final class Builder {

		public static final DisjunctiveExpression build(LocationalToken token, DisjunctiveLexer lexer) throws ParserException {
			
			//add optional
			ParserException.verify(Token.Type.NOT,token);
			lexer.nextValid();
			ParserException.verify(Token.Type.ID,token);
			lexer.nextValid();
			ParserException.verify(Token.Type.NOT,token); 
		}
	}

	public final DisjunctiveExpression negate() {

	}
}
