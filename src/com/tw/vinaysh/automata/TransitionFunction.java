package com.tw.vinaysh.automata;

import java.util.HashMap;

class TransitionFunction {

    private final HashMap<State, Transition> transitionFunction;

    TransitionFunction() {
        this.transitionFunction = new HashMap<>();
    }


    void addTransition(State state, Transition transition) {
        transitionFunction.put(state,transition);
    }


    Transition getTransitionsFor(State state) {
        return transitionFunction.get(state);
    }
}
