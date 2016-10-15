package com.tw.vinaysh.automata.testrunner;

import com.tw.vinaysh.automata.testrunner.State;

import java.util.HashMap;

public class Transition  {

    private final HashMap<String, State> transitions;

    public Transition() {
        this.transitions = new HashMap<>();
    }

    public void addTransition(String alphabet, State state) {
            transitions.put(alphabet,state);
    }

    public State getNextStateFor(String input) {
        return transitions.get(input);
    }
}
