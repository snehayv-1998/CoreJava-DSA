package trie;

import java.util.HashMap;
import java.util.Map;

public class TrieBasicOperation {
    static class TrieNode{
        Map<Character,TrieNode> child;
        boolean flag;
        TrieNode(){
            this.child= new HashMap<>();
            this.flag = false;
        }
    }
    TrieNode root;

    public TrieBasicOperation() {
       this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for(Character ch : word.toCharArray()){
           node= node.child.computeIfAbsent(ch,c-> new TrieNode());
        }
        node.flag=true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        for(Character ch : word.toCharArray()){
            if(node == null || !node.child.containsKey(ch)){
                return false;
            }
            node = node.child.get(ch);
        }
        return node!=null && node.flag;
    }

     boolean startsWith(String prefix) {
        TrieNode node = root;
        for(Character ch : prefix.toCharArray()){
            if(!node.child.containsKey(ch))
                return false;
           node = node.child.get(ch);
        }
       return true;
    }

    public static void main(String[] args) {
        TrieBasicOperation trie = new TrieBasicOperation();
        trie.insert("Programming");
        trie.insert("is");
        trie.insert("a");
        trie.insert("way");
        trie.insert("of");
        trie.insert("life");
        System.out.println("a is present in tries : "+trie.search("a"));
        System.out.println("way is present in tries : "+trie.search("way"));
        System.out.println("away is present in tries : "+trie.search("away"));
        System.out.println("There is a word in tries that starts with Pro : "+trie.startsWith("Pro"));
    }

}
