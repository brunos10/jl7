/**
 * 
 */
package org.jl7.test;

import junit.framework.TestCase;

import org.jl7.textutils.EscapedStringTokenizer;

/**
 * @author henribenoit
 * 
 */
public class TestEscapedStringTokenizer extends TestCase {

    /*
     * (non-Javadoc)
     * 
     * @see junit.framework.TestCase#setUp()
     */
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    /*
     * (non-Javadoc)
     * 
     * @see junit.framework.TestCase#tearDown()
     */
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * When the input string is empty, a single empty token should be returned
     */
    public void testEmptyInputString() {
        EscapedStringTokenizer tokenizer = new EscapedStringTokenizer("", "", '\\');
        String[] tokens = tokenizer.getTokens();
        assertEquals(1, tokens.length);
        assertEquals("", tokens[0]);
    }

    /**
     * Test method for
     * {@link org.jl7.textutils.EscapedStringTokenizer#EscapedStringTokenizer(java.lang.String, char, char)}
     * .
     */
    public void testEscapedStringTokenizerStringCharChar() {
        EscapedStringTokenizer tokenizer = new EscapedStringTokenizer("a|b\\c|d\\|e/f\\/g", '|', '\\');
        String[] tokens = tokenizer.getTokens();
        assertEquals("a", tokens[0]);
        assertEquals("b\\c", tokens[1]);
        assertEquals("d|e/f\\/g", tokens[2]);
    }

    /**
     * Test method for
     * {@link org.jl7.textutils.EscapedStringTokenizer#EscapedStringTokenizer(java.lang.String, char, char, boolean)}
     * .
     */
    public void testEscapedStringTokenizerStringCharCharFalse() {
        EscapedStringTokenizer tokenizer = new EscapedStringTokenizer("a|b\\c|d\\|e/f\\/g", '|', '\\', false);
        String[] tokens = tokenizer.getTokens();
        assertEquals("a", tokens[0]);
        assertEquals("b\\c", tokens[1]);
        assertEquals("d|e/f\\/g", tokens[2]);
    }

    /**
     * Test method for
     * {@link org.jl7.textutils.EscapedStringTokenizer#EscapedStringTokenizer(java.lang.String, char, char, boolean)}
     * .
     */
    public void testEscapedStringTokenizerStringCharCharTrue() {
        EscapedStringTokenizer tokenizer = new EscapedStringTokenizer("a|b\\c|d\\|e/f\\/g", '|', '\\', true);
        String[] tokens = tokenizer.getTokens();
        assertEquals("a", tokens[0]);
        assertEquals("|b\\c", tokens[1]);
        assertEquals("|d|e/f\\/g", tokens[2]);
    }

    /**
     * Test method for
     * {@link org.jl7.textutils.EscapedStringTokenizer#EscapedStringTokenizer(java.lang.String, java.lang.String, char)}
     * .
     */
    public void testEscapedStringTokenizerStringStringChar() {
        EscapedStringTokenizer tokenizer = new EscapedStringTokenizer("a|b\\c|d\\|e/f\\/g", "|/", '\\');
        String[] tokens = tokenizer.getTokens();
        assertEquals("a", tokens[0]);
        assertEquals("b\\c", tokens[1]);
        assertEquals("d|e", tokens[2]);
        assertEquals("f/g", tokens[3]);
    }

    /**
     * Test method for
     * {@link org.jl7.textutils.EscapedStringTokenizer#EscapedStringTokenizer(java.lang.String, java.lang.String, char, boolean)}
     * .
     */
    public void testEscapedStringTokenizerStringStringCharFalse() {
        EscapedStringTokenizer tokenizer = new EscapedStringTokenizer("a|b\\c|d\\|e/f\\/g", "|/", '\\', false);
        String[] tokens = tokenizer.getTokens();
        assertEquals("a", tokens[0]);
        assertEquals("b\\c", tokens[1]);
        assertEquals("d|e", tokens[2]);
        assertEquals("f/g", tokens[3]);
    }

    /**
     * Test method for
     * {@link org.jl7.textutils.EscapedStringTokenizer#EscapedStringTokenizer(java.lang.String, java.lang.String, char, boolean)}
     * .
     */
    public void testEscapedStringTokenizerStringStringCharTrue() {
        EscapedStringTokenizer tokenizer = new EscapedStringTokenizer("a|b\\c|d\\|e/f\\/g", "|/", '\\', true);
        String[] tokens = tokenizer.getTokens();
        assertEquals("a", tokens[0]);
        assertEquals("|b\\c", tokens[1]);
        assertEquals("|d|e", tokens[2]);
        assertEquals("/f/g", tokens[3]);
    }

    /**
     * Test method for
     * {@link org.jl7.textutils.EscapedStringTokenizer#hasMoreElements()}.
     */
    public void testHasMoreElements() {
        EscapedStringTokenizer tokenizer = new EscapedStringTokenizer("a|b\\c|d\\|e/f\\/g", "|/", '\\');
        StringBuilder builder = new StringBuilder();
        while (tokenizer.hasMoreElements()) {
            builder.append(tokenizer.nextElement()).append("==");
        }
        String value = builder.toString();
        assertEquals("a==b\\c==d|e==f/g==", value);
    }
}
