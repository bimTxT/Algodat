public class MyQueue<T> {
    Node<T> head;
    Node<T> tail;

    public boolean checkEmpty() {
        if (head == null) {
            return true;
        } else {
            return false;
        }
    }

    public void addData(T x) {
        Node<T> n = new Node<>(x);
        if (checkEmpty()) {
            head = n;
            tail = n;
        } else {
            tail.next = n;
            tail = n;
        }
        System.out.println(x + " added to queue");
    }

    public void removeData() {
        if (checkEmpty()) {
            System.out.println("Queue Empty");
        } else {
            System.out.println(head.data + " out from queue");
            head = head.next;
            if (head == null) {
                tail = null;
            }
        }
    }

    public void getFront() {
        if (checkEmpty()) {
            System.out.println("Queue empty");
        } else {
            System.out.println("Front: " + head.data);
        }
    }

    public void printQueue() {
        if (checkEmpty()) {
            System.out.println("Queue still empty");
        } else {
            Node<T> temp = head;
            System.out.print("fill queue: ");
            while (temp != null) {
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            }
            System.out.println("null");
        }
    }
}