package week09;

/** Makes new interface for an Overhand shuffle.
 * @author Alishan Gokal, Kimberlene Sharma, Saptarshi Karmakar.
 */
public interface Overhand {

    /** Prints each element in deck.
     * @param size length of new deck*/
    public void makeNew(int size);

    /** Returns current state of deck.
      * @return the current state of the deck as an int[].
      * */
    public int[] getCurrent();
   
    /** Shuffles the current state of the deck according to parameter. 
      * @param blocks group sizes to be shuffled by.
      * @throws BlockSizeException if blocks has an error.
      */ 
    public void shuffle(int[] blocks) throws BlockSizeException;

    /** Returns the numebr of minimum number of times that the deck could be
      * shuffled using the same set of block sizes each time in order to return
      * the deck to its initial state.
      * @param blocks group sizes for shuffling.
      * @return number of times shuffled.
      */
    public int order(int[] blocks);

    /** Returns the number of pairs of cards which were consecutive in the
      * original deck and are still consecutive(and in the same order) in
      * current state of the deck.
      * @return number of unbroken pairs in deck.*/
    public int unbrokenPairs();

}
