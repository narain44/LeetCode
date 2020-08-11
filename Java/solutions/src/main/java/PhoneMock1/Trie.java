package PhoneMock1;

import java.util.HashSet;
import java.util.Set;

public class Trie {


    /**
     * Initialize your data structure here.
     */
    Set<String> trieValue = new HashSet<String>();

    public Trie() {
        //trieValue=new String();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        trieValue.add(word);
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        for (String trieWord : trieValue) {
            if (trieWord.equals(word)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        for (String trieWord : trieValue) {
            if (prefix.length() > trieWord.length()) {
                continue;
            } else {
                String triePrefix = trieWord.substring(0, prefix.length());
                if (triePrefix.equals(prefix)) {
                    return true;
                }
            }

        }
        return false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

