package com.tw.vinaysh.automata.testrunner;

import java.util.List;

public class TestRunner{

    private String type;
    private String testName;
    private final List<String> passCases;
    private final List<String> failCases;
    private IFA machine;

    public TestRunner(String type,String testName, List<String> passCases, List<String> failCases, IFA machine) {
        this.type = type;
        this.testName = testName;
        this.passCases = passCases;
        this.failCases = failCases;
        this.machine = machine;
    }

    public void runAllTestCases(){
        StringBuilder out = new StringBuilder(testName).append("(").append("type ->").append(type).append(") :-");
        out.append("\n\tpass cases:-\t\t");
        for (String passCase : passCases) {
            if (machine.validates(passCase))
                out.append("\n\t\t").append(passCase).append(":- pass");
            else
                out.append("\n\t\t").append(passCase).append(":- fail");
        }
        out.append("\n\tfail cases:-\t\t");
        for (String failCase : failCases) {
            if (!machine.validates(failCase))
                out.append("\n\t\t").append(failCase).append(":- pass");
            else
                out.append("\n\t\t").append(failCase).append(":- fail");
        }
        System.out.println(out.toString());
    }

    public void runOnlyPassingScenarios(){
//        StringBuilder out = new StringBuilder(testName).append("(").append("type ->").append(type).append(") :-");
//        out.append("\n\tpass cases:-\t\t");
        for (String passCase : passCases) {
            if (!machine.validates(passCase))
                throw new RuntimeException(type+"---"+testName+"------"+passCase);
            else
                System.out.println(passCase);
//                out.append("\n\t\t").append(passCase).append(":- pass");
//            else
//                out.append("\n\t\t").append(passCase).append(":- fail");
        }
//        System.out.println(out.toString());
    }

    public void runOnlyFailingScenarios(){
        System.out.println("Running only failing scenarios:- ");
    }
}
