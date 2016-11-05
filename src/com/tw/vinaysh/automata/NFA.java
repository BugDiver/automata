package com.tw.vinaysh.automata;

import com.tw.vinaysh.automata.testrunner.*;

class NFA implements IFA {
    private Tuple tuple;

    NFA(Tuple tuple) {
        this.tuple = tuple;
    }


    @Override
    public boolean validates(String input) {
        States currentStates = epsilonTraverse(new States(tuple.getInitialState()));
        if (input.isEmpty()) return !currentStates.intersection(tuple.getFinalStates()).isEmpty();
        for (String s : input.split("")) {
            currentStates = epsilonTraverse(epsilonStatesFor(s,currentStates));
        }
        return !currentStates.intersection(tuple.getFinalStates()).isEmpty();
    }

    private States epsilonStatesFor(String s,States curr){
        States newStates = new States();
        for (State state : curr.asList()) {
            Transition t = tuple.getTransitionsFor(state);
            if (t != null && t.contains(s)){
                newStates.addAll(t.getNextStateFor(s));
            }
        }
        return newStates;
    }

    private States epsilonTraverse(States states) {
        States epsilonStates = new States();
        for (State state : states.asList()) {
            Transition t = tuple.getTransitionsFor(state);
            if (t != null && t.contains("e")){
                epsilonStates.addAll(t.getNextStateFor("e"));
            }
        }
        if (epsilonStates.difference(states).isEmpty()) return states;
        return epsilonTraverse(epsilonStates.union(states));
    }
}
