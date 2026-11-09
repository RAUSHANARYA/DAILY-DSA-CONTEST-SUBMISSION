
package questions;

import java.util.*;

public class JobSequencing {

    // DSU: Find the latest available slot
    static int find(int[] parent, int x) {

        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent, parent[x]);
    }

    static ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {

        int n = deadline.length;

        int maxDeadline = 0;

        for (int d : deadline) {
            maxDeadline = Math.max(maxDeadline, d);
        }

        // No more than n jobs can be scheduled
        maxDeadline = Math.min(maxDeadline, n);

        int[][] arr = new int[n][2];

        // First insert the data
        for (int i = 0; i < n; i++) {
            arr[i][0] = deadline[i];
            arr[i][1] = profit[i];
        }

        // Sort by descending profit
        Arrays.sort(arr, (a, b) ->
            Integer.compare(b[1], a[1]));

        // Original code:
        // boolean[] visited = new boolean[maxDeadline + 1];

        // Optimized DSU code:
        int[] parent = new int[maxDeadline + 1];

        for (int i = 0; i <= maxDeadline; i++) {
            parent[i] = i;
        }

        int totalProfit = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {

            int d = arr[i][0];
            int p = arr[i][1];

            /*
             * ORIGINAL CODE (commented):
             *
             * for (int slot = d; slot >= 1; slot--) {
             *
             *     if (!visited[slot]) {
             *         visited[slot] = true;
             *         totalProfit += p;
             *         count++;
             *         break;
             *     }
             * }
             *
             * Problem:
             * It checks every slot one by one.
             * In the worst case, this takes O(N * D) time.
             */

            // OPTIMIZED CODE USING DSU:

            int slot = find(parent, Math.min(d, maxDeadline));

            if (slot > 0) {

                totalProfit += p;
                count++;

                // Mark slot as occupied and link to previous available slot
                parent[slot] = find(parent, slot - 1);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();

        ans.add(count);
        ans.add(totalProfit);

        return ans;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] deadline = new int[n];
        int[] profit = new int[n];

        for (int i = 0; i < n; i++) {
            deadline[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            profit[i] = sc.nextInt();
        }

        ArrayList<Integer> result = jobSequencing(deadline, profit);

        System.out.println(result);

        sc.close();
    }
}
