package com.deepakm.datastructures.linkedlist.puzzles;

import com.deepakm.datastructures.linkedlist.LinkedList;
import com.deepakm.datastructures.linkedlist.Node;

/**
 * Created by dmarathe on 10/24/16.
 */
public class Driver {
    public static void main(String[] args) {

        LinkedList list = new LinkedList();
        list.append(20);
        list.prepend(5);
        list.append(100);
        list.append(200);
        list.printList();
        list.reverse();
        list.printList();
        list.reverse();
        list.printList();
    }
}
