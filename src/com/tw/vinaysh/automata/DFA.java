package com.tw.vinaysh.automata;

import com.tw.vinaysh.automata.testrunner.IDFA;
import com.tw.vinaysh.automata.testrunner.State;
import com.tw.vinaysh.automata.testrunner.TransitionFunction;

import java.util.HashSet;
import java.util.Set;

public class DFA implements IDFA {
    private final Set<State> setOfStates;
    private final Set<String> alphabets;
    private final TransitionFunction transitionFunction;
    private final State initialState;
    private final Set<State> finalStates;

    public DFA(Set<State> setOfStates, Set<String> alphabets, TransitionFunction transitionFunction, State initialState, Set<State> finalStates) {
        this.setOfStates = setOfStates;
        this.alphabets = alphabets;
        this.transitionFunction = transitionFunction;
        this.initialState = initialState;
        this.finalStates = finalStates;
    }

    private State transitTo(State currentState,String input){
        return transitionFunction.getTransitionsFor(currentState).getNextStateFor(input);
    }

    @Override
    public boolean validates(String input) {
        State currentState = initialState;
        for (String alphabet : input.split("")) {
            currentState = transitTo(currentState, alphabet);
        }
        return finalStates.contains(currentState);
    }

}
