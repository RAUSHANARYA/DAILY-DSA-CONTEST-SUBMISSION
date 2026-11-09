
package questions;

import java.util.*;

public class ProductByAllExpectSelf {

    /*
     * Question: Product of Array Except Self
     *
     * Return an array where each element is the product
     * of all elements except the element at that index.
     *
     * Do not use the division operation.
     */

    static int[] productExceptSelf(int[] nums) {

        int n = nums.length;

        int[] prefix = new int[n];
        int[] suffix = new int[n];

        // Step 1: Calculate prefix products
        prefix[0] = 1;

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }

        // Step 2: Calculate suffix products
        suffix[n - 1] = 1;

        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }

        // Step 3: Multiply prefix and suffix
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            ans[i] = prefix[i] * suffix[i];
        }

        return ans;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input array size
        int n = sc.nextInt();

        int[] nums = new int[n];

        // Input array elements
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Call static method
        int[] result = productExceptSelf(nums);

        // Print result
        System.out.println(Arrays.toString(result));

        sc.close();
    }
}
