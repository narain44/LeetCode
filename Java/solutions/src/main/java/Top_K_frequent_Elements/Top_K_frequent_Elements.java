package Top_K_frequent_Elements;

import java.util.*;

public class Top_K_frequent_Elements {
    public static void main(String [] args){
        Top_K_frequent_Elements instance=new Top_K_frequent_Elements();
        int [] num= new int [] {1,1,1,2,2,2,3};
        int k = 2;
        int[] answer=instance.topKFrequentUsingHeap(num,k);
        System.out.println(answer);

    }
//
//    public List<String> topKFrequent(String[] words, int k) {
//        HashMap<String,Integer> map=new HashMap<String,Integer>();
//        for(int i=0;i<words.length;i++){
//            map.put(words[i],map.getOrDefault(words[i],0)+1);
//        }
//
//        //Important step
//        ArrayList<String> answer=new ArrayList<>(map.keySet());
//        Collections.sort(answer,(num1,num2)->{
//            return map.get(num1)==map.get(num2)? num1.compareTo(num2) :map.get(num2)-map.get(num1);
//        });
//
//        List<String> result=answer.subList(0,k);
//        return result;
//    }

    public int[] topKFrequentUsingHeap(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        Queue<Integer> heap=new PriorityQueue<Integer>((num1,num2)->{
            return map.get(num1)==map.get(num2)? num1.compareTo(num2) :map.get(num1)-map.get(num2);} //IMP here we are sorting least to Most , hence num1-num2
        );

        for(Integer key:map.keySet()){ //Use map's key set to avoid duplicates
            heap.offer(key);
            if(heap.size()>k)
                System.out.println("Polled out "+heap.poll());
        }

        List<Integer> answer=new ArrayList<>();
        while(!heap.isEmpty()){
            answer.add(heap.poll());
        }
        Collections.reverse(answer);

        int[] arrAnswer = new int[answer.size()];
        int i=0;
        for(Integer element:answer){
            arrAnswer[i]=element;
            i++;
        }
        return arrAnswer;
    }
}
