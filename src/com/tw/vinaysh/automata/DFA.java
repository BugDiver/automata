package com.tw.vinaysh.automata;

import java.util.Set;

class DFA {
    private Set<State> setOfStates;
    private Set<String> alphabets;
    private TransitionFunction transitionFunction;
    private State initialState;
    private Set<State> finalState;

    DFA(Set<State> setOfStates, State initialState, Set<String> alphabets, TransitionFunction transitionFunction, Set<State> finalStates) {
        this.initialState = initialState;
        this.setOfStates = setOfStates;
        this.alphabets =  alphabets;
        this.transitionFunction = transitionFunction;
        this.finalState = finalStates;
    }

    private State transitTo(State currentState,String input){
        return transitionFunction.getTransitionsFor(currentState).getNextStateFor(input);
    }

    boolean validates(String s) throws InvalidAlphabetException {
        State currentState = initialState;
        for (String input : s.split("")) {
            validateAlphabet(input);
            currentState = transitTo(currentState, input);
        }
        return finalState.contains(currentState);
    }

    private void validateAlphabet(String input) throws InvalidAlphabetException {
        if (!alphabets.contains(input)){
            throw new InvalidAlphabetException(input);
        }
    }

}
