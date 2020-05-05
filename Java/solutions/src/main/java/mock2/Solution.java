package mock2;

import java.util.*;

public class Solution {
    public static void main(String [] args){
        int[][] dominoes={
                {1,2},{1,2},{1,2},{1,2},{2,2}
        };
        Solution instance =new Solution();
        System.out.println("Number of Pairs "+instance.numEquivDominoPairs(dominoes));
    }
    public int numEquivDominoPairs(int[][] dominoes) {
        int pairCount=0;
        Map<Integer,Integer> countMap=new HashMap<>();
        for(int i=0;i<dominoes.length;i++){
            int maxSum=Math.max(dominoes[i][0],dominoes[i][1]);
            int minSum=Math.min(dominoes[i][0],dominoes[i][1])*10;
            int hashValue=maxSum+minSum;
            countMap.put(hashValue,countMap.getOrDefault(hashValue,0)+1);
        }
        //Now Find the combinations, n*(n-1)/2. E.G. If we found 3 pairs total combination =3*2/2=3 , If we found 4 pairs total combination =4*3/2=6
        int answer=0;
        for(int count:countMap.values()){
            if(count>1)
                answer += (count*(count-1))/2;
        }
//        return answer;


        Map<Integer, Integer> count = new HashMap<>();
        int res = 0;
        for (int[] d : dominoes) {
            int k = Math.min(d[0], d[1]) * 10 + Math.max(d[0], d[1]);
            count.put(k, count.getOrDefault(k, 0) + 1);
        }
        for (int v : count.values()) {
            res += v * (v - 1) / 2;
        }
        return res;
    }
}