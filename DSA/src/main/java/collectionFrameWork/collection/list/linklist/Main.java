package collectionFrameWork.collection.list.linklist;

public class Main {
    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addFirstElement(5);
        singleLinkedList.addLastElement(6);
        singleLinkedList.addElement(9,1);
        singleLinkedList.display();

        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.insertFirst(5);
        doublyLinkedList.insertFirst(9);
        doublyLinkedList.insertFirst(1);
        doublyLinkedList.insertFirst(2);
        doublyLinkedList.display();
        doublyLinkedList.displayReverse();

    }
}
