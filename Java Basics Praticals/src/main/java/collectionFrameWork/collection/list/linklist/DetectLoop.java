package collectionFrameWork.collection.list.linklist;

public class DetectLoop {
    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addFirstElement(5);
        singleLinkedList.addLastElement(6);
        singleLinkedList.addElement(9,1);
        singleLinkedList.display();
        System.out.println("Is cycle present in the linked list: "+cycleDetect(singleLinkedList.getHead()));
    }
    static boolean cycleDetect(SingleLinkedList.Node head) {
        SingleLinkedList.Node slow=head;SingleLinkedList.Node fast=head;
        while(fast!=null && fast.next !=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }
}
