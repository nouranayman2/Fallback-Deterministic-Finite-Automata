# Fallback-Deterministic-Finite-Automata
For this task you need to implement a fallback deterministic finite automaton with actions (FDFA) abstract data type. Recall that an FDFA is a sextuple (Q, Σ, δ, q0, F, A): Q is a non- empty, finite set of states; Σ is non-empty, finite set of symbols (an alphabet); δ : Q×Σ −→ Q is the transition function; q0 ∈ Q is the start state; F ⊆ Q is the set of accept states; and A is function that maps every state in Q to an action
Requirements:
I should implement a class constructor FallbackDfa and a method run.

a)FallbackDfa, a class constructor, takes one parameter which is a string description of an FDFA and constructs an FDFA instance as per the description. A string describing an FDFA is of the form Q#A#T#I#F.

b)run simulates the operation of the constructed FDFA on a given string, and returns a semicolon-separated sequence of tokens.
