package week09;
import java.util.Arrays;
import java.io.PrintStream;

/** Creates a deck of cards that can be shuffled with a Overhand shuffle.
 * @author Alishan Gokal, Kimberlene Sharma, Saptarshi Karmakar.*/
public class OverhandShuffler{

    /** Represents a deck of cards. */
    private int[] deck = new int[0];

    /** Makes new deck containning size cards from 0 to size-1.
     * @param size amount of cards in deck.
     */
    public void makeNew(int size) {
        this.deck = new int[size];

        for (int i = 0; i < deck.length; i++) {
            deck[i] = i;
        }
    }

    /** Prints each element in deck.
     * */
    public void display() {
        System.out.println(Arrays.toString(deck));
    }

    /** Returns current state of deck.
     * @return the current state of the deck as an int[].
     * */
    public int[] getCurrent() {
        return this.deck;
    }

    /** Shuffles the current state of the deck according to parameter. 
     * @param blocks group sizes to be shuffled by.
     * @throws BlockSizeException if blocks has an error.
     */
    public void shuffle(int[] blocks) throws BlockSizeException{
        int[] copy = getCurrent();
        int[] shuffle = new int[copy.length];
        int sum = 0;
        int n = 0;
        String s = "";
        for (int x = 0; x < blocks.length; x++) {
            sum += blocks[x];
        }
        for (int i = 0; i < blocks.length; i++) {
            if (blocks[i] <= 0) {
                throw new BlockSizeException("Negative Number or Zero");
            } else {
                if (sum != copy.length) {
                    throw new BlockSizeException
                    ("Sum of Entrees not equal to Deck size");
                }
            }
            int b = blocks[i];
            shuffle = Arrays.copyOfRange(copy, n, (b + n));
            s = Arrays.toString(shuffle) + s;
            n += b;
        }

        s = s.replaceAll(",", " ");
        s = s.replace("[", " ");
        s = s.replace("]", " ");
        String[] numbers = s.split(" ");
        shuffle = new int[copy.length];
        int w = 0;
        for (int c = 0; c < numbers.length; c++) {
            if (!numbers[c].equals(" ") && !numbers[c].equals("")) {
                shuffle[w] = Integer.parseInt(numbers[c]);
                w++;
            }
        }
        deck = shuffle;
    }

    /** Returns the numebr of minimum number of times that the deck could be
     * shuffled using the same set of block sizes each time in order to return
     * the deck to its initial state.
     * @param blocks group sizes for shuffling.
     * @return number of times shuffled.
     */
    public int order(int[] blocks) {
        int count = 1;
        int[] old = getCurrent();
        try {
            shuffle(blocks);
        } catch (Exception e) {
            System.out.println("Exception Occured :" + e);
        }
        try {
            while (!Arrays.equals(old, deck)) {
                count++;
                shuffle(blocks);
            }
        } catch (Exception d) {
            System.out.println("Exception Occured :" + d);
        }
        return count;
    }

    /** Preforms a random overhand shuffle using a break probability
     * of 0.1.*/
    public void randomShuffle() {
        int blen = 0;
        int[] b = new int[blen];
        String s = "";
        for (int i = 1; i < deck.length; i++) {
            double r = Math.random();
            final double breakNumber = .1;
            if (r <= breakNumber) {
                blen += 1;
                s += i + " ";
            }
        }
        if (s.equals("")) {
            s = Integer.toString(deck.length);
        }
        String[] numbers = new String[blen];
        numbers = s.split(" ");
        b = new int[numbers.length];
        for (int i = 0; i < blen; i++) {
            b[i] = Integer.parseInt(numbers[i]);
        }
        int sum = 0;
        for (int i: b) {
            sum += i;
        }
        if (sum < deck.length && sum != deck.length) {
            int[] bCopy = Arrays.copyOf(b, blen + 1);
            bCopy[bCopy.length - 1] = deck.length - sum;
            b = bCopy;
        } else if (sum > deck.length) {
            randomShuffle();
        } else {}
        try {
            shuffle(b);
        } catch (Exception abc) {
            System.out.println("Exception Occured :" + abc);
        }
    }

    /** Returns the number of pairs of cards which were consecutive in the
     * original deck and are still consecutive(and in the same order) in
     * current state of the deck.
     * @return number of unbroken pairs in deck.*/
    public int unbrokenPairs() {
        int count = 0;
        for (int c = 0; c < deck.length - 1; c++) {
            if (deck[c + 1] - deck[c] == 1) {
                count++;
            }
        }
        return count;
    }

    /** Counts the number of times a random shuffle is needed before the number
     * of unbroken pairs is less than the givin parameter.
     * @param unbrokenPairs number of unproken pairs to be checked against.
     * @return number of times a random shuffle is needed.*/
    public int countShuffles(int unbrokenPairs) {
        int pairCount = unbrokenPairs();
        int count = 0;
        while (pairCount >= unbrokenPairs) {
            randomShuffle();
            pairCount = unbrokenPairs();
            count++;
        }
        return count;
    }

    /** Loads the deck with parameter and no error checking.
     * @param cards numbers that are going to be set as deck.*/
    public void load(int[] cards) {
        deck = cards;
    }
    
    /**Prints explanation to why*/
    public void tryRepeat(){
        String msg = "tryRepeat() is not possible because after the second" +
            "shuffle. If the shuffle is complex, decuding the shuffle from the "+
            "second shuffle becomes difficult.";
        System.err.println(msg);
    }

}
