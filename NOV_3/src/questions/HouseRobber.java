
package questions;

import java.util.*;

public class HouseRobber {

    /*
     * Question: House Robber
     *
     * You cannot rob two adjacent houses.
     * Find the maximum amount of money you can rob.
     */

    static int rob(int[] nums) {

        int n = nums.length;

        if (n == 0) return 0;

        if (n == 1) return nums[0];

        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }

        // Step 1: Create DP array
        int[] dp = new int[n];

        // Step 2: Initialize base cases
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        // Step 3: Apply DP recurrence
        for (int i = 2; i < n; i++) {

            dp[i] = Math.max(
                dp[i - 1],
                nums[i] + dp[i - 2]
            );
        }

        // Step 4: Return maximum money
        return dp[n - 1];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input array size
        int n = sc.nextInt();

        int[] nums = new int[n];

        // Input house money
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Call static method
        int result = rob(nums);

        System.out.println("Maximum money: " + result);

        sc.close();
    }
}
