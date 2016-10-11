package com.tw.vinaysh.automata;

import com.tw.vinaysh.automata.tuple.State;
import com.tw.vinaysh.automata.tuple.TransitionFunction;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DFATest {

    Set<String> alphabets = new HashSet<String>() {{
        add("0");
        add("1");
    }};

    @Test
    public void testDFAAcceptsStringEndWithOne() {
        State q1state = new State("q1");
        State q2state = new State("q2");
        Set<State> setOfStates = new HashSet<State>() {{
            add(q1state);
            add(q2state);
        }};

        TransitionFunction transitionFunction = new TransitionFunction();

        HashMap<String, State> transitionForQ1 = new HashMap<>();
        transitionForQ1.put("0", q1state);
        transitionForQ1.put("1", q2state);

        HashMap<String, State> transitionForQ2 = new HashMap<>();
        transitionForQ2.put("0", q1state);
        transitionForQ2.put("1", q2state);

        transitionFunction.addState(q1state, transitionForQ1);
        transitionFunction.addState(q2state, transitionForQ2);

        Set<State> finalStates = new HashSet<State>() {{
            add(q2state);
        }};

        DFA dfa = new DFA(setOfStates, q1state, alphabets, transitionFunction, finalStates);
        assertTrue(dfa.isAccepted("00011"));
        assertFalse(dfa.isAccepted("0000"));
    }

    @Test
    public void testDFAAcceptsStringBeginWith1AndContainTheString001() {
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

        HashMap<String, State> transitionForQ0 = new HashMap<>();
        transitionForQ0.put("0", deadState);
        transitionForQ0.put("1", q1);

        HashMap<String, State> transitionForQ1 = new HashMap<>();
        transitionForQ1.put("0", q2);
        transitionForQ1.put("1", q1);

        HashMap<String, State> transitionForQ2 = new HashMap<>();
        transitionForQ2.put("0", q3);
        transitionForQ2.put("1", q1);

        HashMap<String, State> transitionForQ3 = new HashMap<>();
        transitionForQ3.put("0", q3);
        transitionForQ3.put("1", q4);

        HashMap<String, State> transitionForQ4 = new HashMap<>();
        transitionForQ4.put("0", q4);
        transitionForQ4.put("1", q4);

        HashMap<String, State> transitionForDeadState = new HashMap<>();
        transitionForQ4.put("0", deadState);
        transitionForQ4.put("1", deadState);

        transitionFunction.addState(q0, transitionForQ0);
        transitionFunction.addState(q1, transitionForQ1);
        transitionFunction.addState(q2, transitionForQ2);
        transitionFunction.addState(q3, transitionForQ3);
        transitionFunction.addState(q4, transitionForQ4);
        transitionFunction.addState(deadState, transitionForDeadState);

        DFA dfa = new DFA(setOfStates, q1, alphabets, transitionFunction, new HashSet<State>() {{
            add(q4);
        }});

        assertTrue("strings start with 1 and end with 001 should pass", dfa.isAccepted("1001"));
        assertTrue("strings start with 1 and end with 0001 should pass", dfa.isAccepted("10001"));
        assertFalse("strings start with 0 should fail", dfa.isAccepted("011"));
    }
}