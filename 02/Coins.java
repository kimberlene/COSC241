package week02;
import java.util.Random;
/** Kimberlene Sharma.
 *  COSC241 Lab 2.
 *  @author Kimberlene Sharma.
 *  program to find out the number of heads,runs in a coin toss.
 */

public class Coins {
    /** Class coins having data fields HEADS and TAILs. */
    public static final boolean HEADS = true; /**final HEADS varible.*/
    public static final boolean TAILS = false; /**final TAILS variable.*/
    private boolean[] coins; /**array to store if heads or tails.*/
    /** basis constructor of class Coins.
     *  @param coins :array that stores the results of the coin toss.
     */
    public Coins(boolean[] coins) {
        this.coins = coins;
    }

    /** constructor creates Coins object from a string of characters H,T.
     *  @param c used to store String comprising H,T.
     */
    public Coins(String c) {

        coins = new boolean[c.length()];
        System.out.println(c);
        /** @param i,j are loop variables.*/
        for (int i = 0; i < c.length(); i++) {
            if (c.charAt(i) == 'H') {
                coins[i] = true;
            }
        }
        for (int j = 0; j < coins.length; j++) {
            System.out.print(coins[j] + " ");
        }
        System.out.println();
    }

    /**constructor creates Coins object of desired length.
     * @param length to store the desired length of array.
     */
    public Coins(int length) {
        coins = new boolean[length];
        Random ran = new Random();
        for (int k = 0; k < coins.length; k++) {
            /** determines random result of a coin toss */
            coins[k] = ran.nextBoolean();
        }
        for (int j = 0; j < coins.length; j++) {
            System.out.println(coins[j]);
        }

    }

    /** method to count and return number of heads.
     *  @return returns an int value.
     */
    public int countHeads() {
        /**  @param headCount used to count occurence of heads.*/
        int headCount = 0;
        for (int i = 0; i < coins.length; i++) {
            if (coins[i]) {
                headCount++;
            }
        }
        return headCount;
    }

    /** method to print string consisting of H,T.
     * @return returns a String value.
     */
    public String toString() {
        String str = "";
        for (int j = 0; j < coins.length; j++) {
            if (coins[j]) {
                str = str + "H";
            } else {
                str = str + "T";
            }
        }
        return str;

    }

    /** method to count number of runs in the sequence.
     *  @return returns an int value.
     */
    public int countRuns() {
        int count = 0;
        for (int i = 1; i < (coins.length); i++) {

            if (coins[i] != coins[i - 1]) {
                count++;
            }

        }
        return (count + 1);
    }


    /** main method of Coins where all methods are called.
     *  @param args :arguments of the main method.
     */
    public static void main(String args[]) {
        boolean[] b = {
            HEADS,
            TAILS,
            HEADS,
            HEADS,
            TAILS
        };
        Coins c = new Coins(b);
        System.out.println(c.countHeads());
        System.out.println(c.toString());
        System.out.println(c.countRuns());
        Coins c1 = new Coins(c.toString()); /** first object of Coins */
        Coins c2 = new Coins(10); /**first  object of Coins */
    }
}
