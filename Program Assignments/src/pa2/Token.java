package pa2;

import java.util.*;

public final class Token {
	private final Type type;
	private final Optional<String> data;
	private static Map<Builder, Token> tokenMap;

	private Token(Type type, Optional<String> data) {
		this.type = type;
		this.data = data;
	}

	public static Token of(Type type, String data) {

	}

	public enum Type {
		NOT, AND, OR, OPEN, CLOSE, ID, NUMBER, BINARYOF, WHITESPACE;

		private final String pattern;
		private final Boolean hasData;

		private Type(String pattern, Boolean hasData) {
			this.pattern = pattern;
			this.hasData = hasData;
		}

		/**
		 * @return the pattern
		 */

		private String getPattern() {
			return pattern;
		}

		/**
		 * @return the hasData
		 */
		private Boolean getHasData() {
			return hasData;
		}

	}

	private static class Builder {
		private final Type type;
		private final Optional<String> data;

		private Builder(Type type, Optional<String> data) {
			this.type = type;
			this.data = data;
		}
	}

}
