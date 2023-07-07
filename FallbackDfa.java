package csen1002.main.task3;

import java.util.*;
/**
 * Write your info here
 *
 * Nouran Ayman Jane Smith
 *  46-0328
 * t- 15
 */

public class FallbackDfa {

    String[] states;
    String alphabet;
    String[] transitions;
    Integer startState;
    Integer[] acceptStates;

    Stack<String> stack = new Stack<String>();

    /**
     * Constructs a Fallback DFA
     *
     * @param fdfa A formatted string representation of the Fallback DFA. The string
     *             representation follows the one in the task description
     */
    public FallbackDfa(String fdfa) {

        String[] afterhash = fdfa.split("#");
        String[] statex = afterhash[0].split(",");
        states = new String[statex.length];
        for (int i = 0; i < statex.length; i++) {
            states[i] = statex[i];
        }
        alphabet = afterhash[1];

        String[] transitionArray = afterhash[2].split(";");
        transitions = new String[transitionArray.length];
        for (int i = 0; i < transitionArray.length; i++) {
            transitions[i] = transitionArray[i];
        }
        startState = Integer.parseInt(afterhash[3]);
        String[] z = afterhash[4].split(";");
        acceptStates = new Integer[z.length];
        for (int i = 0; i < z.length; i++) {
            acceptStates[i] = Integer.parseInt(z[i]);
        }
//        String testInput = "baababb";
//        String output = run(testInput);
//        System.out.println(output);


    }
//
//    /**
//   //  * @param input The string to simulate by the FDFA.
//     * @return Returns a formatted string representation of the list of tokens. The
//     * string representation follows the one in the task description
//     */
    public String run(String input) {
        String finalresult="";
        String mysubstring="";
        int n=-1;
        int rightptr = 0;
        Stack<Integer> stack = new Stack<>();

        //Stack<Integer> resultStack = new Stack<>();



       // System.out.println("Stack " + stack);
         while (rightptr<input.length()) {
             stack = new Stack<>();
             stack.push(startState);
             for (int l = rightptr; l < input.length(); l++) {
                 int currentState = stack.peek();
                 for (int i = 0; i < transitions.length; i++) {
                     String[] cell = transitions[i].split(",");
                     int fromState = Integer.parseInt(cell[0]);
                     char character = cell[1].charAt(0);
                     int toState = Integer.parseInt(cell[2]);
                  //   System.out.println("From state: " + fromState + ", Character: " + character + ", To state: " + toState);

                     if (currentState == fromState && character == input.charAt(l)) {
                         stack.push(toState);
                         break;

                     }

                 }
                 //    System.out.println("resultStack " + stack);
                 // System.out.println(stack);
             }

                int leftptr=input.length()-1;
                 char c = input.charAt(rightptr);
                // Stack<Integer> finalStack = new Stack<>();

                boolean a=false;
             int poppedstate =stack.peek();
             if (stack.size() > 0) {
                     int j = stack.peek();

                     for ( ;leftptr >=rightptr; leftptr--) {
                         j=stack.peek();
                         System.out.println(stack);
                         for (int as = 0; as < acceptStates.length; as++) {
                             if (j == acceptStates[as]) {
                                 a=true;
                                 n=j;
                                 mysubstring=input.substring(rightptr,leftptr+1);
                             }

                         }
                         if(a)
                         break;
                         else
                         stack.pop();
                     }
                     if(leftptr>=rightptr ){
                         finalresult+=mysubstring+"," + n+";";
                        rightptr=leftptr+1;
                     }
                     else {
                         finalresult += input.substring(rightptr) + "," + poppedstate;
                         break;
                     }
                 }

      }
        // TODO Auto-generated method stub


        if(finalresult.charAt(finalresult.length()-1)==';')
        finalresult=finalresult.substring(0,finalresult.length()-1);

       return finalresult;
    }


        public static void main (String[]args){
            String fdfa = "0;1;2;3;4;5;6;7;8;9;10;11;12;13#r;t;x#0,r,3;0,t,10;0,x,1;1,r,8;1,t,12;1,x,6;2,r,0;2,t,4;2,x,9;3,r,2;3,t,2;3,x,4;4,r,6;4,t,11;4,x,11;5,r,4;5,t,6;5,x,5;6,r,5;6,t,13;6,x,5;7,r,11;7,t,9;7,x,3;8,r,6;8,t,0;8,x,8;9,r,4;9,t,9;9,x,4;10,r,13;10,t,0;10,x,6;11,r,8;11,t,6;11,x,2;12,r,7;12,t,6;12,x,0;13,r,8;13,t,6;13,x,2#12#3;9";
            FallbackDfa myDfa = new FallbackDfa(fdfa);
           System.out.println( myDfa.run("xrxrxtxtxxrx"));


            System.out.println("States: " + Arrays.toString(myDfa.states));
            System.out.println("Alphabet: " + myDfa.alphabet);
            System.out.println("Transitions: " + Arrays.toString(myDfa.transitions));
            System.out.println("Start state: " + myDfa.startState);
            System.out.println("Accept states: " + Arrays.toString(myDfa.acceptStates));


        }

    }
