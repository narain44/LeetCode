package educative.twopointers;

public class RemoveDuplicates02 {
    public static void main(String []args){
//        System.out.println("After removing dupes from [2,3,3,3,6,9,9], result is"
//                + Arrays.toString(remove(new int[]{2, 3, 3, 3, 6, 9, 9})));

        System.out.println("After removing dupes from [2,3,3,3,6,9,9], result is "
                +remove(new int[]{2, 3, 3, 3, 6, 9, 9}));
    }

    public static int remove(int[] arr) {
       int nnd=1;
       for(int i=1;i<arr.length;i++){
           if(arr[nnd-1]!=arr[i]){
               arr[nnd]=arr[i];
               nnd++;
           }
       }
       return nnd;
    }
}
