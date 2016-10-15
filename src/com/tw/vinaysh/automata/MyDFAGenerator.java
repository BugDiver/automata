package com.tw.vinaysh.automata;

import com.tw.vinaysh.automata.testrunner.DFAGenerator;
import com.tw.vinaysh.automata.testrunner.IDFA;
import com.tw.vinaysh.automata.testrunner.State;
import com.tw.vinaysh.automata.testrunner.TransitionFunction;

import java.util.Set;

public class MyDFAGenerator implements DFAGenerator{
    @Override
    public IDFA generate(Set<State> setOfStates, Set<String> alphabets, TransitionFunction tf, State initialState, Set<State> finalStates) {
        return new DFA(setOfStates,alphabets,tf,initialState,finalStates);
    }
}
