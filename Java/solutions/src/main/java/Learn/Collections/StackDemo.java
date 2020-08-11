package Learn.Collections;

import javafx.util.Pair;

import java.util.Stack;

public class StackDemo {
    public static void main(String []args){
        Stack<Pair<String,Integer>> batsmanScores=new Stack<>();
        batsmanScores.add(new Pair("Sachin",100));
        batsmanScores.add(new Pair("Ganguly",0));
        batsmanScores.add(new Pair("Dravid",45));
        batsmanScores.push(new Pair("Laxman",49));
        batsmanScores.push(new Pair("Kaif",3));
        System.out.println("Scores "+batsmanScores);
        System.out.println("---------Polling batsmanScores--------");
        System.out.println(batsmanScores.pop());
        System.out.println(batsmanScores.peek().getKey()+", "+batsmanScores.peek().getValue());
        System.out.println(batsmanScores.pop());

    }
}
