abstract class AbstractList {
    Node head;

    public abstract void insertHead(Object data);
    public abstract void insertTail(Object data);
    public abstract void insertIndex(int index, Object data);
    public abstract void deleteHead();
    public abstract void deleteTail();
    public abstract void deleteIndex(int index);
    public abstract int search(Object key);
    public abstract void display();
}

public class SinglyLinkedList extends AbstractList {

    public SinglyLinkedList() {
        this.head = null;
    }

    @Override
    public void insertHead(Object data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    @Override
    public void insertTail(Object data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    @Override
    public void insertIndex(int index, Object data) {
        if (index == 0) {
            insertHead(data);
            return;
        }
        Node newNode = new Node(data);
        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            if (current == null) {
                System.out.println("Indeks melebihi panjang list!");
                return;
            }
            current = current.next;
        }
        if (current == null) {
            System.out.println("Indeks melebihi panjang list!");
            return;
        }
        newNode.next = current.next;
        current.next = newNode;
    }

    @Override
    public void deleteHead() {
        if (head == null) {
            System.out.println("List kosong, tidak ada yang bisa dihapus.");
            return;
        }
        head = head.next;
    }

    @Override
    public void deleteTail() {
        if (head == null) {
            System.out.println("List kosong!");
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
    }

    @Override
    public void deleteIndex(int index) {
        if (head == null || index < 0) {
            System.out.println("Operasi tidak valid!");
            return;
        }
        if (index == 0) {
            deleteHead();
            return;
        }
        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            if (current == null || current.next == null) {
                System.out.println("Indeks di luar jangkauan!");
                return;
            }
            current = current.next;
        }
        if (current.next == null) {
            System.out.println("Indeks di luar jangkauan!");
            return;
        }
        current.next = current.next.next;
    }

    @Override
    public int search(Object key) {
        Node current = head;
        int index = 0;
        while (current != null) {
            if (current.data != null && current.data.equals(key)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    @Override
    public void display() {
        if (head == null) {
            System.out.println("List kosong.");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}