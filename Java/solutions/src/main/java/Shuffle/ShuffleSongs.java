package Shuffle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShuffleSongs {

    public static void main(String []args){
        Integer [] songsInteger=new Integer [] {1,2,3};
        ShuffleSongs instance=new ShuffleSongs();
        //instance.shuffle(songsInteger);

        int [] songs=new int [] {1,2,3};
        instance.returnSubsets(songs,0,new ArrayList<Integer>());
        System.out.println(instance.songsSubset);

        instance.returnPermuations(songs,new ArrayList<Integer>());
        System.out.println(instance.songsPermutations);
    }

    List<List<Integer>> songsSubset=new ArrayList<>();
    private void returnSubsets(int [] songs,int first,ArrayList<Integer> tmp){
        songsSubset.add(new ArrayList<>(tmp));
        for(int i=first;i<songs.length;i++){
            tmp.add(songs[i]);
            returnSubsets(songs,i+1,tmp);
            tmp.remove(tmp.size()-1);
        }
    }

    List<List<Integer>> songsPermutations=new ArrayList<>();
    private void returnPermuations(int [] songs,ArrayList<Integer> tmp){
        if(tmp.size() == songs.length) {
            songsPermutations.add(new ArrayList<>(tmp));
        }
        for(int j=0;j<songs.length;j++){
            if(tmp.contains(songs[j])) continue;
            tmp.add(songs[j]);
            returnPermuations(songs, tmp);
            tmp.remove(tmp.size()-1);
        }

    }


    private void shuffle(Integer [] songs){
        List<Integer> songsList=new ArrayList<>(Arrays.asList(songs));
        List<Integer> shuffled=new ArrayList<>();
        int n=songs.length;
        int i=0;
        while(shuffled.size() < n){
            int index= ( (int)(Math.random()*10)) % (songsList.size());
            if( shuffled.contains(songsList.get(index))) continue;
            shuffled.add(songsList.get(index));
            //songsList.remove(songsList.get(index));
            System.out.println(shuffled);
            i++;
        }
       System.out.println("Iteration Times "+i);
    }
}
