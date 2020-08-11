package PhoneMock2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HighFive {
    public int[][] highFive(int[][] items) {
        Map<Integer, PriorityQueue<Integer>> studentScoremap = new HashMap<>();
        PriorityQueue<Integer> studentIdQueue = new PriorityQueue<Integer>((a, b) -> a.compareTo(b));

        for (int i = 0; i < items.length; i++) {
            Integer studentId = items[i][0];
            studentIdQueue.add(studentId);
            Integer score = items[i][1];
            PriorityQueue<Integer> scoresQueue = studentScoremap.get(studentId);
            if (scoresQueue == null) {
                scoresQueue = new PriorityQueue<Integer>((a, b) -> b.compareTo(a));
            }
            scoresQueue.add(score);
            studentScoremap.put(studentId, scoresQueue);

        }

        Integer studentId = null;
        int[][] output = new int[studentScoremap.keySet().size()][2];
        int outputIndex = 0;
        while (!studentIdQueue.isEmpty()) {
            Integer studentIdNew = studentIdQueue.poll();
            if (studentId != studentIdNew) {
                studentId = studentIdNew;
                PriorityQueue<Integer> scoresQueue = studentScoremap.get(studentId);
                Integer average = 0;
                int sc = 0;
                for (sc = 0; sc < 5; sc++) {
                    average += scoresQueue.poll();
                }
                average = average / sc;
                output[outputIndex++] = new int[]{studentId, average};
            }

        }
        return output;
    }


    public static void main(String []args){
        HighFive instance=new HighFive();
        int[][] studentScores=new int[][] {{1,91},{1,92},{2,93},{2,97},{1,60},{2,77},{1,65},{1,87},{1,100},{2,100},{2,76}};
        int[][] output=instance.highFive(studentScores);
        System.out.println(Arrays.deepToString(output));
    }


}
