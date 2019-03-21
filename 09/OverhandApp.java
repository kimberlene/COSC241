package week09;

import java.util.*;

/** Allows user to interact with OverhandShuffler.
 * @author Alishan Gokal, Kimberlene Sharma, Saptarshi Karmakar.*/
public class OverhandApp {
    
    /** creates new OverhandShuffler object. */
    static OverhandShuffler o = new OverhandShuffler();
    /** Stores parameters in commands. */
    static int[] arr;
    /** Used to store parameters in commands. */
    static StringBuilder a;
 
    /** Main method.
     * @param args cli arguments.
     */
    public static void main(String[] args) {
        StringBuilder s = new StringBuilder();
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            handleLine(s, input.nextLine());
        }
    }

    /** Handles the imputed command. 
     * @param str where the numbers are read.
     * @param input the inputed command.*/
    public static void handleLine(StringBuilder str, String input) { 
        Scanner scan = new Scanner(input);
        //int[] arr;
        if (scan.hasNext()) {
            String command = scan.next();
            switch (command) {
                case "make-new": case "m": // make a new ordered deck
                    if(scan.hasNextInt()){
                        o.makeNew(scan.nextInt());
                    }
                    break;
                case "print": case"p": // load ints as a string
                    o.display();
                    break;
                case "shuffle": case"s":
                    // reads the ints following the command 
                    // and passes them to shuffle
                    a = new StringBuilder(); 
                    while (scan.hasNextInt()){
                        a.append(scan.nextInt()+" ");
                    } 
                    intArr(a);
                    try {
                        o.shuffle(arr);
                    } catch(Exception zz){
                        System.out.println("Exception Occured"+zz);
                    } 
                    break;
                case "order": case"o":
                    // reads the ints following the command 
                    // and passes them to order
                    a = new StringBuilder();
                    while (scan.hasNextInt()){
                        a.append(scan.nextInt()+" ");
                    }
                    intArr(a);
                    System.out.println(o.order(arr));
                    break;
                case "unbroken-pairs": case"u": 
                    // prints result of unbrokenPairs
                    System.out.println(o.unbrokenPairs());
                    break;
                case "random-shuffle": case"r": 
                    // calls randomShuffle on current deck
                    o.randomShuffle();
                    break;
                case "count-shuffles": case"c": //prints result of countShuffles
                    if(scan.hasNextInt()){
                        System.out.println(o.countShuffles(scan.nextInt()));
                    }
                    break;
                case "load": case"l": 
                    // loads deck with givin numbers with no error checking
                    a = new StringBuilder();
                    while(scan.hasNextInt()){
                        a.append(scan.nextInt()+" ");
                    }
                    intArr(a);
                    o.load(arr);
                    break;
                case "try": case "t":
                    //calls tryRepreat
                    o.tryRepeat();
                    break;
            }
        }
    }

    /** Converts stringBuilder to int[].
     * @param a StringBuilder that has inputed integers.
     * @return int array with numbers.
     */
    public static int[] intArr(StringBuilder a){
        String[] numbers = a.toString().split(" ");
        arr = new int[numbers.length];
        for (int c=0; c<numbers.length; c++){
            arr[c] = Integer.parseInt(numbers[c]);
        }
        return arr;
    }
}
