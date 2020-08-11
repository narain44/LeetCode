package Learn.Collections;

import java.util.*;

public class CollectionsDemo {
    public static void main(String[] args){
        Collection<String> drinks=new ArrayList(Arrays.asList(new String[]{"Coke","Pepsi","7up"} ));
        Iterator<String> iterator=drinks.iterator();

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("Collection is : "+drinks);
        iterator.remove();
        System.out.println("Collection is : "+drinks);
    }
}
