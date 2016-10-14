package com.tw.vinaysh.automata;

import java.util.HashMap;
import java.util.HashSet;

class Transition  {

    private final HashMap<String, State> transitions;

    Transition() {
        this.transitions = new HashMap<>();
    }

    void addTransition(String alphabet, State state) {
            transitions.put(alphabet,state);
    }

    State getNextStateFor(String input) {
        return transitions.get(input);
    }
}
