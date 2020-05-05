package ReverseLinkedList;


import java.util.Stack;

/**
 * Definition for singly-linked list. */
class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

public class ReverseLinkedList {
    private static String printList(ListNode head){
        StringBuffer sb=new StringBuffer();
        while(head!=null){
            sb.append(head.val);head=head.next;
        }
        return sb.toString();
    }
    public static void main(String []args){
        ListNode l1=new ListNode(1);
        l1.next=new ListNode(2);
        l1.next.next=new ListNode(3);
        l1.next.next.next=new ListNode(4);
        l1.next.next.next.next=new ListNode(5);
        System.out.println("Orginal List "+printList(l1));

        System.out.println("Reversed List "+printList(new ReverseLinkedList().reverseList(l1)));
        System.out.println("Reversed List "+printList(new ReverseLinkedList().reverseListRecursive(l1)));
    }

    public ListNode reverseListRecursive(ListNode head) {
        if(head.next == null){
            return head;
        }

        ListNode parent=reverseListRecursive(head.next);
        head.next=null;
        parent.next=head;
        return parent;
    }
    public ListNode reverseList(ListNode head) {
        if(head == null ) return null;
        Stack<ListNode> stack=new Stack<ListNode>();
        ListNode currentNode=head;
        while(currentNode!=null){
            stack.push(currentNode);
            currentNode=currentNode.next;
        }

        ListNode result=stack.pop();
        ListNode lastNode=result;
        while(stack.size() > 0){
            ListNode poppedNode= stack.pop();
            poppedNode.next = null;
            lastNode.next = poppedNode;
            lastNode=lastNode.next;
        }

        return result;

    }

}
