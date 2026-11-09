
package questions;

import java.util.*;

public class RotateBy90 {

    /*
     * Question: Rotate Image by 90 Degrees Clockwise
     *
     * Rotate an n x n matrix by 90 degrees clockwise.
     *
     * Approach:
     * 1. Transpose the matrix.
     * 2. Reverse every row of the transposed matrix.
     */

    static void rotate(int[][] matrix) {

        int n = matrix.length;

        // Step 1: Create temporary matrix
        int[][] ans = new int[n][n];

        // Step 2: Transpose
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans[j][i] = matrix[i][j];
            }
        }

        // Step 3: Reverse every row using two pointers
        int left = 0;
        int right = n - 1;

        while (left < right) {

            for (int i = 0; i < n; i++) {

                int temp = ans[i][left];

                ans[i][left] = ans[i][right];

                ans[i][right] = temp;
            }

            left++;
            right--;
        }

        // Step 4: Copy answer back to original matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = ans[i][j];
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input matrix size
        int n = sc.nextInt();

        int[][] matrix = new int[n][n];

        // Input matrix elements
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        // Rotate matrix
        rotate(matrix);

        // Print rotated matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
