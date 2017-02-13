package com.deepakm.datastructures.linkedlist;

import com.deepakm.datastructures.linkedlist.Node;

/**
 * Created by dmarathe on 10/24/16.
 */
public class LinkedList {
    private Node head;

    public LinkedList() {

    }

    public void append(int data) {
        if (head == null) {
            head = new Node(data);
        } else {
            Node node = new Node(data);
            Node temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(node);
        }
    }

    public void prepend(int data) {
        if (head == null) {
            head = new Node(data);
        } else {
            Node node = new Node(data);
            node.setNext(head);
            head = node;
        }
    }

    public void reverse() {
        head = reverse(head);
//        printList(n);
    }

    private Node reverse(Node node) {
        Node previous = null;
        Node current = node;
        Node next = null;
        while (current != null) {
            next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
        }
        node = previous;
        return node;
    }

    public void printList() {
        printList(head);
    }

    private void printList(Node node) {
        Node temp = node;
        while (temp != null) {
            System.out.println(temp.getData());
            temp = temp.getNext();
        }
    }
}
