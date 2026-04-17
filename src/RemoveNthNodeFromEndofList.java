import java.util.*;

public class RemoveNthNodeFromEndofList {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        // Move fast pointer n+1 steps ahead
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // Move both pointers
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Remove nth node
        slow.next = slow.next.next;

        return dummy.next;
    }

    private static ListNode buildList(int[] nums) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        for (int num : nums) {
            current.next = new ListNode(num);
            current = current.next;
        }

        return dummy.next;
    }

    private static String listToString(ListNode head) {
        StringBuilder sb = new StringBuilder();
        ListNode current = head;

        while (current != null) {
            sb.append(current.val);
            if (current.next != null) {
                sb.append(" -> ");
            }
            current = current.next;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        RemoveNthNodeFromEndofList solver = new RemoveNthNodeFromEndofList();

        int[] input = {1, 2, 3, 4, 5};
        int n = 2;
        ListNode head = buildList(input);

        System.out.println("Input list : " + listToString(head));
        System.out.println("Remove nth from end (n = " + n + ")");

        ListNode result = solver.removeNthFromEnd(head, n);
        System.out.println("Result list: " + listToString(result));
    }

}
