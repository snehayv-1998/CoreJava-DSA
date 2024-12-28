package trie;

import java.util.HashMap;
import java.util.Map;

/*https://leetcode.com/problems/count-unique-characters-of-all-substrings-of-a-given-string/description/*/
public class CountUniqueSubStringWithHashmap {
    public static void main(String[] args) {
        String s1 = "ABC";
        CountUniqueSubStringWithHashmap countUniqueSubString = new CountUniqueSubStringWithHashmap();

        System.out.println("Total number of distinct substrings : " +
               countUniqueSubString.uniqueLetterString(s1));

        String s2 = "ccfdf";
        System.out.println("Total number of distinct substrings : " +
               countUniqueSubString.uniqueLetterString(s2));
    }
    class Node{
        Map<Character,Node> links;
        Node(){
            this.links =new HashMap<>();
        }
    }
    private Node root;
    CountUniqueSubStringWithHashmap(){
        this.root = new Node();
    }
    int uniqueLetterString(String s) {
        int count = 0;
        for(int i =0;i<s.length();i++){
            Node node = root;
            for(int j =i;j<s.length();j++){
                if(!node.links.containsKey(s.charAt(j))){
                    node = node.links.computeIfAbsent(s.charAt(j),c->new Node());
                    count++;
                }else
                    node = node.links.get(s.charAt(j));
            }
        }
        return count+1;
    }
}
