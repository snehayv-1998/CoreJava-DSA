package collectionFrameWork.collection.list.linklist;

public class DetectLoop {
    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addFirstElement(5);
        singleLinkedList.addLastElement(6);
        singleLinkedList.addElement(9,1);
        createCycle(singleLinkedList.getHead(),1,2);
        System.out.println("Is cycle present in the linked list: "+cycleDetect(singleLinkedList.getHead()));
    }
    static void createCycle(SingleLinkedList.Node head,int node1Index,int node2Index){
        int cnt1=0;int cnt2=0;
        SingleLinkedList.Node p1=head;
        SingleLinkedList.Node p2=head;
        while(cnt1 != node1Index || cnt2 != node2Index) {
            if(cnt1 != node1Index)
            {p1 = p1.next; ++cnt1;}
            if(cnt2 != node2Index)
            {p2 = p2.next; ++cnt2;}
        }
        p2.next = p1;
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
