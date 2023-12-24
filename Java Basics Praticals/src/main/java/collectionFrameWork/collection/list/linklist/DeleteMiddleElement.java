package collectionFrameWork.collection.list.linklist;

public class DeleteMiddleElement {
    /*
    https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/submissions/
     */
    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addFirstElement(5);
        singleLinkedList.addLastElement(6);
        singleLinkedList.addElement(9,1);
        singleLinkedList.display();
        System.out.println("After deleting Middle of the linked list: ");
        singleLinkedList.display(middleNode(singleLinkedList.getHead()));
    }
    static SingleLinkedList.Node middleNode(SingleLinkedList.Node head) {
        SingleLinkedList.Node slow=head;SingleLinkedList.Node fast=head;
        SingleLinkedList.Node last=head;
        while(fast!=null && fast.next !=null){
            last=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        last.next=slow.next;
        return head;
    }
}
