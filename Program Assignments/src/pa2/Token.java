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

		Builder tokenBuilder = new Builder(type, Optional.ofNullable(data));
		if (!tokenMap.containsKey(tokenBuilder)) {
			if(tokenMap == null) {
				tokenMap = new Hashtable<Builder,Token>();
			}
			tokenMap.put(tokenBuilder, tokenBuilder.build());
		}
		//if builder exists but token mismatched, rebuild and replace
		Token token = new Token(type,Optional.ofNullable(data));
		if(!tokenMap.get(tokenBuilder).equals(token)) {
			tokenMap.replace(tokenBuilder, tokenBuilder.build());
		}
		//If token already exists with the same type and data, return the previously token.
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
		NOT("not", false),
		AND("and", false), 
		OR("or", false), 
		OPEN("(", false), 
		CLOSE(")", false),
		ID("[a-z]+",true), 
		NUMBER("\\-?[0-9]", true), 
		BINARYOP("\\+|-|\\*|/", true),
		WHITESPACE("\\s+", false);
	
		private final String pattern; //Indicates the regex pattern in a token
		private final Boolean hasData; //Indicates the presence of ancillary data in a token
	
		Type(String pattern, Boolean hasData) {
			this.pattern = pattern;
			this.hasData = hasData;
		}
	
		public String getPattern() {
			return pattern;
		}
	
		public Boolean getHasData() {
			return hasData;
		}
	
	}


	//Token Builder Class
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


	//LocationalToken Class
	public final class LocationalToken {
		private final Token token;
		private int location;
	
		private LocationalToken(Token token, int location) {
			this.token = token;
			this.location = location;
		}
	
		public Token getToken() {
			return token;
		}
	
		public int getLocation() {
			return location;
		}
		
		public Token.Type getTokenType() {
	        return token.getType();
	    }
	
	    public Optional<String> getTokenData() {
	        return token.getData();
	    }
	
	}

}
