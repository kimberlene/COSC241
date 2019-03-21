/** COSC241 Lab 3
 * program that calculates and returns number of digits.
 * and sum of the digits of the arguments.
 * 19th March, 2017, Semester 1.
 * @author Kimberlene Sharma
 * @param n stores the user inputerd number.
 */
package week03;
import java.util.Scanner;
/** RecursiveApp class to count and return number and sum of digits.
 *@author Kimberlene Sharma
 */
public class RecursiveApp {

    /** digits method to calculate and return number of digits.
     * @return returns an int value of number of digits.
     * @param n stores the user inputed number.
     */
    public static long digits(long n) {
        long num = Math.abs(n);
        int dig = 0;
        while (num > 0) {
            num = num / 10;
            dig++;
        }
        return dig;
    }
    /** sumOfDigits calculates and returns the sum of the digits.
     * @return returns long value for dum of digits.
     * @param n stores user inputed number to work on.
     */
    public static long sumOfDigits(long n) {
        long sum = 0;
        for (long i = Math.abs(n); i > 0; i = i / 10) {
            sum = sum + (i % 10);
        }
        if (n < 0) {
            sum = -sum;
        }
        return sum;

    }

    /** main method of RecursiveApp class calls methods to print results.
     * @param args array of string.
     */
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter a number");
        long n = sc.nextLong();
        System.out.println("no. of digits = " + digits(n));
        System.out.println("sum of digits= " + sumOfDigits(n));
    }
}
