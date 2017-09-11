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

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#hashCode()
		 */
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((data == null) ? 0 : data.hashCode());
			result = prime * result + ((type == null) ? 0 : type.hashCode());
			return result;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#equals(java.lang.Object)
		 */
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Builder other = (Builder) obj;
			if (data == null) {
				if (other.data != null)
					return false;
			} else if (!data.equals(other.data))
				return false;
			if (type != other.type)
				return false;
			return true;
		}

		private Token build() {

		}
	}
	public final class LocationalToken{
		private final Token token;
		private final int location;
		/**
		 * @return the token
		 */
		public Token getToken() {
			return token;
		}
		/**
		 * @return the location
		 */
		public int getLocation() {
			return location;
		}
		
	}

}
