package com.tw.vinaysh.automata.testrunner;

import java.util.Set;

public interface DFAGenerator {
    IDFA generate(Set<State> setOfStates, Set<String> alphabets, TransitionFunction tf, State initialState, Set<State> finalStates);
}
