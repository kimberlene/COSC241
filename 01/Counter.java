package week01;
import java.util.Scanner;
/**Cosc 241 Sem 1 Lab 01
 *Program to print the total number of words and lines of an input.
 *@author Kimberlene Sharma
 *01.03.2017
 */

public class Counter { /** Counter class to print total lines and words.
                        * * @param args array of String.
                        */
    public static void main(String[] args) {
        /** main method of Couner class. */

        int wordcount = 0; /** counter variable to count number of words */
        int linecount = 0; /** counter variable to count number of lines */

        Scanner sc1 = new Scanner(System.in); /**sc1 is first Scanner object*/

        while (sc1.hasNextLine()) {
            /** to check for  another line */
            linecount++;
            String str = sc1.nextLine(); /** sc2 is seconfd scanner object */
            Scanner sc2 = new Scanner(str);

            while (sc2.hasNext()) { /** to check for  another word */

                wordcount++;
                sc2.next();
            }
        }
        /** to print output with appropriate messages */
        System.out.println("lines: " + linecount);
        System.out.println("words: " + wordcount);
    }
}
