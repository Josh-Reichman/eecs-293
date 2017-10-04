package lexer;

//got rid of public
final class ConjunctiveRepresentation {
	private final String representation;
	private final boolean negation;

	ConjunctiveRepresentation(String representation, boolean negation) {
		this.representation = representation;
		this.negation = negation;
	}

	final String getRepresentation() {
		return representation;
	}

	final boolean isNegation() {
		return negation;
	}

}
