package collectionFrameWork.collection.list.linklist;

public class SingleLinkedList {

    private Node head;
    private Node tail;
    private int size = 0;

    class Node {
        private int value;
        private Node nextElement;

        Node(int value){
            this.value = value;
        }
        Node(int value,Node nextElement){
            this.value = value;
            this.nextElement = nextElement;
        }
    }

    void addFirstElement(int value){
        Node node = new Node(value);
        head=node;
        tail = node;
        size++;
    }
    void addLastElement(int value){
        Node node = new Node(value);
        tail.nextElement = node;
        tail = node;
        size++;
    }

    void addElement(int value, int index){
        if(index == 0) {
            addFirstElement(value);
            return;
        }
        else if(index == size) {
            addLastElement(value);
            return;
        }
            Node temp = head;
            for (int i = 1; i<index;i++){
                temp =temp.nextElement;
            }
            temp.nextElement = new Node(value,temp.nextElement);
            size++;

    }
    void display(){
        Node temp = head;
        while (temp !=null){
            System.out.print(temp.value+"-->");
            temp = temp.nextElement;
        }
        System.out.print("END\n\n");
        System.out.println("Head value : "+head.value);
        System.out.println("Tail value: "+tail.value);
        System.out.println("Size : "+size);
    }
}
