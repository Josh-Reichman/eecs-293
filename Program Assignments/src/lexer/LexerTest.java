/**
 * 
 */
package lexer;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author joshreichman
 *
 */
public class LexerTest {

	/**
	 * Test method for {@link lexer.Lexer#hasNext()}.
	 */
	@Test
	public void testHasNext() {
		Lexer testLexer = new Lexer("this AND that");
		for(int numberTokens=0;numberTokens<4;numberTokens++){
			assertEquals(true,testLexer.hasNext());
		}
		assertEquals(false,testLexer.hasNext());
	}

	/**
	 * Test method for {@link lexer.Lexer#next()}.
	 */
	@Test
	public void testNext() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link lexer.Lexer#nextValid(java.util.Set, java.util.Set)}.
	 */
	@Test
	public void testNextValid() {
		fail("Not yet implemented"); // TODO
	}

}
