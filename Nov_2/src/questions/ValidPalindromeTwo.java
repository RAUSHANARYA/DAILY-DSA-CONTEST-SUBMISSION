
package questions;

import java.util.*;

public class ValidPalindromeTwo {

    /*
     * Question: Valid Palindrome II
     *
     * Given a string s, return true if it can become a palindrome
     * after deleting at most one character.
     */

    // Main function
    static boolean validPalindrome(String s) {

        int l = 0;
        int r = s.length() - 1;

        // Step 1: Check characters from both ends
        while (l < r) {

            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            }
            else {

                // Step 2: Try deleting either the left or right character
                return palindrome(l + 1, r, s) ||
                       palindrome(l, r - 1, s);
            }
        }

        return true;
    }

    // Helper function to check whether a substring is a palindrome
    static boolean palindrome(int start, int end, String s) {

        while (start < end) {

            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input string
        String s = sc.nextLine();

        // Call static method
        boolean result = validPalindrome(s);

        // Print result
        System.out.println(result);

        sc.close();
    }
}
