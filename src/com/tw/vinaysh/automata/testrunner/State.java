package com.tw.vinaysh.automata.testrunner;

public class State {
    private final String state          ;

    public State(String state) {
        this.state = state;
    }



    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof State)) return false;

        State state1 = (State) other;

        return state != null ? state.equals(state1.state) : state1.state == null;

    }

    @Override
    public int hashCode() {
        return state != null ? state.hashCode() : 0;
    }


}
