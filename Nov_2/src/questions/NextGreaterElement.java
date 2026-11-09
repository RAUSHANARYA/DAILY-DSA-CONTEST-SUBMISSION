
package questions;

import java.util.*;

public class NextGreaterElement {

    /*
     * Question: Next Greater Element
     *
     * For every element in the array, find the first
     * greater element on its right side.
     *
     * If no greater element exists, return -1.
     */

    static int[] nextGreaterElement(int[] arr) {

        int n = arr.length;
        int[] ans = new int[n];

        Stack<Integer> st = new Stack<>();

        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {

            // Remove elements smaller than or equal to current element
            while (!st.isEmpty() && st.peek() <= arr[i]) {
                st.pop();
            }

            // Find the next greater element
            if (st.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = st.peek();
            }

            // Push current element into stack
            st.push(arr[i]);
        }

        return ans;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input array size
        int n = sc.nextInt();

        int[] arr = new int[n];

        // Input array elements
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Call static method
        int[] result = nextGreaterElement(arr);

        // Print result
        System.out.println(Arrays.toString(result));

        sc.close();
    }
}
