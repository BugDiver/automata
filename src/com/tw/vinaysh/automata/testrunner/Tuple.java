package com.tw.vinaysh.automata.testrunner;

import java.util.HashSet;

public class Tuple {
    private final HashSet<State> states;
    private final HashSet<String> alphabets;
    private final TransitionFunction tf;
    private final State startState;
    private final HashSet<State> finalStates;

    public Tuple(HashSet<State> states, HashSet<String> alphabets, TransitionFunction tf, State startState, HashSet<State> finalStates) {
        this.states = states;
        this.alphabets = alphabets;
        this.tf = tf;
        this.startState = startState;
        this.finalStates = finalStates;
    }

    public State getInitialState() {
        return startState;
    }

    public HashSet<State> getFinalStates() {
        return finalStates;
    }

    public Transition getTransitionsFor(State state) {
        return tf.getTransitionsFor(state);
    }
}
