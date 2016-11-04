package com.tw.vinaysh.automata.testrunner;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class Parser {

    public  List<TestCase> parse(String text) {
        text = text.replaceAll("\\\\","");
        text = text.substring(1,text.length() -1);
        ArrayList<TestCase> allTestCases = new ArrayList<>();
        JSONArray list = new JSONArray(text);
        for (Object test : list) {
            String name = ((JSONObject) test).getString("name");
            String type = ((JSONObject) test).getString("type");
            JSONObject tuple = ((JSONObject) test).getJSONObject("tuple");
            JSONArray passCases = ((JSONObject) test).getJSONArray("pass-cases");
            JSONArray failCases = ((JSONObject) test).getJSONArray("fail-cases");
            TestCase testCase = new TestCase(name, type,createTuple(tuple,type), asStringList(passCases), asStringList(failCases));
            allTestCases.add(testCase);
        }
        return allTestCases;
    }

    private Tuple createTuple(JSONObject tuple,String type) {
        HashSet<State> states = createStates(tuple.getJSONArray("states"));
        HashSet<String> alphabets = createAlphabetSets(tuple.getJSONArray("alphabets"));
        TransitionFunction tf = createTransitionFunction(tuple.getJSONObject("delta"),type);
        State startState = new State(tuple.getString("start-state"));
        HashSet<State> finalStates = createStates(tuple.getJSONArray("final-states"));
        return new Tuple(states,alphabets,tf,startState,finalStates);
    }

    private  TransitionFunction createTransitionFunction(JSONObject transitions,String type) {
        TransitionFunction tf = new TransitionFunction();
        for (String s : transitions.keySet()) {
            State state = new State(s);
            Transition transition = new Transition();
            for (String alphabet : transitions.getJSONObject(s).keySet()) {
                if (type.equals("dfa")){
                    transition.addTransition(alphabet,new State(transitions.getJSONObject(s).getString(alphabet)));
                }else{
                    transition.addTransition(alphabet,asStateArray(transitions.getJSONObject(s).getJSONArray(alphabet)));
                }
            }
            tf.addTransition(state, transition);
        }
        return tf;
    }

    private State[] asStateArray(JSONArray jsonArray) {
        State[] states = new State[jsonArray.length()];
        for (int i = 0; i < jsonArray.length(); i++) {
            states[i] = new State(jsonArray.getString(i));
        }
        return states;
    }

    private  HashSet<String> createAlphabetSets(JSONArray alphabetsArray) {
        HashSet<String> alphabets = new HashSet<>();
        for (Object alphabet : alphabetsArray) {
            alphabets.add((String)alphabet);
        }
        return alphabets;
    }

    private  HashSet<State> createStates(JSONArray statesArray) {
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
