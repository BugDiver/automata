package com.tw.vinaysh.automata;

import com.tw.vinaysh.automata.testrunner.State;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class NFATest {
    @Test
    public void intersectionShouldGiveIntersectionOfTwoListsOfState(){
        List<State> list1 = new ArrayList<State>() {{
            add(new State("a"));
            add(new State("b"));
        }};

        List<State> list2 = new ArrayList<State>() {{
            add(new State("c"));
            add(new State("b"));
        }};

        NFA nfa  = new NFA();

        List<State> expected = new ArrayList<State>() {{
            add(new State("b"));
        }};
        assertEquals(expected,nfa.intersection(list1,list2));
    }

    @Test
    public void differenceShouldReturnANewListWithTheElementOFFIrstListWhichAreNotInSecondList(){
        List<State> list1 = new ArrayList<State>() {{
            add(new State("a"));
            add(new State("b"));
            add(new State("c"));
        }};

        List<State> list2 = new ArrayList<State>() {{
            add(new State("b"));
            add(new State("d"));
        }};

        NFA nfa  = new NFA();

        List<State> expected = new ArrayList<State>() {{
            add(new State("a"));
            add(new State("c"));
        }};
        assertEquals(expected,nfa.difference(list1,list2));
    }

    @Test
    public void unionShouldReturnANewListWithTheUnionOfElements(){
        List<State> list1 = new ArrayList<State>() {{
            add(new State("a"));
            add(new State("b"));
            add(new State("c"));
        }};

        List<State> list2 = new ArrayList<State>() {{
            add(new State("b"));
            add(new State("d"));
        }};

        NFA nfa  = new NFA();

        List<State> expected = new ArrayList<State>() {{
            add(new State("a"));
            add(new State("b"));
            add(new State("c"));
            add(new State("d"));
        }};
        assertEquals(expected,nfa.union(list1,list2));
    }

}