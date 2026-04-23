import java.util.Scanner;

class SwapNodeinPairs {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;

        while (prev.next != null && prev.next.next != null) {
            ListNode first = prev.next;
            ListNode second = prev.next.next;

            // Swapping
            first.next = second.next;
            second.next = first;
            prev.next = second;

            // Move to next pair
            prev = first;
        }

        return dummy.next;
    }

    private static ListNode buildListFromInput(Scanner scanner, int n) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        for (int i = 0; i < n && scanner.hasNextInt(); i++) {
            current.next = new ListNode(scanner.nextInt());
            current = current.next;
        }

        return dummy.next;
    }

    private static String listToString(ListNode head) {
        StringBuilder sb = new StringBuilder();
        ListNode current = head;

        while (current != null) {
            if (sb.length() > 0) {
                sb.append(' ');
            }
            sb.append(current.val);
            current = current.next;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        SwapNodeinPairs solution = new SwapNodeinPairs();
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }

        int n = scanner.nextInt();
        ListNode head = buildListFromInput(scanner, n);
        ListNode result = solution.swapPairs(head);
        System.out.println(listToString(result));

        scanner.close();
    }
}