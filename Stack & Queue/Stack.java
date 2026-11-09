class ListNode {
    Object data;
    ListNode next;

    ListNode(Object data) {
        this.data = data;
        this.next = null;
    }
}

public class Stack {
    private ListNode top;

    public Stack() {
        top = null;
    }

    public void push(Object obj) {
        ListNode baru = new ListNode(obj);
        baru.next = top;
        top = baru;
    }

    public Object pop() {
        if (isEmpty()) {
            return null;
        }

        Object data = top.data;
        top = top.next;
        return data;
    }

    public Object top() {
        if (isEmpty()) {
            return null;
        }

        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}
