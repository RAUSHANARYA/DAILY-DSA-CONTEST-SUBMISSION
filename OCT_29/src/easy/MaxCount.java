package easy;

import java.util.*;

public class MaxCount {

    /*
     * Question: Count Record-Breaking Elements
     *
     * Given an array, count the elements that are
     * strictly greater than all previous elements.
     *
     * Approach: Traversal
     *
     * Step 1: Initialize max with Integer.MIN_VALUE.
     *
     * Step 2: Traverse the array.
     *
     * Step 3: If arr[i] > max:
     *         - Increment count.
     *         - Update max = arr[i].
     *
     * Step 4: Return count.
     *
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */

    static int countRecords(int[] arr) {

        int max = Integer.MIN_VALUE;
        int count = 0;

        // Traverse the array
        for (int i = 0; i < arr.length; i++) {

            // Check if current element is a new maximum
            if (arr[i] > max) {

                count++;
                max = arr[i];
            }
        }

        return count;
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
        int result = countRecords(arr);

        // Print result
        System.out.println("Total Records: " + result);

        sc.close();
    }
}