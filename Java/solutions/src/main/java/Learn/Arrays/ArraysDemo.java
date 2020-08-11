package Learn.Arrays;

import java.util.Arrays;

public class ArraysDemo {

    public static void main(String []args){
        Integer[] arr=new Integer[26];
        System.out.println(Arrays.toString(arr));
        Arrays.fill(arr,99);
        System.out.println(Arrays.toString(arr));
        Arrays.fill(arr,23,26,5);
        System.out.println(Arrays.toString(arr));



        String s="This is a string separated by a space and  twospaces";
        System.out.println(Arrays.toString(s.split("\\s")));
        System.out.println(Arrays.toString(s.split("\\s+")));

        String commaStr="This,is,a,string,separated,by,commas,and,,twocommas";
        System.out.println(Arrays.toString(commaStr.split(",")));
        System.out.println(Arrays.toString(commaStr.split("[,]+")));

        String d="This9is9a4string3separated2by53digits-1and-12more0digits";
        System.out.println(Arrays.toString(d.split("\\d")));
        System.out.println(Arrays.toString(d.split("\\d+")));
    }
}
