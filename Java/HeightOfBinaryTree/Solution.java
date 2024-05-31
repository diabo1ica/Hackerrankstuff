package Java.HeightOfBinaryTree;

import java.util.*;

class BinaryTree {
    private Node root;
    private int height;

    public BinaryTree() {
        root = null;
    }

    public void insert(int val) {
        root = setNode(root, val);
    }

    public Node setNode(Node node, int val) {
        if (node == null) {
            node = new Node(val);
            return node;
        }
        if (node.getVal() > val) {
            node.setLeft(setNode(node.getLeft(), val));
        }
        if (node.getVal() < val) {
            node.setRight(setNode(node.getRight(), val));
        }
        return node;
    }

    public void preOrder() {
        traverse(root, height - 1);
        System.out.println(height);
    }

    public void traverse(Node node, int localHeight) {
        if (node!= null) {
            localHeight += 1;
            traverse(node.getLeft(), localHeight);
            traverse(node.getRight(), localHeight);
        }
        else if (localHeight > this.height) {
            this.height = localHeight;
        }
    }
}

class Node {
    private int val;
    private Node left;
    private Node right;

    public Node(int num) {
        this.val = num;
        left = null;
        right = null;
    }

    public int getVal() {
        return this.val;
    }

    public void setVal(int num) {
        this.val = num;
    }

    public Node getLeft() {
        return this.left;
    }

    public void setLeft(Node node) {
        this.left = node;
    }

    public Node getRight() {
        return this.right;
    }

    public void setRight(Node node) {
        this.right = node;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> list = new ArrayList<>();
     
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        sc.close();
    
        BinaryTree bt = new BinaryTree();
        for (int num: list) {
            bt.insert(num);
        }

        bt.preOrder();
    }

}



