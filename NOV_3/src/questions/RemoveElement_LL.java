
package questions;

import java.util.*;

public class RemoveElement_LL {

    /*
     * Question: Remove Linked List Elements
     *
     * Given the head of a linked list and an integer val,
     * remove all nodes having value equal to val.
     *
     * Return the updated head.
     */

    // Definition of Linked List Node
    static class ListNode {

        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    static ListNode removeElements(ListNode head, int val) {

        // Step 1: Remove matching nodes from the beginning
        while (head != null && head.val == val) {
            head = head.next;
        }

        if (head == null) {
            return null;
        }

        // Step 2: Traverse the remaining linked list
        ListNode cuNode = head;

        while (cuNode.next != null) {

            // Step 3: Remove the next node if its value matches
            if (cuNode.next.val == val) {
                cuNode.next = cuNode.next.next;
            }
            else {
                cuNode = cuNode.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input number of nodes
        int n = sc.nextInt();

        ListNode head = null;
        ListNode tail = null;

        // Create linked list
        for (int i = 0; i < n; i++) {

            int value = sc.nextInt();

            ListNode newNode = new ListNode(value);

            if (head == null) {
                head = newNode;
                tail = newNode;
            }
            else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        // Input value to remove
        int val = sc.nextInt();

        // Call static method
        head = removeElements(head, val);

        // Print updated linked list
        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }

        sc.close();
    }
}
