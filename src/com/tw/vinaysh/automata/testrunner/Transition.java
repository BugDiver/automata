package com.tw.vinaysh.automata.testrunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Transition  {

    private final HashMap<String, States> transitions;

    public Transition() {
        this.transitions = new HashMap<>();
    }

    public void addTransition(String alphabet, States state) {
            transitions.put(alphabet,state);
    }

    public States getNextStateFor(String input) {
        return transitions.get(input);
    }

    public boolean contains(String e) {
        return transitions.containsKey(e);
    }
}
