package collections.linklist;

import java.util.HashSet;
import java.util.LinkedList;

public class LinkedListQuestions {
    public static void main(String[] args) {
        //linked list using recursion
        {
        /*
        Remove duplicate element in linked list
        input: 1->1->2->3->3->3
        output: 1->2->3
         */
            LinkedList<Integer> duplicate = new LinkedList<>();
            duplicate.add(1);
            duplicate.add(1);
            duplicate.add(2);
            duplicate.add(3);
            duplicate.add(3);
            duplicate.add(4);
            duplicate.add(3);
            duplicate.add(4);

            System.out.println("\n\nBefore removing duplicates : "+duplicate);
            System.out.println("After removing duplicates : "+removeDuplicatesWithBuiltIn(duplicate));
        }
        {
            /**
             * Given the head of a sorted linked list, delete all duplicates such that each element appears only once.
             * Return the linked list sorted as well.
             * Definition for singly-linked list.
             * public class ListNode {
             *     int val;
             *     ListNode next;
             *     ListNode() {}
             *     ListNode(int val) { this.val = val; }
             *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
             * }
             */

            ListNode node3 = new ListNode(3,new ListNode(3));
            ListNode node2 = new ListNode(2,node3);
            ListNode node1 = new ListNode(1,node2);
            ListNode head = new ListNode(1,node1);
            System.out.println("\n\nBefore removing duplicates : ");
            display(head);
            System.out.println("After removing duplicates : ");
            display(deleteDuplicates(head));
        }
        {
            /*
            You are given the heads of two sorted linked lists list1 and list2.
            Merge the two lists into one sorted list. The list should be made by splicing together
            the nodes of the first two lists.Return the head of the merged linked list.
            Input: list1 = [1,2,4], list2 = [1,3,4]
            Output: [1,1,2,3,4,4]
            Example 2:
            Input: list1 = [], list2 = []
            Output: []
            Example 3:
            Input: list1 = [], list2 = [0]
            Output: [0]
             */
            ListNode node1 = new ListNode(2,new ListNode(4));
            ListNode head1 = new ListNode(1,node1);
            ListNode node2 = new ListNode(3,new ListNode(4));
            ListNode head2 = new ListNode(1, node2);

            System.out.println("\n\nBefore head1 : ");
            display(head1);
            System.out.println("Before head2 : ");
            display(head2);
            System.out.println("After merge :");
            display(merge(head1,head2));

        }
    }

    private static LinkedList<Integer> removeDuplicatesWithBuiltIn(LinkedList<Integer> duplicate) {
        HashSet<Integer> set = new HashSet<>();
        for (int i =0;i<duplicate.size();i++){
            if(set.contains(duplicate.get(i))){
                duplicate.remove(i);
                i--;
            }else {
                set.add(duplicate.get(i));
            }
        }
        return duplicate;
    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next;}

    }
    public static ListNode deleteDuplicates(ListNode current) {
        if(current == null)return null;
        ListNode head = current;
        while(current.next != null){
            if(current.val == current.next.val){
                current.next =current.next.next;
            }else{
                current = current.next;
            }
        }
        return head;
    }
    static void display(ListNode head){
        if(head == null) System.out.println("");
        ListNode cur = head;
        while(cur != null){
            System.out.print(cur.val+"->");
            cur = cur.next;
        }
        System.out.println("END");
    }


    private static ListNode merge(ListNode head1, ListNode head2) {
        ListNode res= new ListNode();

        if(head1.val>head2.val){
            res.val= head2.val;
            head2 = head2.next;
        }else if(head1.val<head2.val){
            res.val= head1.val;
            head1= head1.next;
        }else {
            res.val= head1.val;
            res.next.val=head2.val;
            head1= head1.next;
            head2=head2.next;
        }
        ListNode resHead = res;
        while (head1.next != null || head2.next != null){
            if(head1.val>head2.val){
                res.next= head2;
                head2 = head2.next;
            }else if(head1.val<head2.val){
                res.next= head1;
                head1= head1.next;
            }else {
                res.next= head1;
                head1= head1.next;
                head2=head2.next;
            }
        }
        if(head1!= null)
            res.next = head1;
        if (head2 != null)
            res.next = head2;
        return resHead;
    }
}
