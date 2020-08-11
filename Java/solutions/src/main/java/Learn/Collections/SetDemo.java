package Learn.Collections;

import java.util.HashSet;
import java.util.Set;

public class SetDemo {
    public static void main(String[] args){
        Set<String> iceCreamSet=new HashSet<>();
        iceCreamSet.add("Kona");iceCreamSet.add("Gelato");iceCreamSet.add("BaskinRobbins");iceCreamSet.add("SweetFrog");
        System.out.println("Kona exists? " + iceCreamSet.contains("Kona"));
        iceCreamSet.remove("Kona");
        System.out.println("Kona exists? " + iceCreamSet.contains("Kona"));
    }
}
