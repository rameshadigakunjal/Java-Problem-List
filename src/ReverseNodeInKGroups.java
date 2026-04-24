public class ReverseNodeInKGroups {
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

    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode curr = head;
            int count = 0;

        // Check if there are at least k nodes
            while (curr != null && count < k) {
                curr = curr.next;
                count++;
            }

        // If we have k nodes, reverse them
            if (count == k) {
                curr = reverseKGroup(curr, k); // reverse next groups

            // Reverse current k nodes
                while (count-- > 0) {
                    ListNode temp = head.next;
                    head.next = curr;
                    curr = head;
                    head = temp;
                }
                head = curr;
            }

            return head;
        }
    }

    private static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val);
            if (curr.next != null) {
                System.out.print(" -> ");
            }
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ReverseNodeInKGroups app = new ReverseNodeInKGroups();
        Solution solution = app.new Solution();

        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5)))));
        int k = 2;

        System.out.println("Original list:");
        printList(head);

        ListNode result = solution.reverseKGroup(head, k);

        System.out.println("After reverse in groups of " + k + ":");
        printList(result);
    }
    
}
