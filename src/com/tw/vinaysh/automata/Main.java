package com.tw.vinaysh.automata;

import com.tw.vinaysh.automata.testrunner.IFAGenerator;
import com.tw.vinaysh.automata.testrunner.Parser;
import com.tw.vinaysh.automata.testrunner.TestCase;
import com.tw.vinaysh.automata.testrunner.TestRunner;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, NoSuchMethodException {
        String text = new String(Files.readAllBytes(Paths.get("examples.json")), StandardCharsets.UTF_8);
        Parser parser = new Parser();
        List<TestCase> cases = parser.parse(text);
        HashMap<String, IFAGenerator> generators = new HashMap<String, IFAGenerator>() {{
            put("nfa",new MyNFAGenerator());
            put("dfa",new MyDFAGenerator());
        }};

        for (TestCase testcase : cases) {
            if (testcase.getTestType().equals("nfa")){
                TestRunner runner = testcase.getTextRunner(generators.get(testcase.getTestType()));
                runner.runAllTestCases();
            }
        }
    }
}
