package LinkedListMergeLinkedList;

//     * Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
public class Solution {

    public static void main(String []args){
        ListNode l1=new ListNode(1);
        l1.next=new ListNode(2);
        l1.next.next=new ListNode(4);

        ListNode l2=new ListNode(1);
        l2.next=new ListNode(3);
        l2.next.next=new ListNode(4);
        new Solution().mergeTwoLists(l1,l2);
    }



    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(l1.val);
        ListNode lastResultNode = new ListNode(l2.val);
        result.next = lastResultNode;

        ListNode l1Next = l1.next;
        ListNode l2Next = l2.next;
        while (l1Next != null || l2Next != null) {
            if (l1Next != null) {
                ListNode newNode1 = new ListNode(l1Next.val);
                lastResultNode.next = newNode1;
                lastResultNode = lastResultNode.next;
                l1Next = l1Next.next;
            }
            if (l2Next != null) {
                ListNode newNode1 = new ListNode(l2Next.val);
                lastResultNode.next = newNode1;
                lastResultNode = lastResultNode.next;
                l2Next = l2Next.next;
            }

        }
        return result;
    }

}
