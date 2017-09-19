package lexer;

import java.util.Optional;
import java.util.Set;
import java.util.regex.*;

public class Lexer {
	private static Pattern tokenPatterns;
	//private final Matcher;
	private boolean isComplex;
	
	public Lexer(String input) {
		
	}
	
	public Boolean hasNext() {
		
	}
	public LocationalToken next() throws ParserException{
		
	}
	
	public Optional<LocationalToken> nextValid(Set<Token.Type> validTypes,Set<Token.Type> invalidTypes) throws  ParserException{
		
	}
	

}
