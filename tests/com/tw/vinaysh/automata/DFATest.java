package com.tw.vinaysh.automata;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DFATest {

    private Set<String> alphabets = new HashSet<String>() {{
        add("0");
        add("1");
    }};

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testShouldThrowExceptionForInvalidAlphabets() throws Exception{
        thrown.expect(InvalidAlphabetException.class);
        thrown.expectMessage("provided alphabet ∑ is not valid!");

        State q1 = new State("q1");

        TransitionFunction tf = new TransitionFunction();

        Transition transitionforq1 = new Transition();
        transitionforq1.addTransition("0",q1);
        transitionforq1.addTransition("1",q1);

        tf.addTransition(q1,transitionforq1);

        DFA dfa  = new DFA(new HashSet<State>(){{add(q1);}},
                            q1,
                            new HashSet<String>(){{add("0");add("1");}},
                            tf ,
                            new HashSet<State>(){{add(q1);}});

        dfa.validates("∑");
    }

    @Test
    public void testDFAAcceptsStringEndWithOne() throws InvalidAlphabetException {
        State q1state = new State("q1");
        State q2state = new State("q2");
        Set<State> setOfStates = new HashSet<State>() {{
            add(q1state);
            add(q2state);
        }};

        TransitionFunction transitionFunction = new TransitionFunction();

        Transition transitionForQ1 = new Transition();
        transitionForQ1.addTransition("0", q1state);
        transitionForQ1.addTransition("1", q2state);

        Transition transitionForQ2 = new Transition();
        transitionForQ2.addTransition("0", q1state);
        transitionForQ2.addTransition("1", q2state);

        transitionFunction.addTransition(q1state, transitionForQ1);
        transitionFunction.addTransition(q2state, transitionForQ2);

        Set<State> finalStates = new HashSet<State>() {{
            add(q2state);
        }};

        DFA dfa = new DFA(setOfStates, q1state, alphabets, transitionFunction, finalStates);
        assertTrue(dfa.validates("00011"));
        assertFalse(dfa.validates("0000"));
    }

    @Test
    public void testDFAAcceptsStringBeginWith1AndContainTheString001() throws Exception {
        State q0 = new State("q0");
        State q1 = new State("q1");
        State q2 = new State("q2");
        State q3 = new State("q3");
        State q4 = new State("q4");
        State deadState = new State("q5");

        Set<State> setOfStates = new HashSet<State>() {{
            add(q0);
            add(q1);
            add(q2);
            add(q3);
            add(q4);
            add(deadState);
        }};

        TransitionFunction transitionFunction = new TransitionFunction();

        Transition transitionForQ0 = new Transition();
        transitionForQ0.addTransition("0", deadState);
        transitionForQ0.addTransition("1", q1);

        Transition transitionForQ1 = new Transition();
        transitionForQ1.addTransition("0", q2);
        transitionForQ1.addTransition("1", q1);

        Transition transitionForQ2 = new Transition();
        transitionForQ2.addTransition("0", q3);
        transitionForQ2.addTransition("1", q1);

        Transition transitionForQ3 = new Transition();
        transitionForQ3.addTransition("0", q3);
        transitionForQ3.addTransition("1", q4);

        Transition transitionForQ4 = new Transition();
        transitionForQ4.addTransition("0", q4);
        transitionForQ4.addTransition("1", q4);

        Transition transitionForDeadState = new Transition();
        transitionForQ4.addTransition("0", deadState);
        transitionForQ4.addTransition("1", deadState);

        transitionFunction.addTransition(q0, transitionForQ0);
        transitionFunction.addTransition(q1, transitionForQ1);
        transitionFunction.addTransition(q2, transitionForQ2);
        transitionFunction.addTransition(q3, transitionForQ3);
        transitionFunction.addTransition(q4, transitionForQ4);
        transitionFunction.addTransition(deadState, transitionForDeadState);

        DFA dfa = new DFA(setOfStates, q1, alphabets, transitionFunction, new HashSet<State>() {{
            add(q4);
        }});

        assertTrue("strings start with 1 and end with 001 should pass", dfa.validates("1001"));
        assertTrue("strings start with 1 and end with 0001 should pass", dfa.validates("10001"));
        assertFalse("strings start with 0 should fail", dfa.validates("011"));
    }
}