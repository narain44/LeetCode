package TreesTries;


public class Trie {
    /**
     * Initialize your data structure here.
     */

    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!node.containsKey(c)) {
                node.setKey(c,new TrieNode());
            }
            node = node.getKey(c);
        }
        node.setEnd(true);
        return;
    }

    private TrieNode searchPrefix(String word){
        TrieNode node=root;
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            if(node.containsKey(c)){
                node=node.getKey(c);
            }else{
                return null;
            }
        }
        return node;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode node=searchPrefix(word);
        if(node == null || !node.getEnd()){
            return false;
        }
        return true;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode node=searchPrefix(prefix);
        if(node == null){
            return false;
        }
        return true;
    }

    public static void main(String []args){
        Trie instance=new Trie();
        instance.insert("app");
    }
}


class TrieNode{
    private TrieNode[] links;
    private boolean endNode;
    public TrieNode(){
        links=new TrieNode[26];
        endNode=false;
    }

    public boolean containsKey(char c){
        if(links[c-'a']!= null) return true;
        return false;
    }

    public TrieNode getKey(char c){
        return links[c-'a'];
    }

    public void setKey(char c,TrieNode tn){
        links[c-'a']=tn;
    }

    public void setEnd(boolean val){
        this.endNode=val;
    }
    public boolean getEnd(){
        return this.endNode;
    }

}