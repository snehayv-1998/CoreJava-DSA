package arrayAndHashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class FlatteningArray {
    static List<Integer> res = null;
    int curr=0;
    public static void main(String[] args) {
        /*

         */
        NestedInteger ni1 = new NestedInteger(1);
        List<NestedInteger> nes = new ArrayList<>();
        nes.add(new NestedInteger(2));
        nes.add(new NestedInteger(3));
        NestedInteger ni2 = new NestedInteger(nes);

        NestedInteger ni3 = new NestedInteger(4);
        List<NestedInteger> nes2 = new ArrayList<>();
        nes2.add(new NestedInteger(5));
        nes2.add(new NestedInteger(3));
        nes2.add(new NestedInteger(nes));
        NestedInteger ni4 = new NestedInteger(nes2);

        List<NestedInteger> nestedList = new ArrayList<>();
        nestedList.add( ni1);nestedList.add( ni2); nestedList.add(ni3);nestedList.add(ni4);
        nestedIterator(nestedList);
        System.out.println("Flaten list : "+ res);
    }


    static void nestedIterator(List<NestedInteger> nestedList) {
        res = new ArrayList<>();
        for(NestedInteger nes: nestedList){
            helper(nes);
        }
    }

    public Integer next() {
        return res.get(curr++);
    }


    public boolean hasNext() {
        return curr<res.size();
    }
    static void helper(NestedInteger v){
        if(v.isInteger()) res.add(v.getInteger());
        else{
            for(NestedInteger nes: v.getList()){
                helper(nes);
            }
        }
    }

    static class NestedInteger{
        Integer intVal;
        List<NestedInteger> list;

        public NestedInteger(int v) {
            this.intVal = v;
        }
        public NestedInteger(List list) {
            this.list = list;
        }

        public boolean isInteger() {
            return intVal!=null;
        }

        public Integer getInteger() {
            return intVal;
        }

        public List<NestedInteger> getList() {
            return list;
        }
    }
}
