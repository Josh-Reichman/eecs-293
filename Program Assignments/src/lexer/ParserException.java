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
		TOKEN_EXPECTED, INVALID_TOKEN, TRAILING_INPUT;
	}

	// Constructor 1 sets errorCode and location from token
	public ParserException(int location, ErrorCode errorCode) {

	}

	// Constructor 2 sets errorCode and location to -1
	public ParserException(ErrorCode errorCode) {

	}

	public static void verify(Optional<LocationalToken> token) throws ParserException {
		
	}

	public static void verifyEnd(Optional<LocationalToken> token) throws ParserException {
		
	}

	public ErrorCode getErrorCode() {
		return errorCode;
	}

	public int getLocation() {
		return location;
	}

	@Override
	public String toString() {
		return "ParserException [errorCode=" + errorCode + ", location=" + location + "]";
	}
}
