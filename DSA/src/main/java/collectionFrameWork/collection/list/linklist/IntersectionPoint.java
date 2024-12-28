package collectionFrameWork.collection.list.linklist;

public class IntersectionPoint {
    /*
    https://leetcode.com/problems/intersection-of-two-linked-lists/description/
     */
    public static void main(String[] args) {

    }
    DeleteNthElement.ListNode getIntersectionNode(DeleteNthElement.ListNode headA, DeleteNthElement.ListNode headB) {
        if(headA == null || headB==null) return null;
        DeleteNthElement.ListNode a = headA;
        DeleteNthElement.ListNode b = headB;
        while(a!=b){
            a= a==null?headB:a.next;
            b= b==null?headA:b.next;
        }
        return a;
    }
}
