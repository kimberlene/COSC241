package week09;

/** Creates custom exception to be thrown by OverhandShuffler.
 * @author Alishan Gokal, Kimberlene Sharma, Saptarshi Karmakar*/
public class BlockSizeException extends Exception {

    /** Serial value to not give error when compiling.*/
    private static final long serialVersionUID = 123456;

    /** BlockSizeException constructor.
     * @param s passes error string to Exeption class.
     */
    BlockSizeException(String s) {
        super(s);
    }
}
