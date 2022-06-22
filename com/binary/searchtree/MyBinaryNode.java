package com.binary.searchtree;

public class MyBinaryNode<M extends Comparable<M>> {
    M key;
    MyBinaryNode<M> left;
    MyBinaryNode<M> right;

    public MyBinaryNode(M key) {
        this.key = key;
        this.left = left;
        this.right = right;
    }
}
