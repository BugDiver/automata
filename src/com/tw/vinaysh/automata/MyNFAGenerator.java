package com.tw.vinaysh.automata;

import com.tw.vinaysh.automata.testrunner.*;

import java.util.Set;

public class MyNFAGenerator implements IFAGenerator {
    @Override
    public IFA generate(Tuple tuple) {
        return new NFA(tuple);
    }
}
