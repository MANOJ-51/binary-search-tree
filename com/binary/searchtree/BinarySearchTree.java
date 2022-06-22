package com.binary.searchtree;

public class BinarySearchTree<M extends Comparable<M>> {

    static MyBinaryNode root;

    public static void main(String[] args) {
        System.out.println("WELCOME TO BINARY SEARCH TREE");
        System.out.println(" ");
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<Integer>();
        binarySearchTree.add(56);    //        56
        binarySearchTree.add(30);    //   30       \
        binarySearchTree.add(70);    //              70

        System.out.println("In Order Traversal:- left , root ,right ");
        binarySearchTree.inOrderTraversal(root);
        System.out.println("");

        System.out.println("Pre Order Traversal :- root ,left ,right ");
        binarySearchTree.preOrderTraversal(root);
        System.out.println("");

        System.out.println("Post Order Traversal :- left , right , root ");
        binarySearchTree.postOrderTraversal(root);
        System.out.println("");


    }

    //assigning data in binary tree format
    public MyBinaryNode<M> insertElementRecursive(MyBinaryNode<M> root, M key) {
        if (root == null) {
            root = new MyBinaryNode(key);
            return root;
        }
        if (key.compareTo(root.key) < 0) {       //compare root wit key if <than root will assign left side
            root.left = insertElementRecursive(root.left, key);
        } else if (key.compareTo(root.key) > 0) {  //compare root with key if >than root will assign to right hand side
            root.right = insertElementRecursive(root.right, key);
        }
        return root;
    }

    //adding keys recursively
    public void add(M key) {
        this.root = insertElementRecursive(root, key);
    }

    //in order traversal:- left ,root ,right
    public void inOrderTraversal(MyBinaryNode<M> node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left);
        System.out.println(node.key + " ");
        inOrderTraversal(node.right);
    }

    //preorder traversal :- root ,left ,right
    public void preOrderTraversal(MyBinaryNode<M> node) {
        if (node == null) {
            return;
        }
        System.out.println(node.key + " ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    //Post order traversal :- left , root , right
    public void postOrderTraversal(MyBinaryNode<M> node) {
        if (node == null) {
            return;
        }
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.println(node.key + " ");
    }

}
