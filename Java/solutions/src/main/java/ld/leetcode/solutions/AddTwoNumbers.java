package ld.leetcode.solutions;

//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
//        l1.next = new ListNode(4);
//        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
//        l2.next = new ListNode(6);
//        l2.next.next = new ListNode(4);

        ListNode result = new AddTwoNumbers().addTwoNumbers(l1, l2);
        System.out.print("[");
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
        System.out.print("]");
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return add(l1, l2, 0);
    }

    public ListNode add(ListNode l1, ListNode l2, int carry) {
        ListNode sumHead = null;
        if (l1 == null && l2 == null && carry == 0)
            return sumHead;
        int sum = carry;
        if (l1 != null)
            sum += l1.val;
        if (l2 != null)
            sum += l2.val;

        sumHead = new ListNode(sum % 10);
        carry = sum / 10;
        ListNode l1Next = l1 != null ? l1.next : null;
        ListNode l2Next = l2 != null ? l2.next : null;
        sumHead.next = add(l1Next, l2Next, carry);
        return sumHead;
    }
}