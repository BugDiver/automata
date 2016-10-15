package com.tw.vinaysh.automata.testrunner;

import java.util.List;

public class TestCase {
    private final String testName;
    private final IDFA dfa;
    private List<String> passCases;
    private final List<String> failCases;

    public TestCase(String testName , IDFA dfa, List<String> passCases, List<String> failCases) {
        this.testName = testName;
        this.dfa = dfa;
        this.passCases = passCases;
        this.failCases = failCases;
    }

    public void runAllTestScenarios(){
        System.out.printf("\n\t%s\n",testName);
        passCases.stream().filter(passCase -> !dfa.validates(passCase)).forEach(passCase -> System.out.printf("\t\t\"%s\" should pass but failing.\n",passCase));
        failCases.stream().filter(dfa::validates).forEach(failCase -> System.out.printf("\t\t\"%s\" should fail but passing.\n",failCase));
    }

    public void runPassingTestScenarios() {
        System.out.printf("\n\t%s\n",testName);
        passCases.stream().filter(passCase -> !dfa.validates(passCase)).forEach(passCase -> System.out.printf("\t\t\"%s\" should pass but failing.\n",passCase));
    }

    public void runFailingTestScenarions(){
        System.out.printf("\n\t%s\n",testName);
        failCases.stream().filter(dfa::validates).forEach(failCase -> System.out.printf("\t\t\"%s\" should fail but passing.\n",failCase));

    }

}
