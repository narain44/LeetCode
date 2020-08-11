package educative.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class FruitsBasket04 {
    public static void main(String [] args){
        int result= FruitsBasket04.findLength(new char[]{'A', 'B', 'C', 'A', 'C'});
        System.out.println("Max Fruits for {'A', 'B', 'C', 'A', 'C'} is "+result);

        result= FruitsBasket04.findLength(new char[]{'A', 'B', 'C', 'B', 'B', 'C'});
        System.out.println("Max Fruits for {'A', 'B', 'C', 'B', 'B', 'C} is "+result);
    }

    /**
     * Start
     * add char to char map with count
     * while(
     * if mapsize>2 decrease char at start count, if char at start count == 0 remove that
     * increase start
     * )
     * maxFruits=max(maxFruits,(end-start)+1)
     *
     * @param arr
     * @return
     */
    public static int findLength(char[] arr) {
        int start=0,maxFruits=Integer.MIN_VALUE;
        Map<Character,Integer> charCountMap=new HashMap<>();
        for(int end=0;end<arr.length;end++){
            char currentChar=arr[end];
            charCountMap.put(currentChar,charCountMap.getOrDefault(currentChar,0)+1);
            //Check size
            while(charCountMap.size()>2){
                char startingChar=arr[start];
                charCountMap.put(startingChar,charCountMap.get(startingChar)-1);
                if(charCountMap.get(startingChar) == 0)
                    charCountMap.remove(startingChar);
                start++;
            }
            maxFruits=Math.max(maxFruits,end-start+1);
        }
        return maxFruits;
    }
}
