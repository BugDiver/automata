package com.tw.vinaysh.automata;

import com.tw.vinaysh.automata.testrunner.IDFAGenerator;
import com.tw.vinaysh.automata.testrunner.Parser;
import com.tw.vinaysh.automata.testrunner.TestRunner;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException, NoSuchMethodException {
        String text = new String(Files.readAllBytes(Paths.get("examples.json")), StandardCharsets.UTF_8);
        Parser parser = new Parser();
        IDFAGenerator gen = new MyIDFAGenerator();
        TestRunner runner = parser.parse(text,gen);
        runner.runAllTestCases();
    }
}
