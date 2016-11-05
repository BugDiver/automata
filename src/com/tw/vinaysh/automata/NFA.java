package com.tw.vinaysh.automata;

import com.tw.vinaysh.automata.testrunner.IFA;
import com.tw.vinaysh.automata.testrunner.States;
import com.tw.vinaysh.automata.testrunner.Transition;
import com.tw.vinaysh.automata.testrunner.Tuple;

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
            currentStates = epsilonTraverse(getAllStates(currentStates,s));
        }
        return !currentStates.intersection(tuple.getFinalStates()).isEmpty();
    }


    private States epsilonTraverse(States states) {
        String epsilon = "e";
        States epsilonStates = getAllStates(states, epsilon);
        if (epsilonStates.difference(states).isEmpty()) return states;
        return epsilonTraverse(epsilonStates.union(states));
    }

    private States getAllStates(States states,String alphabet) {
        States allStates = new States();
        states.asList().forEach(state -> {
            Transition transition = tuple.getTransitionsFor(state);
            if (hasTransition(transition, alphabet)) allStates.addAll(transition.getNextStateFor(alphabet));
        });
        return allStates;
    }

    private boolean hasTransition(Transition t, String e) {
        return t != null && t.contains(e);
    }
}
