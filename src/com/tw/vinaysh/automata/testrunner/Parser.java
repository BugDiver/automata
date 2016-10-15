package com.tw.vinaysh.automata.testrunner;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Parser {

    public TestRunner parse(String text ,IDFAGenerator generator) {
        TestRunner runner= new TestRunner();
        text = text.replaceAll("\\\\","");
        text = text.substring(1,text.length() -1);

        JSONArray list = new JSONArray(text);
        for (Object testCase : list) {
            String name = ((JSONObject) testCase).getString("name");
            String type = ((JSONObject) testCase).getString("type");
            JSONObject tuple = ((JSONObject) testCase).getJSONObject("tuple");
            JSONArray passCases = ((JSONObject) testCase).getJSONArray("pass-cases");
            JSONArray failCases = ((JSONObject) testCase).getJSONArray("fail-cases");

            IDFA dfa =  generator.generate(createStates(tuple.getJSONArray("states")),
                    createAlphabetSets(tuple.getJSONArray("alphabets")),
                    createTransitionFunction(tuple.getJSONObject("delta")),
                    new State(tuple.getString("start-state")),
                    createStates(tuple.getJSONArray("final-states")));

            runner.add(new TestCase(name,dfa,asStringList(passCases),asStringList(failCases)));
        }
        return runner;
    }

    private static TransitionFunction createTransitionFunction(JSONObject transitions) {
        TransitionFunction tf = new TransitionFunction();
        for (String s : transitions.keySet()) {
            State state = new State(s);
            Transition transition = new Transition();
            for (String alphabet : transitions.getJSONObject(s).keySet()) {
                transition.addTransition(alphabet, new State(transitions.getJSONObject(s).getString(alphabet)));
            }
            tf.addTransition(state, transition);
        }
        return tf;
    }

    private static HashSet<String> createAlphabetSets(JSONArray alphabetsArray) {
        HashSet<String> alphabets = new HashSet<>();
        for (Object alphabet : alphabetsArray) {
            alphabets.add((String)alphabet);
        }
        return alphabets;
    }

    private static HashSet<State> createStates(JSONArray statesArray) {
        HashSet<State> states = new HashSet<>();
        for (Object state : statesArray) {
            states.add(new State((String) state));
        }
        return states;
    }

    private List<String> asStringList(JSONArray arr){
        List<String> list = new ArrayList<>();
        for (Object o : arr) {
            list.add((String)o);
        }
        return list;
    }
}
