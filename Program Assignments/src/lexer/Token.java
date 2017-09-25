package lexer;

import java.util.*;

public final class Token {

	private final Type type;
	private final Optional<String> data;
	private static Map<Builder, Token> tokenMap = new Hashtable<Builder, Token>();

	private Token(Type type, Optional<String> data) {
		this.type = type;
		this.data = data;
	}

	public static Token of(Type type, String data) {

		Builder tokenBuilder = new Builder(type, Optional.ofNullable(data));
		if (!tokenMap.containsKey(tokenBuilder)) {
			tokenMap.put(tokenBuilder, tokenBuilder.build());
		}
		// if builder exists but token mismatched, rebuild and replace
		Token token = new Token(type, Optional.ofNullable(data));
		if (!tokenMap.get(tokenBuilder).equals(token)) {
			tokenMap.replace(tokenBuilder, tokenBuilder.build());
		}
		// If token already exists with the same type and data, return the previously
		// token.
		return tokenMap.get(tokenBuilder);
	}

	public Type getType() {
		return type;
	}

	public Optional<String> getData() {
		return data;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Token other = (Token) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Token [type=" + type + ", data=" + data + ", toString()=" + super.toString() + "]";
	}

	//enum Type
	public enum Type {
		NOT("not", false, false, null),
		AND("and", false, true, ParserException.ErrorCode
		OR("or", false, true,null), 
		OPEN("\\(", false, false),
		CLOSE("\\)", false, false),
		ID("[a-z]+",true, false), 
		NUMBER("\\-?[0-9]+", true, false,null),
		BINARYOP("\\+|-|\\*|/", true, false,null),
		WHITESPACE("\\s+", false, false,null);

		private final String pattern; // Indicates the regex pattern in a token
		private final Boolean hasData; // Indicates the presence of ancillary data in a token
		private final boolean isComplex; 
		private Optional<ParserException.ErrorCode> errorCode;
		private Type(String pattern, Boolean hasData, boolean isComplex,Optional<ParserException.ErrorCode> errorCode) {
			this.pattern = pattern;
			this.hasData = hasData;
			this.isComplex = isComplex;
			this.errorCode = errorCode;
		}

		public String getPattern() {
			return pattern;
		}

		public Boolean getHasData() {
			return hasData;
		}
		
		public boolean getIsComplex() {
			return isComplex;
		}
	}

	// Token Builder Class
	private static class Builder {

		private final Type type;
		private final Optional<String> data;

		private Builder(Type type, Optional<String> data) {
			this.type = type;
			this.data = data;
		}

		private Token build() {
			return new Token(type, data);
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((data == null) ? 0 : data.hashCode());
			result = prime * result + ((type == null) ? 0 : type.hashCode());
			return result;
		}

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

	}

}
