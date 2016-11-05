package com.tw.vinaysh.automata.testrunner;

import java.util.List;

public class TestCase {
    private final String testName;
    private final String type;
    private Tuple tuple;
    private List<String> passCases;
    private final List<String> failCases;

    public TestCase(String testName, String type, Tuple tuple, List<String> passCases, List<String> failCases) {
        this.testName = testName;
        this.type = type;
        this.tuple = tuple;
        this.passCases = passCases;
        this.failCases = failCases;
    }

    public String getTestType() {
        return type;
    }

    public TestRunner getTextRunner(IFAGenerator generator) {
        return new TestRunner(type,testName,passCases,failCases,generator.generate(tuple));
    }
}
