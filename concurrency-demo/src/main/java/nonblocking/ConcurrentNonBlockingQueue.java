package nonblocking;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by dmarathe on 10/30/16.
 */
public class ConcurrentNonBlockingQueue<E> {
    static class Node<E> {
        E item;
        AtomicReference<Node<E>> next;

        public Node(E item, Node<E> next) {
            this.item = item;
            this.next = new AtomicReference<>(next);
        }
    }

    private Node<E> dummy = new Node<>(null, null);
    private AtomicReference<Node<E>> head = new AtomicReference<>(dummy);
    private AtomicReference<Node<E>> tail = new AtomicReference<>(dummy);

    public boolean put(E item) {
        Node<E> newNode = new Node<>(item, null);
        while (true) {
            Node<E> currentTail = tail.get();
            Node<E> tailNext = currentTail.next.get();
            if (currentTail == tail.get()) {
                if (tailNext != null) {
                    return tail.compareAndSet(currentTail, newNode);
                } else {
                    if (currentTail.next.compareAndSet(null, newNode)) {
                        tail.compareAndSet(currentTail, newNode);
                        return true;
                    }
                }
            }
        }
    }

    public E take() {
        for (; ; ) {
            System.out.println("in loop");
            Node<E> oldHead = head.get();
            Node<E> oldTail = tail.get();
            Node<E> oldHeadNext = oldHead.next.get();

            if (oldHead == head.get()) { //if nothing has changed
                if (oldHead == oldTail) {
                    if (oldHeadNext == null)
                        return null; //empty queue
                    tail.compareAndSet(oldTail, oldHeadNext);
                } else {
                    if (head.compareAndSet(oldHead, oldHeadNext))
                        return oldHead.item;


                }
            }
        }
    }

    public static void main(String[] args) {
        ConcurrentNonBlockingQueue<String> queue = new ConcurrentNonBlockingQueue<String>();
        queue.put("deepak");
        queue.put("deepak");

        System.out.println("put done");
        String s = queue.take();
        System.out.println(s == null);
        System.out.println(s == "deepak");
        System.out.println(s.equals("deepak"));
    }
}
