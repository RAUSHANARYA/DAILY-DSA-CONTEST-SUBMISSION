package pattern3;

import java.util.*;

public class TwoUniqueNo {

    /*
     * Question: Single Number III - Two Unique Numbers
     *
     * Given an array where every element appears twice
     * except two elements that appear only once.
     * Find those two unique elements.
     *
     * Approach: Bit Manipulation using XOR
     *
     * Step 1: XOR all elements.
     *         xor = a ^ b
     *
     * Step 2: Isolate the rightmost set bit.
     *         bit = xor & -xor
     *
     * Step 3: Divide elements into two groups
     *         based on the isolated bit.
     *
     * Step 4: XOR both groups separately.
     *
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */

    static int[] singleNumber(int[] nums) {

        // Step 1: XOR all elements
        int xor = 0;

        for (int x : nums) {
            xor ^= x;
        }

        // Step 2: Isolate the rightmost set bit
        int bit = xor & -xor;

        int a = 0;
        int b = 0;

        // Step 3: Divide elements into two groups
        for (int x : nums) {

            if ((x & bit) == 0) {
                a ^= x;
            } else {
                b ^= x;
            }
        }

        // Step 4: Return both unique numbers
        return new int[]{a, b};
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input array size
        System.out.println("Enter array size:");
        int n = sc.nextInt();

        // Input array elements
        int nums[] = new int[n];

        System.out.println("Enter array elements:");

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Call function
        int result[] = singleNumber(nums);

        // Print both unique numbers
        System.out.println("Two unique numbers:");

        for (int x : result) {
            System.out.print(x + " ");
        }

        sc.close();
    }
}