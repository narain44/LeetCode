package SearchSuggestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class SearchSuggestion {
    public static void main(String [] args){
        SearchSuggestion instance=new SearchSuggestion();
        String[] products = {"mobile","mouse","moneypot","monitor","mousepad"};
        String searchWord = "mouse";
       // List<List<String>> result=instance.suggestedProducts(products,searchWord)
        List<List<String>> result=instance.suggestedProductsSortAndBinarySearch(products,searchWord);
        for(List<String> list:result){
            System.out.println(list.toString());
        }
    }
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> result=new ArrayList<>();
        for(int i=0;i<searchWord.length();i++){
            String toSearch=searchWord.substring(0,i+1);

            List<String> toSearchResult=new ArrayList<>();
            for(int j=0;j<products.length;j++){
                if(products[j].startsWith(toSearch)){
                    if(toSearchResult.size()>=3) break;
                    toSearchResult.add(products[j]);
                }
            }
            result.add(toSearchResult);
        }
        return result;
    }

    public List<List<String>> suggestedProductsSortAndBinarySearch(String[] products, String searchWord) {
        List<List<String>> res = new ArrayList<>();
        TreeMap<String, Integer> map = new TreeMap<>();
        Arrays.sort(products);
        List<String> productsList = Arrays.asList(products);

        for (int i = 0; i < products.length; i++) {
            map.put(products[i], i);
        }

        String key = "";
        for (char c : searchWord.toCharArray()) {
            key += c;
            String ceiling = map.ceilingKey(key);
            String floor = map.floorKey(key + "~");
            if (ceiling == null || floor == null) break;
            res.add(productsList.subList(map.get(ceiling), Math.min(map.get(ceiling) + 3, map.get(floor) + 1)));
        }

        while (res.size() < searchWord.length()) res.add(new ArrayList<>());
        return res;
    }
}
