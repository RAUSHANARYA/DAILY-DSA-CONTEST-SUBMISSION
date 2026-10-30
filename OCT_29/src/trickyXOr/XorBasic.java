package trickyXOr;

import java.util.*;

public class XorBasic {

    /*
     * Question: Single Number
     *
     * Given an array where every element appears twice
     * except one element that appears only once.
     * Find the non-repeating element.
     *
     * Approach: Bit Manipulation using XOR
     *
     * XOR Properties:
     * 1. a ^ a = 0
     * 2. a ^ 0 = a
     * 3. XOR is commutative and associative.
     *
     * Step 1: Initialize xor = 0.
     *
     * Step 2: XOR all array elements.
     *
     * Step 3: Duplicate elements cancel each other.
     *
     * Step 4: The remaining XOR is the unique element.
     *
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */

    static int singleNumber(int[] arr) {

        int xor = 0;

        // XOR all elements
        for (int i = 0; i < arr.length; i++) {
            xor = xor ^ arr[i];
        }

        return xor;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input array size
        System.out.println("Enter array size:");
        int n = sc.nextInt();

        // Input array elements
        int arr[] = new int[n];

        System.out.println("Enter array elements:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Call function
        int result = singleNumber(arr);

        // Print unique element
        System.out.println("Non-repeating element: " + result);

        sc.close();
    }
}