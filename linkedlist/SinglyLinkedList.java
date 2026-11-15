package linkedlist;

public class SinglyLinkedList extends AbstractList {

    public SinglyLinkedList() {
        this.head = null;
    }

    public Node getHead() {
        return this.head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public boolean kosong() {
        return this.head == null;
    }

    public int ukuran() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public void add(Node newNode) {
        newNode.next = null;
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

    public int[] toArray() {
        int n = ukuran();
        int[] arr = new int[n];
        Node current = head;
        int i = 0;
        while (current != null) {
            if (current.data instanceof Entity) {
                arr[i] = (int) ((Entity) current.data).bebas;
            } else {
                arr[i] = (int) current.data;
            }
            current = current.next;
            i++;
        }
        return arr;
    }

    public void fromArray(int[] arr) {
        head = null;
        for (int i = 0; i < arr.length; i++) {
            insertTail(new Entity(arr[i]));
        }
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
