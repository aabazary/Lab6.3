package edu.sdccd.cisc191;

class SinglyLinkedList<T> {
    class Node {
        T data;
        Node next;

        public Node(T newData, Node head) {
            this.data = newData;
            this.next = head;
        }
    }

    ;

    /**
     * recursively finds k-th node, deletes, and returns new head
     *
     * @param head the node to start at
     * @param k    the kth element to remove (first element at 0)
     * @return the new head node with the kth element removed
     */
    public Node remove(Node head, int k) {
        try {

            if (k == 1) {
                Node next = head.next;
                head.next = next.next;
                next.next = null;
                next.data = null;
            } else {
                remove(head.next, --k);
            }
        } catch (NullPointerException e) {
            System.err.println("Reached end of linked list");
        }
        return head;
    }

    /**
     * inserts node at the beginning of the list
     *
     * @param head     the node to start at
     * @param new_data data to insert into the list
     * @return the new head node containing new_data followed with the rest of the linked list
     */
    public Node push(Node head, T new_data) {

        return new Node(new_data, head);
    }

    /**
     * recursively prints list starting from head
     *
     * @param head the node to start at
     * @return a space separated string containing the data of each node starting from the head to the tail, end with a trailing space
     */
    public String toString(Node head) {
        try {
            return head.data + " " + toString(head.next);
        } catch (NullPointerException e) {
            return head.data.toString();
        }

    }
}