//package com.tw.vinaysh.automata.testrunner;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//
//import java.io.ByteArrayOutputStream;
//import java.io.PrintStream;
//import java.util.ArrayList;
//
//import static org.junit.Assert.*;
//
//public class TestCaseTest {
//    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
//
//    @Before
//    public void setUpStreams() {
//        System.setOut(new PrintStream(outContent));
//        System.setErr(new PrintStream(errContent));
//    }
//
//    @After
//    public void cleanUpStreams() {
//        System.setOut(null);
//        System.setErr(null);
//    }
//
//    @Test
//    public void testRunAllTestScenarios() {
//        TestCase testCase = new TestCase("string start with 1 and with 1", input -> input.startsWith("1") && input.endsWith("1"), new ArrayList<String>() {{
//            add("10000");
//            add("10");
//        }}, new ArrayList<String>() {{
//            add("0000");
//            add("00");
//        }});
//
//        testCase.runAllTestScenarios();
//        System.out.println(outContent.toString());
//        assertEquals(true, outContent.toString().contains("string start with 1 and with 1"));
//    }
//
//}