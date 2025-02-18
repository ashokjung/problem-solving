package oca;
class ListNode {
    int val;
    ListNode next;
    
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class MergeSortedListsIterative {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1); 
        ListNode current = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        // Append the remaining nodes from either list
        if (l1 != null) current.next = l1;
        if (l2 != null) current.next = l2;

        return dummy.next; // Return merged list (excluding dummy node)
    }

    // Utility function to print a linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Creating first sorted linked list: 1 -> 3 -> 5
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(5);

        // Creating second sorted linked list: 2 -> 4 -> 6
        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(6);

        System.out.println("First List:");
        printList(l1);
        
        System.out.println("Second List:");
        printList(l2);

        // Merging the two lists
        ListNode merged = mergeTwoLists(l1, l2);
        
        System.out.println("Merged List:");
        printList(merged);
    }
}
