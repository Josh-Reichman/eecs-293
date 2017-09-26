package lexer;

public class CompoundFactor implements Factor {
	private final Identifier leftExpression;
	private final Identifier rightExpression;

	private CompoundFactor(Identifier leftExpression,Identifier rightExpression){
		this.leftExpression = leftExpression;
		this.rightExpression = rightExpression;
	}
	
	public static final class Builder {

		public static final CompoundFactor build(LocationalToken token, DisjunctiveLexer lexer) throws ParserException {
			//finish builder
			
			ParserException.verify(Token.Type.OPEN,token);
			lexer.nextValid();
			ParserException.verify(Token.Type.ID,token);
			lexer.nextValid();
			ParserException.verify(Token.Type.AND,token);
			lexer.nextValid();
			ParserException.verify(Token.Type.ID,token);
			lexer.nextValid();
			ParserException.verify(Token.Type.CLOSE,token);
		}
	}
}
