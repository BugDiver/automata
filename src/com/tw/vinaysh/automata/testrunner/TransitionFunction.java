package com.tw.vinaysh.automata.testrunner;

import java.util.HashMap;

public class TransitionFunction {

    private final HashMap<State, Transition> transitionFunction;

    public TransitionFunction() {
        this.transitionFunction = new HashMap<>();
    }


    public void addTransition(State state, Transition transition) {
        transitionFunction.put(state,transition);
    }


    public Transition getTransitionsFor(State state) {
        return transitionFunction.get(state);
    }
}
