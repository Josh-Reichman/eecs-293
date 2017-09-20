package lexer;

import java.util.Optional;
import java.util.Set;
import java.util.regex.*;

import lexer.ParserException.ErrorCode;

public class Lexer {
	private static Pattern tokenPatterns;
	private final Matcher matcher;
	

	public Lexer(String input) {
		matcher = tokenPatterns.matcher(input);
		
	}
	
	static 
	{
		Pattern.compile("(?<AND>" + Token.Type.AND.getPattern() + ")|(?<OR>" + Token.Type.OR.getPattern() + ")|"); // etc
	}
	
	public Boolean hasNext() {
		
	}

	public LocationalToken next() throws ParserException {
		if(matcher.find()) {
			
		}
		else {
			throw new ParserException(ErrorCode.TOKEN_EXPECTED);
		}
	}

	public Optional<LocationalToken> nextValid(Set<Token.Type> validTypes, Set<Token.Type> invalidTypes)
			throws ParserException {
		throw new ParserException(ErrorCode.INVALID_TOKEN);

	}

}
