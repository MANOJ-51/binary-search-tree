package com.binary.searchtree;

public class BinarySearchTree<M extends Comparable<M>> {

    static MyBinaryNode root;

    public static void main(String[] args) {
        System.out.println("WELCOME TO BINARY SEARCH TREE");
        System.out.println(" ");
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<Integer>();
        binarySearchTree.add(56);    //                            56
        binarySearchTree.add(30);    //               30                     70
        binarySearchTree.add(70);    //           22      40            60          95
        binarySearchTree.add(22);    //       11                            65
        binarySearchTree.add(40);    //    3      16                   63      67
        binarySearchTree.add(11);
        binarySearchTree.add(3);
        binarySearchTree.add(16);
        binarySearchTree.add(60);
        binarySearchTree.add(95);
        binarySearchTree.add(63);
        binarySearchTree.add(65);
        binarySearchTree.add(67);
        //size
        System.out.println("size of the binary search tree:" + binarySearchTree.size());
        System.out.println("");

        //search
        System.out.println("search result :" + binarySearchTree.search(63));

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
        root = insertElementRecursive(root, key);
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

    //finding size of the root
    public int findSize(MyBinaryNode<M> root) {
        if (root == null) {
            return 0;
        } else {
            return findSize(root.right) + 1 + findSize(root.left);
        }
    }

    public int size() {
        return findSize(root);
    }

    //search recursiive method
    public boolean searchRecurssive(MyBinaryNode<M> root, M key) {     //                 56
        if (root == null) {                                           //         30               70
            return false;                                              //    22     40        60        95
        } else if (key.compareTo(root.key) == 0) {                   //   11                      65
            return true;                                             // 3     16               63    67
        } else {
            if (key.compareTo(root.key) < 0) {
                return searchRecurssive(root.left, key);
            } else {
                return searchRecurssive(root.right, key);
            }
        }
    }

    public boolean search(M key) {
        return searchRecurssive(root, key);
    }

}
