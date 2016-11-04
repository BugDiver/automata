package com.tw.vinaysh.automata;

import com.tw.vinaysh.automata.testrunner.IFA;
import com.tw.vinaysh.automata.testrunner.State;
import com.tw.vinaysh.automata.testrunner.Transition;
import com.tw.vinaysh.automata.testrunner.Tuple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class NFA implements IFA {
    private Tuple tuple;

    public NFA() {
    }

    public NFA(Tuple tuple) {
        this.tuple = tuple;
    }


    @Override
    public boolean validates(String input) {
        List<State> currentStates = epsilonTraverse(new ArrayList<State>(){{add(tuple.getInitialState());}});
        if (input.isEmpty()) return !intersection(currentStates,new ArrayList<>(tuple.getFinalStates())).isEmpty();
        for (String s : input.split("")) {
            ArrayList<State> newStates = new ArrayList<>();
            for (State state : currentStates) {
                Transition t = tuple.getTransitionsFor(state);
                if (t != null && t.contains(s)){
                    newStates.addAll(t.getNextStateFor(s));
                }
            }
            currentStates = epsilonTraverse(newStates);
        }
        return !intersection(currentStates,new ArrayList<>(tuple.getFinalStates())).isEmpty();
    }

    private List<State> epsilonTraverse(List<State> states) {
        List<State> epsilonStates = new ArrayList<>();
        for (State state : states) {
            Transition t = tuple.getTransitionsFor(state);
            if (t != null && t.contains("e")){
                epsilonStates.addAll(t.getNextStateFor("e"));
            }
        }
        if (difference(epsilonStates,states).isEmpty()) return states;
        return epsilonTraverse(union(epsilonStates,states));
    }

    List<State> intersection(List<State> list1, List<State> list2) {
        return list1.stream().filter(list2::contains).collect(Collectors.toList());
    }

    List<State> difference(List<State> newStates, List<State> states) {
        return newStates.stream().filter(s -> !states.contains(s)).collect(Collectors.toList());
    }


    public List<State> union(List<State> list1, List<State> list2) {
        ArrayList<State> union = new ArrayList<>(list1);
        list2.stream().filter(state -> !union.contains(state)).forEach(union::add);
        return union;
    }
}
