package trie;


public class CountUniqueSubString {
    public static void main(String[] args) {
        String s1 = "abc";
        CountUniqueSubString countUniqueSubString = new CountUniqueSubString();

        System.out.println("Total number of distinct substrings : " +
               countUniqueSubString.uniqueLetterString(s1));

        String s2 = "ccfdf";
        System.out.println("Total number of distinct substrings : " +
               countUniqueSubString.uniqueLetterString(s2));
    }
    class Node{
        Node[] links;
        Node(){
            this.links =new Node[26];
        }
        boolean containsKey(Character ch){
            return this.links[ch-'a'] != null;
        }
        void put(Character ch){
            this.links[ch-'a'] = new Node();
        }
        Node get(Character ch){
            return this.links[ch-'a'];
        }
    }

    private Node root;
    CountUniqueSubString(){
        this.root = new Node();
    }
    int uniqueLetterString(String s) {
        int count = 0;
        for(int i =0;i<s.length();i++){
            Node node = root;
            for(int j =i;j<s.length();j++){
                if(!node.containsKey(s.charAt(j))){
                    node.put(s.charAt(j));
                    count++;
                }
                node = node.get(s.charAt(j));
            }
        }
        return count+1;
    }
}
