package com.deepakm.datastructures.linkedlist;

/**
 * Created by dmarathe on 10/24/16.
 */
public class Node {
    private int data;
    private Node next;

    public Node(int data){
        setData(data);
        setNext(null);
    }
    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
