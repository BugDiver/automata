# automata
A repo for my automata learning.

# DFA

A DFA generator will accept a 5 tuple that consists of a set of states, an alphabet set, a transition function, an initial state and a set of final states. It will return a DFA which in turn can determine whether a string is in that language or not.

Please ensure that the 5 tuples can be specified as a JSON object in a file. The transition function can be written as a transition table:

ex:
```
q1,1,q1
q1,0,q2
...
...
```
## How to use

* Download the jar from [here](https://github.com/BugDiver/automata/blob/master/testRunner.jar).
* Add the jar in your project as a dependency.
* Create a DFA class which implements IDFA.
```
    public class DFA implements IDFA {
        @Override
        public boolean validates(String input) {
            // write your code here.
        }
    }

```

* Create a DFAGenerator class which implements IDFAGenerator.
```
    public class DFAGenerator implements IDFAGenerator{
        @Override
        public IDFA generate(Set<State> setOfStates, Set<String> alphabets, TransitionFunction tf, State initialState, Set<State> finalStates) {
            // return a IDFA here
        }
    }
 ```
* Read your JSON file which contains your test cases in a specific format(see the format [here](https://github.com/BugDiver/automata/blob/master/examples.json))
* Get TestRunner from parser by passing your json string and DFAGeneratior to it.
```
    public class YourClass {
        public static void main(String[] args){
            String text = your json string
            Parser parser = new Parser();
            DFAGenerator gen = new DFAGenerator();
            TestRunner runner = parser.parse(text,gen);
            runner.runAllTestCases();
        }
    }
```
* Run your test using runner's methods.
```
    public class YourClass {
        public static void main(String[] args){
            String text = your json string
            Parser parser = new Parser();
            DFAGenerator gen = new DFAGenerator();
            TestRunner runner = parser.parse(text,gen);

            runner.runAllTestCases();

            // or

            runner.runOnlyPassingScenarios();

            // or

            runner.runOnlyFailingScenarions;

        }
    }
```

* See output on the console.
```
an odd number of zeroes
		"00" should fail but passing.
		"0000" should fail but passing.
		"1001" should fail but passing.
		"1010" should fail but passing.
		"001100" should fail but passing.

even number of zeroes
		"0" should fail but passing.
		"000" should fail but passing.
		"00000" should fail but passing.
		"10" should fail but passing.
		"101010" should fail but passing.
		"010101" should fail but passing.
```
