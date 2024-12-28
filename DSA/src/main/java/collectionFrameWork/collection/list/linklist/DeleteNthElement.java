package collectionFrameWork.collection.list.linklist;

public class DeleteNthElement {
    /*
https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
     */
    public static void main(String[] args) {
        ListNode node = new ListNode(1,new ListNode(2));
        ListNode listNode = removeNthFromEnd(node, 1);
        System.out.println("After removing nth element:" + listNode ==null?null:listNode.val);

    }
    static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start =new ListNode();
        start.next=head;
        ListNode slow= start;ListNode fast=start;
        for(int i=1;i<=n;i++)
            fast=fast.next;
        while(fast.next!=null ){
            slow=slow.next;
            fast=fast.next;
        }
        slow.next = slow.next.next;
        return start.next;
    }
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
