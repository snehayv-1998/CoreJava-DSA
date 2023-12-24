package collectionFrameWork.collection.list.linklist;

public class MiddleOfLinkedList {
    /*
    https://leetcode.com/problems/middle-of-the-linked-list/description/
     */
    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addFirstElement(5);
        singleLinkedList.addLastElement(6);
        singleLinkedList.addElement(9,1);
        singleLinkedList.display();
        System.out.println("Middle of the linked list: "+middleNode(singleLinkedList.getHead()).value);
    }
    static SingleLinkedList.Node middleNode(SingleLinkedList.Node head) {
        SingleLinkedList.Node slow=head;SingleLinkedList.Node fast=head;
        while(fast!=null && fast.next !=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
}
