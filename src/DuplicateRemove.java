/*
83. Remove Duplicates from Sorted List


Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.

 

Example 1:

Input: head = [1,1,2]
Output: [1,2]

Example 2:

Input: head = [1,1,2,3,3]
Output: [1,2,3]

 

Constraints:

    The number of nodes in the list is in the range [0, 300].
    -100 <= Node.val <= 100
    The list is guaranteed to be sorted in ascending order.



 */


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


public class DuplicateRemove {
    
    public ListNode deleteDuplicates(ListNode head) {
        ListNode result = head;

        while (result != null) {
            
            if (result.next == null) {
                break;
            }

            if (result.next.val == result.val) {
                // next is duplicate
                result.next = result.next.next;
            } else {
                result = result.next;
            }
        }
        return head;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);

        new DuplicateRemove().deleteDuplicates(head);

        System.out.println(head.val);
        System.out.println(head.next.val);
        System.out.println(head.next.next.val);

    }

}
