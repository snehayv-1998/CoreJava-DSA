package tree;

public class TreeMain {
    public static void main(String[] args) {
        System.out.println("\n\n Binary tree:");
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insert(5);
        binaryTree.insert(6);
        binaryTree.insert(7);
        binaryTree.insert(8);
        binaryTree.insert(88);
        binaryTree.display();
    }
}
