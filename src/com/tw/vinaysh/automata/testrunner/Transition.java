package com.tw.vinaysh.automata.testrunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Transition  {

    private final HashMap<String, State[]> transitions;

    public Transition() {
        this.transitions = new HashMap<>();
    }

    public void addTransition(String alphabet, State... state) {
            transitions.put(alphabet,state);
    }

    public List<State> getNextStateFor(String input) {
        return Arrays.asList(transitions.get(input));
    }

    public boolean contains(String e) {
        return transitions.containsKey(e);
    }
}
