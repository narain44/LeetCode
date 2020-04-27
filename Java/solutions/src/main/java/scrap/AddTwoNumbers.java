package scrap;

//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}

public class AddTwoNumbers {
    public static void main(String []args){
        ListNode l1=new ListNode(2);
        l1.next=new ListNode(4);
        l1.next.next=new ListNode(3);

        ListNode l2=new ListNode(5);
        l2.next=new ListNode(6);
        l2.next.next=new ListNode(4);

        ListNode result=new AddTwoNumbers().addTwoNumbers(l1,l2);
        System.out.print("[");
        while(result!=null){
            System.out.print(result.val+" ");
            result=result.next;
        }
        System.out.print("]");
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //Read First number
        int firstNumber = 0;
        int firstNumberFactor = 1;
        ListNode currentNode = l1;
        while (currentNode != null) {
            firstNumber += (currentNode.val * firstNumberFactor);
            currentNode = currentNode.next;
            if (currentNode != null) {
                firstNumberFactor *= 10;
            }

        }
        System.out.println("FirstNumer " + firstNumber);
        System.out.println("FirstNumberFactor " + firstNumberFactor);

        //Read Second number
        int secondNumber = 0;
        int secondNumberFactor = 1;
        currentNode = l2;
        while (currentNode != null) {
            secondNumber += (currentNode.val * secondNumberFactor);
            currentNode = currentNode.next;
            if (currentNode != null) {
                secondNumberFactor *= 10;
            }
        }
        System.out.println("SecondNumber " + secondNumber);
        System.out.println("SecondNumberFactor " + secondNumberFactor);

        //Do Summation
        int result = firstNumber + secondNumber;
        int resultFactor = firstNumberFactor > secondNumberFactor ? firstNumberFactor : secondNumberFactor;
        if (result / (resultFactor * 10) >= 1) {
            resultFactor = resultFactor * 10;
        }
        System.out.println("Result is " + result);
        System.out.println("Result Factor is " + resultFactor);
        ListNode resultHead = null;
        ListNode resultCurrentNode = null;
        while (resultFactor >= 1) {
            if (result < resultFactor) {
                resultCurrentNode = new ListNode(0);
            } else {
                resultCurrentNode = new ListNode(result / resultFactor);
            }
            if (resultHead == null) {
                resultHead = resultCurrentNode;
            } else {
                resultCurrentNode.next = resultHead;
                resultHead = resultCurrentNode;
            }

            result = result - (resultCurrentNode.val * resultFactor);
            resultFactor = resultFactor / 10;
        }
        return resultHead;
    }
}