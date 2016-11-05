package com.tw.vinaysh.automata.testrunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class States{
    private final HashSet<State> set;

    public States() {
        this.set = new HashSet<>();
    }

    public States(State... states) {
        this.set = new HashSet<>(Arrays.asList(states));
    }

    private States(States states) {
        this.set = new HashSet<>(states.set);
    }

    public State get(int index){
        return new ArrayList<>(set).get(index);
    }

    void add(State state) {
        set.add(state);
    }

    public boolean contains(State state) {
        return set.contains(state);
    }

    public void addAll(States states) {
        set.addAll(states.set);
    }


    public ArrayList<State> asList() {
        return new ArrayList<>(set);
    }

    public boolean isEmpty() {
        return set.isEmpty();
    }

    public States intersection(States states){
        States intersection = new States();
        this.set.stream().filter(states::contains).forEach(intersection::add);
        return intersection;
    }

    public States difference(States states) {
        States diff = new States();
        this.set.stream().filter(s -> !states.contains(s)).forEach(diff::add);
        return diff;
    }

    public States union(States states) {
        States union = new States(states);
        this.set.stream().filter(state -> !union.contains(state)).forEach(union::add);

        return union;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof States)) return false;

        States states = (States) o;

        return set != null ? set.equals(states.set) : states.set == null;

    }

    @Override
    public int hashCode() {
        return set != null ? set.hashCode() : 0;
    }
}
