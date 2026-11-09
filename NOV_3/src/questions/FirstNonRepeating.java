
package questions;

import java.util.*;

public class FirstNonRepeating {

    /*
     * Question: First Non-Repeating Character in a Stream
     *
     * Given a string, process characters one by one.
     * After each character, find the first non-repeating
     * character in the stream.
     *
     * If no non-repeating character exists, append '#'.
     */

    static String firstNonRepeating(String s) {

        // Step 1: Frequency array
        int[] freq = new int[26];

        // Step 2: Queue to maintain character order
        Queue<Character> q = new LinkedList<>();

        StringBuilder ans = new StringBuilder();

        // Step 3: Process each character
        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // Update frequency
            freq[ch - 'a']++;

            // Add current character to queue
            q.offer(ch);

            // Step 4: Remove repeating characters from the front
            while (!q.isEmpty() && freq[q.peek() - 'a'] > 1) {
                q.poll();
            }

            // Step 5: Store the first non-repeating character
            if (q.isEmpty()) {
                ans.append("#");
            }
            else {
                ans.append(q.peek());
            }
        }

        return ans.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input string
        String s = sc.nextLine();

        // Call static method
        String result = firstNonRepeating(s);

        // Print result
        System.out.println(result);

        sc.close();
    }
}
