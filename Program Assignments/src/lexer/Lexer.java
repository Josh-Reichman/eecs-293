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

	static {
		StringBuilder patternBuilder = new StringBuilder();

		for (Token.Type type : Token.Type.values()) {
			patternBuilder.append("(?<" + type.name() + ">" + type.getPattern() + ")|");
		}
		patternBuilder.deleteCharAt(patternBuilder.length() - 1); // maybe -1
		tokenPatterns = Pattern.compile(patternBuilder.toString());
	}

	public Boolean hasNext() {
		return matcher.find();
	}

	public LocationalToken next() throws ParserException {
		for (Token.Type typeCheck : Token.Type.values()) {
			if (matcher.group(typeCheck.getPattern()) != null) {
				Token token = Token.of(typeCheck, matcher.group());
				return new LocationalToken(token, matcher.start());
			}
		}

		throw new ParserException(ErrorCode.TOKEN_EXPECTED);
	}

	public Optional<LocationalToken> nextValid(Set<Token.Type> validTypes, Set<Token.Type> invalidTypes) throws ParserException {
		LocationalToken currentToken;
		while (hasNext()) {
			currentToken = next();
			if (validTypes.contains(currentToken.getTokenType())) {
				return Optional.of(currentToken); // change to token
			} else if (invalidTypes.contains(currentToken.getTokenType())) {
				throw new ParserException(currentToken,ErrorCode.INVALID_TOKEN);
			}
		}
		return Optional.empty();
	}

}
