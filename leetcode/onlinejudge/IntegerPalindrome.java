package leetcode.onlinejudge;

/**
 * Created by Oliver on 10/19/14.
 *
 * Problem:
 * Determine whether an integer is a palindrome. Do this without extra space.
 *
 * Intended solution.  Reverse the integer using division and adding to a separate
 * integer.  Compare if they match.
 */
public class IntegerPalindrome {
    public boolean isPalindrome(int x) {
        int reversedValue = 0;
        int x_copy = x;

        if (x < 0) {
            // Or throw an exception
            return false;
        }

        while (x_copy >= 10) {
            // Get the x %10 and add that to reversedValue
            // On the next iteration, multiply reversedValue by 10
            // x needs to be flipped.
            // x_copy, will divide by 10

            reversedValue += x_copy % 10;
            x_copy /= 10;

            //System.out.println("ReversedVal " + reversedValue);
            //System.out.println("x_copy " + x_copy);
            reversedValue *= 10;
        }

        reversedValue += x_copy;

        return (x == reversedValue);
    }

    public static void main(String[] args) {
        Integer inputVal = 1;
        IntegerPalindrome ip = new IntegerPalindrome();
        System.out.println("Is " + inputVal + " a Palindrome?");
        System.out.println(ip.isPalindrome(inputVal));
    }
}
