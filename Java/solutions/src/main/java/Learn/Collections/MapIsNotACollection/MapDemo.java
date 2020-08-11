package Learn.Collections.MapIsNotACollection;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {
    public static void main(String [] args){
        Map<String,Integer> map=new HashMap<>();
        map.put("Sachin",100);map.put("Ganguly",0);map.put("Laxman",45);
        System.out.println(map.get("Sachin"));

        System.out.println("Print using entryset--------");
        for(Map.Entry<String,Integer> entry:map.entrySet()){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }

        System.out.println("Print Keys----------");
        for(String key:map.keySet()){
            System.out.println(key);
        }

        System.out.println("Print Values-------");
        for(Integer values:map.values()){
            System.out.println(values);
        }
    }
}
