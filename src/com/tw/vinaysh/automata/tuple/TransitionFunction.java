package com.tw.vinaysh.automata.tuple;

import java.util.HashMap;

public class TransitionFunction {

    private final HashMap<State, HashMap<String, State>> transitionFunction;

    public TransitionFunction() {
        this.transitionFunction = new HashMap<>();
    }


    public void addState(State state, HashMap<String, State> transition) {
        transitionFunction.put(state,transition);
    }


    public HashMap<String, State> getTransitionsFor(State state) {
        return transitionFunction.get(state);
    }
}
