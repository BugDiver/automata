package com.tw.vinaysh.automata.testrunner;

import java.util.ArrayList;

public class TestRunner extends ArrayList<TestCase>{
    public TestRunner() {
    }

    public void runAllTestCases(){
        System.out.println("Running all test scenarios:- ");
        this.forEach(TestCase::runAllTestScenarios);
    }

    public void runOnlyPassingScenarios(){
        System.out.println("Running only passing scenarios:- ");
        this.forEach(TestCase::runPassingTestScenarios);
    }

    public void runOnlyFailingScenarios(){
        System.out.println("Running only failing scenarios:- ");
        this.forEach(TestCase::runFailingTestScenarions);
    }
}
