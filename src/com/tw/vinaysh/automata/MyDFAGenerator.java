package com.tw.vinaysh.automata;

import com.tw.vinaysh.automata.testrunner.*;

import java.util.Set;

public class MyDFAGenerator implements IFAGenerator {
    @Override
    public IFA generate(Tuple tuple) {
        return new DFA(tuple);
    }
}
