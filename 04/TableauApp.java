package week04;
/**
 * Skeleton code for an array based implementation of Young's tableau.
 * COSC241, Lab 4, 26th March.
 * @author Kimberlene Sharma
 */
public class TableauApp {

    /**
     * The main method is just used for testing.
     * @param args command line arguments are not used.
     */
    public static void main(String[] args) {
        final int[][] valid = {
            {
                1,
                4,
                5,
                10,
                11
            },
            {
                2,
                6,
                8
            },
            {
                3,
                9,
                12
            },
            {
                7
            }
        };
        System.out.println(TableauApp.toString(valid));
    }

    /**
     * Determines whether the array passed to it is a valid tableau or not.
     * @param t a two-dimensional array to test for tableau-ness
     * @return true if the parameter is a valid tableau, otherwise false
     */
    public static boolean isTableau(int[][] t) {
        return (isSetOf1toN(t) && rowValuesIncrease(t) && 
                rowLengthsDecrease(t) && columnValuesIncrease(t));
    }

    /**
     *  Returns a string representation of an array based tableau.
     * @param t a two-dimensional array which represents a tableau.
     * @return a string representation of an array based tableau.
     */
    public static String toString(int[][] t) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                result.append(String.format("%-4s", t[i][j]));
            }
            if (i < t.length - 1) {
                result.append("\n");
            }
        }
        return result.toString();
    }

    /**
     * returs a boolean value to check if row lengths are decreasing.
     * @return true if row lengths are decreasing else false.
     * @param t is a two-dimensional array.
     */
    public static boolean rowLengthsDecrease(int[][] t) {
        int rows = 0;
        for (int i = 0; i < t.length - 1; i++) {
            if (t[i].length >= t[i + 1].length) {
                rows++;
            }
        }
        return (rows == t.length - 1);
    }
        /**
         * returs a boolean value to check if row values are increasing.
         * @return true if row values are increasing else false.
         * @param t is a two-dimensional array.
         */
    public static boolean rowValuesIncrease(int[][] t) {
        int count = 0;
        int columnCount = 0;
        for (int i = 0; i < t.length; i++) {
            count = 0;
            for (int j = 0; j < t[i].length - 1; j++) {
                if (t[i][j] < t[i][j + 1]) {
                    count++;
                }
            }
            if (count == (t[i].length - 1)) {
                columnCount = 1;
            } else {
                columnCount = 0;
                break;
            }
        }

        return (columnCount == 1);
    }

    /** checks that the columns values increase on going dow.
     * @return true if column values are increasing.
     * @param t is a two-dimensional array to be checked.
     */
    public static boolean columnValuesIncrease(int[][] t) {
        boolean result = true;
        int nextRowCount = t.length;
        int rowCount = 0;
        for (int i = 0; i < t[0].length; i++) {
            for (int j = 0; j < nextRowCount - 1; j++) {
                if (result) {
                    result = t[j][i] < t[j + 1][i];
                }
            }
            if (i > nextRowCount) {
                rowCount--;
            }
            nextRowCount = t[rowCount + 1].length;
            rowCount++;
        }
        return result;
    }

    /** checks if the integers used wer from 1 to n.
     * @return true if the tableau has integers between 1 and n.
     * @param t is the two-dimensional array to be checked.
     */
    public static boolean isSetOf1toN(int[][] t) {
        int count = 0;
        boolean c = false;
        boolean tab = false;

        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                count++;
                for (int k = 0; k < t.length; k++) {
                    for (int l = 0; l < t[k].length; l++) {
                        if (count == t[k][l] && c) {
                            return false;
                        } else if (count == t[k][l]) {
                            c = true;
                            tab = true;
                        }
                    }
                }
                if (!tab) {
                    return false;
                }
                tab = false;
                c = false;
            }
        }
        return true;
    }
}
