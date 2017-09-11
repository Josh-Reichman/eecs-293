package pa2;
import java.util.*;

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
