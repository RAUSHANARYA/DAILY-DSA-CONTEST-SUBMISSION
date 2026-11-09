
package questions;

import java.util.*;

public class MinCost_PQ {

    static int minCost(int[] arr) {

        int n = arr.length;
        int sum = 0;

        // Step 1: Create Min Heap
        PriorityQueue<Integer> q = new PriorityQueue<>();

        // Step 2: Insert all rope lengths
        for (int i = 0; i < n; i++) {
            q.offer(arr[i]);
        }

        // Step 3: Connect two smallest ropes
        while (q.size() >= 2) {

            int a = q.poll();
            int b = q.poll();

            int cost = a + b;

            // Add current cost to total
            sum += cost;

            // Insert combined rope back
            q.offer(cost);
        }

        return sum;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input number of ropes
        int n = sc.nextInt();

        int[] arr = new int[n];

        // Input rope lengths
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Calculate minimum cost
        int result = minCost(arr);

        System.out.println("Minimum Cost: " + result);

        sc.close();
    }
}

/*
Time Complexity: O(N log N)
- Inserting N elements into the PriorityQueue takes O(N log N).
- We perform N-1 iterations.
- Each iteration performs two poll() operations and one offer(),
  each taking O(log N).
- Overall: O(N log N).

Space Complexity: O(N)
- PriorityQueue stores up to N elements.
- No additional data structure proportional to N is used.
*/
