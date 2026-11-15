package linkedlist;

public abstract class AbstractList {
    public Node head;

    public abstract void insertHead(Object data);
    public abstract void insertTail(Object data);
    public abstract void insertIndex(int index, Object data);
    public abstract void deleteHead();
    public abstract void deleteTail();
    public abstract void deleteIndex(int index);
    public abstract int search(Object key);
    public abstract void display();
}
