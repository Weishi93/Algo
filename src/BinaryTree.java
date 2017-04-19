import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wei Shi on 11/3/16.
 */

public class BinaryTree<E> {
    class Node {
        E data;
        Node left, right;
        public Node(E data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
    Node root;
    public BinaryTree() {
        root = null;
    }

    public void inorder(Node root, List<E> list) {
        if (root == null) {
            return;
        }
        inorder(root.left, list);
        list.add(root.data);
        inorder(root.right, list);
    }

    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();
//        BinaryTree.Node n0 = new tree.Node(1);

        tree.root = tree.new Node(0);
        BinaryTree.Node n1 = tree.new Node(1);
        BinaryTree.Node n2 = tree.new Node(2);
        BinaryTree.Node n3 = tree.new Node(3);
        BinaryTree.Node n4 = tree.new Node(4);
        BinaryTree.Node n5 = tree.new Node(5);
        tree.root.left = n1;
        tree.root.right = n2;
        n1.left = n3;
        n2.left = n4;
        n2.right = n5;
        List<Integer> list = new ArrayList<>();
        tree.inorder(tree.root, list);
        System.out.println(list);


    }
}
