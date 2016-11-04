package com.tw.vinaysh.automata;

import com.tw.vinaysh.automata.testrunner.IFA;
import com.tw.vinaysh.automata.testrunner.State;
import com.tw.vinaysh.automata.testrunner.Tuple;

import java.util.List;

public class DFA implements IFA {
    private final Tuple tuple;

    public DFA(Tuple tuple) {
        this.tuple = tuple;
    }

    private List<State> transitTo(State currentState, String input){
        return tuple.getTransitionsFor(currentState).getNextStateFor(input);
    }

    @Override
    public boolean validates(String input) {
        State currentState = tuple.getInitialState();
        if (input.isEmpty()) return tuple.getFinalStates().contains(currentState);
        for (String alphabet : input.split("")) {
            currentState = transitTo(currentState, alphabet).get(0);
        }
        return tuple.getFinalStates().contains(currentState);
    }

}
