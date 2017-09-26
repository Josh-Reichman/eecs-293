/**
 * 
 */
package lexer;

import java.util.Optional;

public final class ParserException extends Exception {

	private static final long serialVersionUID = 293;

	private final ErrorCode errorCode;
	private final int location;

	public enum ErrorCode {
		TOKEN_EXPECTED, INVALID_TOKEN, TRAILING_INPUT, AND_EXPECTED, OPEN_EXPECTED, CLOSE_EXPECTED, ID_EXPECTED;
	}

	// Constructor 1 sets errorCode and location from token
	public ParserException(LocationalToken token, ErrorCode errorCode) {
		this.location = token.getLocation();
		this.errorCode = errorCode;
	}

	// Constructor 2 sets errorCode and location to -1
	public ParserException(ErrorCode errorCode) {
		this.errorCode = errorCode;
		this.location = -1;
	}

	public ErrorCode getErrorCode() {
		return errorCode;
	}

	public int getLocation() {
		return location;
	}

	public static void verify(Optional<LocationalToken> token) throws ParserException {
		if (!token.isPresent()) {
			throw new ParserException(ErrorCode.TOKEN_EXPECTED);
		}
	}
	
	public final static void verify(Token.Type expectedType, LocationalToken token) throws ParserException{
		if(!token.getTokenType().equals(expectedType) && expectedType.getErrorCode().isPresent()){
			throw new ParserException(expectedType.getErrorCode().get());
		}
	}

	public static void verifyEnd(Optional<LocationalToken> token) throws ParserException {
		if (token.isPresent()) {
			throw new ParserException(ErrorCode.TRAILING_INPUT);
		}
	}

	@Override
	public String toString() {
		return "ParserException [errorCode=" + errorCode + ", location=" + location + "]";
	}

}
