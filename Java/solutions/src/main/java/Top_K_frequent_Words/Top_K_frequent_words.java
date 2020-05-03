package Top_K_frequent_Words;

import java.util.*;

public class Top_K_frequent_words {
    public static void main(String [] args){
        Top_K_frequent_words instance=new Top_K_frequent_words();
        String [] words= new String [] {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 3;
        List<String> answer=instance.topKFrequent(words,k);
        System.out.println(answer);
        answer=instance.topKFrequentUsingHeap(words,k);
        System.out.println(answer);

    }

    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> map=new HashMap<String,Integer>();
        for(int i=0;i<words.length;i++){
            map.put(words[i],map.getOrDefault(words[i],0)+1);
        }

        //Important step
        ArrayList<String> answer=new ArrayList<>(map.keySet());
        Collections.sort(answer,(word1,word2)->{
            return map.get(word1)==map.get(word2)? word1.compareTo(word2) :map.get(word2)-map.get(word1);
        });

        List<String> result=answer.subList(0,k);
        return result;
    }

    public List<String> topKFrequentUsingHeap(String[] words, int k) {
        HashMap<String,Integer> map=new HashMap<String,Integer>();
        for(int i=0;i<words.length;i++){
            map.put(words[i],map.getOrDefault(words[i],0)+1);
        }

        Queue<String> heap=new PriorityQueue<String>((word1,word2)->{
            return map.get(word1)==map.get(word2)? word2.compareTo(word1) :map.get(word1)-map.get(word2);} //IMP here we are sorting least to Most , hence word1-Word2
        );

        for(String key:map.keySet()){ //Use map's key set to avoid duplicates
            heap.offer(key);
            if(heap.size()>k)
                System.out.println("Polled out"+heap.poll());
        }

        List<String> answer=new ArrayList<>();
        while(!heap.isEmpty()){
            answer.add(heap.poll());
        }
        Collections.reverse(answer);
        return answer;
    }
}


