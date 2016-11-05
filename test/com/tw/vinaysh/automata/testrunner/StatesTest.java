package com.tw.vinaysh.automata.testrunner;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StatesTest {
    @Test
    public void shouldBeAbleAddAndRetrieveStates() {
        States states = new States();
        states.add(new State("a"));

        assertEquals(states.get(0), new State("a"));
    }

    @Test
    public void shouldBeAbleAddAnotherStates() {
        States states = new States(new State("a"), new State("b"));

        States states1 = new States();

        states1.addAll(states);

        assertEquals(states.get(0), new State("a"));
        assertEquals(states.get(1), new State("b"));
    }

    @Test
    public void shouldBeAbleTellIfItContainsAState() {
        States states = new States(new State("a"), new State("b"));

        assertTrue(states.contains(new State("a")));
        assertTrue(states.contains(new State("b")));
        assertFalse(states.contains(new State("c")));
    }

    @Test
    public void intersectionShouldReturnANewStateWithIntersectElements() {
        States states = new States(new State("a"), new State("b"), new State("c"));
        States states1 = new States(new State("b"), new State("c"), new State("d"));
        States expected = new States(new State("b"), new State("c"));

        assertEquals(states.intersection(states1),expected);
    }

    @Test
    public void unionShouldReturnANewStatesWithUnionOfAll() {
        States states = new States(new State("a"), new State("b"), new State("c"));
        States states1 = new States(new State("b"), new State("c"), new State("d"));
        States expected = new States(new State("a"),new State("b"), new State("c"),new State("d"));

        assertEquals(states.union(states1),expected);
    }

    @Test
    public void differenceShouldReturnANewStatesWithElementsWhichAreNotPresentInAnotherStates() {
        States states = new States(new State("a"), new State("b"), new State("c"));
        States states1 = new States(new State("b"), new State("c"), new State("d"));
        States expected = new States(new State("a"));
        States expected2 = new States(new State("d"));

        assertEquals(states.difference(states1),expected);
        assertEquals(states1.difference(states),expected2);
    }

}
