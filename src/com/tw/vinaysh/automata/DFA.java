package com.tw.vinaysh.automata;

import com.tw.vinaysh.automata.tuple.State;
import com.tw.vinaysh.automata.tuple.TransitionFunction;

import java.util.Set;

class DFA {
    private Set<State> setOfStates;
    private Set<String> alphabet;
    private TransitionFunction transitionFunction;
    private State initialState;
    private Set<State> finalState;

    DFA(Set<State> setOfStates, State initialState, Set<String> alphabets, TransitionFunction transitionFunction, Set<State> finalStates) {
        this.initialState = initialState;
        this.setOfStates = setOfStates;
        this.alphabet =  alphabets;
        this.transitionFunction = transitionFunction;
        this.finalState = finalStates;
    }

    private State transitTo(State currentState,String input){
        return transitionFunction.getTransitionsFor(currentState).get(input);
    }

    boolean isAccepted(String s) {
        State currentState = initialState;
        for (String input : s.split("")) {
            currentState = transitTo(currentState, input);
        }
        return finalState.contains(currentState);
    }
}
