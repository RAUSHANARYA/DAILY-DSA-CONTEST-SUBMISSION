package medium;

import java.util.*;

public class CountSubarraysWithSumExactlyK {

    /*
     * Question: Count Subarrays With Sum Exactly K
     *
     * Given an integer array and a target sum K,
     * count the number of continuous subarrays
     * whose sum is exactly equal to K.
     *
     * Approach: Prefix Sum + HashMap
     *
     * Step 1: Initialize sum = 0 and count = 0.
     *
     * Step 2: Store (0, 1) in HashMap.
     *         This handles subarrays starting from index 0.
     *
     * Step 3: Traverse the array and calculate prefix sum.
     *
     * Step 4: Calculate remaining = sum - k.
     *
     * Step 5: If remaining exists in HashMap,
     *         add its frequency to count.
     *
     * Step 6: Update the frequency of current prefix sum.
     *
     * Step 7: Return count.
     *
     * Time Complexity: O(N) average
     * Space Complexity: O(N)
     */

    static long countSubarrays(int[] arr, long k) {

        // HashMap stores prefix sum and its frequency
        HashMap<Long, Long> map = new HashMap<>();

        long sum = 0;
        long count = 0;

        // Handle subarrays starting from index 0
        map.put(0L, 1L);

        // Traverse the array
        for (int i = 0; i < arr.length; i++) {

            // Calculate prefix sum
            sum += arr[i];

            // Find required previous prefix sum
            long remaining = sum - k;

            // Check if required prefix sum exists
            if (map.containsKey(remaining)) {
                count += map.get(remaining);
            }

            // Update frequency of current prefix sum
            map.put(sum, map.getOrDefault(sum, 0L) + 1);
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

        // Input target sum K
        System.out.println("Enter target sum K:");
        long k = sc.nextLong();

        // Call function
        long result = countSubarrays(arr, k);

        // Print result
        System.out.println("Total subarrays with sum K: " + result);

        sc.close();
    }
}