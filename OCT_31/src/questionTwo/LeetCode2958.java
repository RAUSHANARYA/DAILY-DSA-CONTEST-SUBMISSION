package questionTwo;

import java.util.*;

public class LeetCode2958 {

    /*
     * Question: Length of Longest Subarray With at Most K Frequency
     *
     * Given an integer array nums and an integer k,
     * find the longest contiguous subarray in which
     * every element appears at most k times.
     *
     * Approach: Sliding Window + HashMap
     *
     * Step 1: Initialize left = 0 and right = 0.
     *
     * Step 2: Expand the window by moving right.
     *
     * Step 3: Store the frequency of each element in HashMap.
     *
     * Step 4: If frequency of the current element exceeds k,
     *         shrink the window by moving left.
     *
     * Step 5: Update maximum window length.
     *
     * Time Complexity: O(N) average
     * Space Complexity: O(N)
     */

    static int maxSubarrayLength(int[] nums, int k) {

        int l = 0;
        int r = 0;
        int maxLen = 0;
        int n = nums.length;

        HashMap<Integer, Integer> map = new HashMap<>();

        // Traverse using sliding window
        while (r < n) {

            // Add current element to the window
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);

            // If frequency exceeds k, shrink the window
            while (map.get(nums[r]) > k) {

                map.put(nums[l], map.get(nums[l]) - 1);

                if (map.get(nums[l]) == 0) {
                    map.remove(nums[l]);
                }

                l++;
            }

            // Update maximum valid window length
            maxLen = Math.max(maxLen, r - l + 1);

            r++;
        }

        return maxLen;
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

        // Input maximum allowed frequency
        System.out.println("Enter K:");
        int k = sc.nextInt();

        // Call function
        int result = maxSubarrayLength(nums, k);

        // Print result
        System.out.println("Maximum Subarray Length: " + result);

        sc.close();
    }
}