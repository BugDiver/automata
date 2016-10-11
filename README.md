# automata
A repo for my automata learning.

# DFA

A DFA generator will accept a 5 tuple that consists of a set of states, an alphabet set, a transition function, an initial state and a set of final states. It will return a DFA which in turn can determine whether a string is in that language or not.

Please ensure that the 5 tuple can be specified as a JSON object in a file. The transition function can be written as a transition table:

ex:
```
q1,1,q1
q1,0,q2
...
...
```
