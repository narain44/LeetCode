package Learn.Lists;

import java.util.*;

public class ListsDemo {

    public static void main(String [] args){

        List<String> drinks= Arrays.asList(new String[]{"Coke","Pepsi","7up"});
//        drinks.remove(1); //not Supported when directly intialized from an array
        System.out.println(drinks);

        drinks= new ArrayList<>(Arrays.asList(new String[]{"Coke","Pepsi","7up"}));
        drinks.remove(1); // Supported when constructor take in an array
        System.out.println(drinks);


        String[] places=new String[]{"Beach","Mountain","Forest"};
        List<String> placesList=Arrays.asList(places);
        Arrays.sort(places);
        System.out.println("Sorted Array is "+Arrays.toString(places));
        System.out.println("Sorted List is "+placesList);
        Arrays.sort(places, Comparator.reverseOrder());
        System.out.println("Reverse Sorted Array is "+Arrays.toString(places));


        List<Integer> averageTempList=new ArrayList<Integer>(Arrays.asList(new Integer[]{20,11,55,90}));

        System.out.println("TemplList Orginal is "+averageTempList);
        Collections.reverse(averageTempList);
        System.out.println("TemplList reversed is "+averageTempList);
        Collections.sort(averageTempList);
        System.out.println("TemplList Sorted is "+averageTempList);
        Collections.sort(averageTempList,Comparator.reverseOrder());
        System.out.println("TemplList Reverse Sorted is "+averageTempList);



        List<String> food= new ArrayList<>();
        food.add("thai");food.add("italian");food.add("mexican");
        System.out.println("List is"+ food);
        food.remove(1);
        System.out.println("After Removing at 1 "+food);
        food.add(1,"Chinese");
        System.out.println("After Adding at 1 "+food);


    }
}
