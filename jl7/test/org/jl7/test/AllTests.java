package org.jl7.test;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

    public static Test suite() {
        TestSuite suite = new TestSuite("Test suite for org.jl7");
        // $JUnit-BEGIN$
        suite.addTestSuite(TestEscapedStringTokenizer.class);
        suite.addTestSuite(TestHL7Subcomponent.class);
        suite.addTestSuite(TestHL7Component.class);
        suite.addTestSuite(TestHL7FieldRepetition.class);
        suite.addTestSuite(TestHL7Field.class);
        suite.addTestSuite(TestHL7Segment.class);
        suite.addTestSuite(TestHL7MSHSegment.class);
        suite.addTestSuite(TestHL7Message.class);
        suite.addTestSuite(TestMLLPTransport.class);
        suite.addTestSuite(TestHl7MessageExtractor.class);
        suite.addTestSuite(TestHL7MessageSplitter.class);
        suite.addTestSuite(TestHL7Dsl.class);
        // $JUnit-END$
        return suite;
    }
}
