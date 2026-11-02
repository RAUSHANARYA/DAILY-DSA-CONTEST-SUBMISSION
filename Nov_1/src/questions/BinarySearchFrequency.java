package questions;

import java.util.*;

public class BinarySearchFrequency {

    /*
     * Question: Count Frequency of an Element
     *
     * Given a sorted array and a target element x,
     * find the frequency of x in the array.
     *
     * Approach: Binary Search
     *
     * Step 1: Find the first occurrence of x.
     *
     * Step 2: Find the last occurrence of x.
     *
     * Step 3: Calculate frequency.
     *
     * Formula:
     * Frequency = Right - Left + 1
     *
     * Time Complexity: O(log N)
     * Space Complexity: O(1)
     */

    // Find Last Occurrence
    public static int lastOccurance(int arr[], int x) {

        int s = 0;
        int e = arr.length - 1;
        int ans = -1;

        while (s <= e) {

            int mid = s + (e - s) / 2;

            if (x == arr[mid]) {

                ans = mid;
                s = mid + 1;

            }
            else if (arr[mid] < x) {
                s = mid + 1;
            }
            else {
                e = mid - 1;
            }
        }

        return ans;
    }

    // Find First Occurrence
    public static int firstOccurance(int arr[], int x) {

        int s = 0;
        int e = arr.length - 1;
        int ans = -1;

        while (s <= e) {

            int mid = s + (e - s) / 2;

            if (x == arr[mid]) {

                ans = mid;
                e = mid - 1;

            }
            else if (arr[mid] < x) {
                s = mid + 1;
            }
            else {
                e = mid - 1;
            }
        }

        return ans;
    }

    // Count Frequency
    public static int bs(int arr[], int x) {

        int left = firstOccurance(arr, x);

        if (left == -1) {
            return 0;
        }

        int right = lastOccurance(arr, x);

        return right - left + 1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input array size
        System.out.println("Enter array size:");
        int n = sc.nextInt();

        // Input sorted array
        int arr[] = new int[n];

        System.out.println("Enter sorted array elements:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Input target element
        System.out.println("Enter target element:");
        int x = sc.nextInt();

        // Call function
        int result = bs(arr, x);

        // Print frequency
        System.out.println("Frequency: " + result);

        sc.close();
    }
}