package linked_lists;

class SinglyListNode {
    int value;
    SinglyListNode next;

    SinglyListNode(int value, SinglyListNode next) {
        this.value = value;
        this.next = next;
    }
}

class DoublyListNode {
    int value;
    DoublyListNode prev;
    DoublyListNode next;

    DoublyListNode(int value, DoublyListNode next, DoublyListNode prev) {
        this.value = value;
        this.next = next;
        this.prev = prev;
    }
}

public class linkedListBasics {

    public static void main(String[] args) {
        SinglyListNode head = new SinglyListNode(1, null);
        head.next = new SinglyListNode(2, null);
        head.next.next = new SinglyListNode(3, null);

        printLinkedList(head);

        deleteNodeFromTail(head);

        head = insertNodeAtHead(5, head);

        System.out.println(findLengthOfLinkedList(head));

        printLinkedList(head);

        System.out.println(searchEleInLinkedList(head, 5));
        System.out.println(searchEleInLinkedList(head, 10));

        DoublyListNode headDouble = new DoublyListNode(1, null, null);
        headDouble.next = new DoublyListNode(2, null, headDouble);
        headDouble.next.next = new DoublyListNode(3, null, headDouble.next);

        headDouble = insertNodeAtEndDoublyLinkedList(5, headDouble);

        printLinkedListDoubly(headDouble);

        deleteNodeFromTail(headDouble);

        printLinkedListDoubly(headDouble);

        headDouble = insertNodeAtEndDoublyLinkedList(7, headDouble);

        printLinkedListDoubly(headDouble);

        headDouble = reverseDoublyLinkedList(headDouble);

        printLinkedListDoubly(headDouble);
    }

    static DoublyListNode reverseDoublyLinkedList(DoublyListNode headDouble) {
        DoublyListNode head1 = headDouble;
        while(head1 != null) {
            DoublyListNode temp = head1.prev;
            head1.prev = head1.next;
            head1.next = temp;
            if(head1.prev == null) {
                headDouble = head1;
            }
            head1 = head1.prev;
        }
        return headDouble;
    }

    static void printLinkedListDoubly(DoublyListNode headDouble) {
        DoublyListNode head1 = headDouble;
        while(head1 != null) {
            System.out.print(head1.value + " ");
            head1 = head1.next;
        }
        System.out.println();
    }

    static DoublyListNode insertNodeAtEndDoublyLinkedList(int i, DoublyListNode head) {
        DoublyListNode head1 = head;
        while(head1.next != null) {
            head1 = head1.next;
        }
        head1.next = new DoublyListNode(i, null, head1);
        return head;
    }

    static boolean searchEleInLinkedList(SinglyListNode head, int i) {
        SinglyListNode head1 = head;
        while(head1 != null) {
            if(head1.value == i) {
                return true;
            }
            head1 = head1.next;
        }
        return false;
    }

    static int findLengthOfLinkedList(SinglyListNode head) {
        SinglyListNode head1 = head;
        int length = 0;
        while(head1 != null) {
            length += 1;
            head1 = head1.next;
        }
        return length;
    }

    static void deleteNodeFromTail(SinglyListNode head) {
        SinglyListNode head1 = head;
        while(head1.next.next != null) {
            head1 = head1.next;
        }
        head1.next = null;
    }

    static void deleteNodeFromTail(DoublyListNode head) {
        DoublyListNode head1 = head;
        while(head1.next.next != null) {
            head1 = head1.next;
        }
        head1.next = null;
    }

    static SinglyListNode insertNodeAtHead(int value, SinglyListNode head) {
        return new SinglyListNode(value, head);
    }

    static void printLinkedList(SinglyListNode head) {
        SinglyListNode head1 = head;
        while(head1 != null) {
            System.out.print(head1.value + " ");
            head1 = head1.next;
        }
        System.out.println();
    }
}
