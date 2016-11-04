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
//public class TestRunnerTest {
//    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
//
//    private TestCase sampletestCase(){
//        return new TestCase("string start with 0 and ends with 1", new IFA() {
//            @Override
//            public boolean validates(String input) {
//                return input.startsWith("0") && input.endsWith("1");
//            }
//        }, new ArrayList<String>() {{
//            add("0001");
//            add("01");
//        }}, new ArrayList<String>() {{
//            add("10000");
//            add("100");
//        }});
//    }
//
//    private TestCase sampleTestCaseWithFailures(){
//        return new TestCase("string start with 1 and ends with 0", new IFA() {
//            @Override
//            public boolean validates(String input) {
//                return input.startsWith("1") && input.endsWith("0");
//            }
//        }, new ArrayList<String>() {{
//            add("100");
//            add("01");
//        }}, new ArrayList<String>() {{
//            add("1000");
//            add("001");
//        }});
//    }
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
//        TestRunner runner = new TestRunner();
//
//        runner.add(sampletestCase());
//        runner.runAllTestCases();
//        String expected = "Running all test scenarios:- " +
//                        "\n\n\tstring start with 0 and ends with 1\n";
//        assertEquals(outContent.toString(),expected);
//    }
//
//    @Test
//    public void testRunOnlyPassingScenarios() {
//        TestRunner runner = new TestRunner();
//
//        runner.add(sampletestCase());
//        runner.runOnlyPassingScenarios();
//        String expected = "Running only passing scenarios:- " +
//                "\n\n\tstring start with 0 and ends with 1\n";
//        assertEquals(outContent.toString(),expected);
//    }
//
//    @Test
//    public void testRunOnlyFailingScenarios() {
//        TestRunner runner = new TestRunner();
//
//        runner.add(sampletestCase());
//        runner.runOnlyFailingScenarios();
//        String expected = "Running only failing scenarios:- " +
//                "\n\n\tstring start with 0 and ends with 1\n";
//        assertEquals(outContent.toString(),expected);
//    }
//
//    @Test
//    public void testRunAllTestScenariosWithFailures() {
//        TestRunner runner = new TestRunner();
//
//        runner.add(sampleTestCaseWithFailures());
//        runner.runAllTestCases();
//        String expected  =  "Running all test scenarios:- \n" +
//                            "\n"+
//                            "\tstring start with 1 and ends with 0\n" +
//                            "\t\t\"01\" should pass but failing.\n" +
//                            "\t\t\"1000\" should fail but passing.\n";
//        assertEquals(outContent.toString(),expected);
//    }
//
//}
