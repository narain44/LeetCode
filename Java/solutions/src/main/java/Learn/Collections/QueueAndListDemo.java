package Learn.Collections;

import javafx.util.Pair;

import java.util.*;

public class QueueAndListDemo {
    public static void main(String[] args){
        Queue<String> cars=new LinkedList<>(Arrays.asList(new String[]{"Toyota","Honda","Nissan","Ford","Chevrolet"}));
        System.out.println("Peeking "+cars.peek());
        System.out.println("Polling "+cars.poll());
//        System.out.println("Polling "+cars.removeLast());//Can't do this on a Queue, if cars is changed to LinkedList<String> this can be done
        System.out.println("Cars Queue is"+cars);

        System.out.println("**********Dequeue***********");
        Deque<Pair<String,Integer>> deque=new ArrayDeque<>();
        deque.offer(new Pair<>("EmpName,id",null));
        deque.offer(new Pair<>("Tom",1));
        deque.offer(new Pair<>("Mike",2));
        deque.offer(new Pair<>("Rick",3));
        deque.add(new Pair<>("Chip",4));
        System.out.println("Dequeue is "+deque);
        System.out.println("Dequeue is "+deque.removeLast());
        System.out.println("Dequeue is "+deque.pollLast());


        LinkedList<String> linkedListCommon=new LinkedList<>();
        Queue<String> linkedListQueue=linkedListCommon;
        List<String> linkedList=linkedListCommon;
        linkedListCommon.add("Red");
        linkedListQueue.offer("Blue");
        linkedList.add("Green");
        System.out.println("---------After Adding----------");
        System.out.println("Queue is "+ linkedListQueue);
        System.out.println("List is "+linkedList);
        System.out.println("--------Start Removing--------");
        System.out.println("Polled "+ linkedListCommon.poll());
        System.out.println("Queue is "+ linkedListQueue);
        System.out.println("List is "+linkedList);
        System.out.println("Removed "+ linkedListCommon.remove(1));
        System.out.println("Queue is "+ linkedListQueue);
        System.out.println("List is "+linkedList);



    }
}
