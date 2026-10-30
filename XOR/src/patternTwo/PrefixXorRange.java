package patternTwo;

import java.util.*;

public class PrefixXorRange {

    /*
     * Question: XOR Queries of a Subarray
     *
     * Given an array and Q queries [L, R],
     * find the XOR of elements from index L to R (inclusive).
     *
     * Approach: Prefix XOR
     *
     * prefix[i] = XOR of elements from index 0 to i-1.
     *
     * Formula:
     * XOR(L, R) = prefix[R+1] ^ prefix[L]
     *
     * Time Complexity: O(N + Q)
     * Space Complexity: O(N + Q) including output array.
     */

    static int[] xorQueries(int[] arr, int[][] queries) {

        int n = arr.length;

        // Step 1: Build Prefix XOR Array
        int prefix[] = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] ^ arr[i];
        }

        // Step 2: Process Each Query
        int a[] = new int[queries.length];

        int k = 0;

        for (int d[] : queries) {

            int L = d[0];
            int R = d[1];

            // XOR of subarray [L, R]
            a[k++] = prefix[R + 1] ^ prefix[L];
        }

        return a;
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

        // Input number of queries
        System.out.println("Enter number of queries:");
        int q = sc.nextInt();

        // Input L and R for each query
        int queries[][] = new int[q][2];

        System.out.println("Enter L and R for each query:");

        for (int i = 0; i < q; i++) {
            queries[i][0] = sc.nextInt();
            queries[i][1] = sc.nextInt();
        }

        // Call function
        int result[] = xorQueries(arr, queries);

        // Print results
        System.out.println("XOR Query Results:");

        for (int x : result) {
            System.out.print(x + " ");
        }

        sc.close();
    }
}