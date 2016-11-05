package com.tw.vinaysh.automata.testrunner;

import java.util.HashSet;

public class Tuple {
    private final States states;
    private final HashSet<String> alphabets;
    private final TransitionFunction tf;
    private final State startState;
    private final States finalStates;

    public Tuple(States states, HashSet<String> alphabets, TransitionFunction tf, State startState, States finalStates) {
        this.states = states;
        this.alphabets = alphabets;
        this.tf = tf;
        this.startState = startState;
        this.finalStates = finalStates;
    }

    public State getInitialState() {
        return startState;
    }

    public States getFinalStates() {
        return finalStates;
    }

    public Transition getTransitionsFor(State state) {
        return tf.getTransitionsFor(state);
    }
}
