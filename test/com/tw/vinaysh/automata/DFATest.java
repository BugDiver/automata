package com.tw.vinaysh.automata;

import com.tw.vinaysh.automata.testrunner.State;
import com.tw.vinaysh.automata.testrunner.Transition;
import com.tw.vinaysh.automata.testrunner.TransitionFunction;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DFATest {
    @Test
    public void testValidatesShouldValidateAString() {
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

        Set<String> alphabets = new HashSet<String>() {{
            add("0");
            add("1");
        }};

        DFA dfa = new DFA(setOfStates, alphabets, transitionFunction, q1state,finalStates);
        assertTrue(dfa.validates("00011"));
        assertFalse(dfa.validates("0000"));
    }

}