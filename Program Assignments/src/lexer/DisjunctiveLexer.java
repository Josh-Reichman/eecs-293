package lexer;

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Optional;

public final class DisjunctiveLexer {
	public static final Set<Token.Type> validTypes = new HashSet<Token.Type>(
			Arrays.asList(Token.Type.AND, Token.Type.ID, Token.Type.NOT, Token.Type.OPEN, Token.Type.CLOSE));
	public static final Set<Token.Type> invalidTypes = new HashSet<Token.Type>(
			Arrays.asList(Token.Type.OR, Token.Type.NUMBER, Token.Type.BINARYOP));
	private Lexer lexer;

	public DisjunctiveLexer(String input) {
		lexer = new Lexer(input);
	}

	public Optional<LocationalToken> nextValid() throws ParserException {
		return lexer.nextValid(validTypes, invalidTypes);
	}
}
