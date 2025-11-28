package linked_lists;

import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class middleOfALinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ListNode node;
        ListNode head = new ListNode(sc.nextInt(), null);
        ListNode prev = head;
        for(int i = 1; i < n; ++i) {
            node = new ListNode(sc.nextInt(), null);
            prev.next = node;
            prev = node;
        }
        System.out.println(middleNode(head).val);
        sc.close();
    }

    static ListNode middleNode(ListNode head) {
        if(head.next == null) {
            return head;
        }
        ListNode slowerPointer = head, fasterPointer = head;
        while(fasterPointer.next != null) {
            slowerPointer = slowerPointer.next;
            if(fasterPointer.next.next == null) {
                fasterPointer = fasterPointer.next;
            }
            else {
                fasterPointer = fasterPointer.next.next;
            }
        }
        return slowerPointer;
    }
}
