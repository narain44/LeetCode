package Learn.Collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class CollectionsDemo {
    public static void main(String[] args){
        List<String> drinks=new ArrayList(Arrays.asList(new String[]{"Coke","Pepsi","7up"} ));
        Iterator<String> iterator=drinks.iterator();

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
