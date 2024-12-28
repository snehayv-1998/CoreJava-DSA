package collectionFrameWork.collection.list.linklist;

public class DoublyLinkedList {
    Node head;
    Node tail;
    int size;
    void insertFirst(int value){

        if(head == null){
            Node node = new Node(value,null,null);
            head = node;
            tail = node;
        }else {
            Node node = new Node(value,head,null);
            head.prev= node;
            head = node;
        }
        size++;
    }
    void display(){
        System.out.println("\n\nDoublyLinkedList");
        Node temp = head;
        while (temp != null){
            System.out.print(temp.value+"->");
            temp = temp.next;
        }
        System.out.print("END\n");
    }

    void displayReverse(){
        System.out.println("Reversed DoublyLinkedList");
        Node temp = tail;
        while (temp != null){
            System.out.print(temp.value+"->");
            temp = temp.prev;
        }
        System.out.print("START\n");
    }
}
class Node {
    int value;
    Node next;
    Node prev;
    Node(int value,Node next,Node prev){
        this.value = value;
        this.next = next;
        this.prev = prev;
    }
}
