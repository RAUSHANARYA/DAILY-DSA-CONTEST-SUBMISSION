package questions;

import java.util.*;

public class ClosestPairSum {

    /*
     * Question: Closest Pair Sum
     *
     * Find a pair whose sum is closest to the given target.
     * If multiple pairs have the same closest sum,
     * choose the pair with the maximum difference between elements.
     */

    static ArrayList<Integer> sumClosest(int[] arr, int target) {

        ArrayList<Integer> ans = new ArrayList<>();

        int n = arr.length;

        if (n < 2) {
            return ans;
        }

        // Step 1: Sort the array
        Arrays.sort(arr);

        int left = 0;
        int right = n - 1;

        long minDiff = Long.MAX_VALUE;
        long maxPairDiff = Long.MIN_VALUE;

        // Step 2: Apply Two Pointers
        while (left < right) {

            long sum = (long) arr[left] + arr[right];

            long diff = Math.abs(sum - target);

            long pairDiff = (long) arr[right] - arr[left];

            // Step 3: Update the best pair
            if (diff < minDiff ||
                (diff == minDiff && pairDiff > maxPairDiff)) {

                minDiff = diff;
                maxPairDiff = pairDiff;

                ans.clear();
                ans.add(arr[left]);
                ans.add(arr[right]);
            }

            // Step 4: Move pointers
            if (sum < target) {
                left++;
            }
            else if (sum > target) {
                right--;
            }
            else {
                break;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input array size
        int n = sc.nextInt();

        // Input array elements
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Input target
        int target = sc.nextInt();

        // Call static method
        ArrayList<Integer> result = sumClosest(arr, target);

        // Print result
        if (result.isEmpty()) {
            System.out.println("No valid pair");
        } else {
            System.out.println(result);
        }

        sc.close();
    }
}