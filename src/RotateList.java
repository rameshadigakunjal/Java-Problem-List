import java.util.*;  

class RotateList {
    // Simple ListNode definition for this file
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }
        public ListNode rotateRight(ListNode head, int k) {
            // Edge cases
            if (head == null || head.next == null || k == 0) {
                return head;
            }

            // Step 1: Find length of list
            ListNode temp = head;
            int length = 1;
            while (temp.next != null) {
                temp = temp.next;
                length++;
            }

            // Step 2: Make it circular
            temp.next = head;

            // Step 3: Reduce k
            k = k % length;

            // Step 4: Find new tail (length - k steps)
            int stepsToNewTail = length - k;
            ListNode newTail = head;

            for (int i = 1; i < stepsToNewTail; i++) {
                newTail = newTail.next;
            }

            // Step 5: Set new head
            ListNode newHead = newTail.next;

            // Step 6: Break the circle
            newTail.next = null;

            return newHead;
        }
        public static void main(String[] args) {
            RotateList solution = new RotateList();
            ListNode head = new ListNode(1);
            head.next = new ListNode(2);
            head.next.next = new ListNode(3);
            head.next.next.next = new ListNode(4);
            head.next.next.next.next = new ListNode(5);
            int k = 2; // Example input
            ListNode result = solution.rotateRight(head, k);
            
            // Print the rotated list
            while (result != null) {
                System.out.print(result.val + " ");
                result = result.next;
            } // Output: "4 5 1 2 3 "
        }
    }