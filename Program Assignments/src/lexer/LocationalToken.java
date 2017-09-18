package lexer;

import java.util.Optional;

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
