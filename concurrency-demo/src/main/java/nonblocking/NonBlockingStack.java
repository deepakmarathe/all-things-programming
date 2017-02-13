package nonblocking;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by dmarathe on 10/27/16.
 */
public class NonBlockingStack<E> {
    //create a node;
    public static class Node<E> {
        E item;
        Node<E> next;

        public Node(E value) {
            this.item = value;
        }
    }

    AtomicReference<Node<E>> nodeAtomicReference = new AtomicReference<>();

    public void push(E element) {
        while (true) {
            Node<E> oldHead;
            Node<E> newHead = new Node<>(element);
            do {
                oldHead = nodeAtomicReference.get();
                newHead.next = oldHead;
            } while (!nodeAtomicReference.compareAndSet(oldHead, newHead));
        }
    }

    public E pop() {
        while (true) {
            Node<E> oldHead;
            Node<E> newHead;
            do {
                oldHead = nodeAtomicReference.get();
                if (oldHead == null) {
                    return null;
                }
                newHead = oldHead.next;
            }while(!nodeAtomicReference.compareAndSet(oldHead, newHead));
            return oldHead.item;
        }
    }
}
