package sorting;

import linkedlist.Entity;
import linkedlist.Node;
import linkedlist.SinglyLinkedList;

public class InsertionSort {
    private SinglyLinkedList list;

    public InsertionSort(SinglyLinkedList list) {
        this.list = list;
    }

    public void setList(SinglyLinkedList list) {
        this.list = list;
    }

    private int ambilNilai(Node n) {
        Object isi = n.getElemen();
        if (isi instanceof Entity) {
            return (int) ((Entity) isi).bebas;
        }
        return (int) isi;
    }

    private boolean compare(Node a, Node b) {
        int ia = ambilNilai(a);
        int ib = ambilNilai(b);
        return (ia > ib);
    }

    public void cetak(SinglyLinkedList l) {
        l.display();
    }

    private SinglyLinkedList insertToNewList(SinglyLinkedList l, Node newNode) {
        if (l.kosong()) {
            l.add(newNode);
            return l;
        } else {
            Node eval = l.getHead();
            if (this.compare(eval, newNode)) {
                newNode.setNext(eval);
                l.setHead(newNode);
            } else {
                boolean b = true;
                while ((eval.getNext() != null) && (b)) {
                    Node eval2 = eval.getNext();
                    if (this.compare(eval2, newNode)) {
                        newNode.setNext(eval2);
                        eval.setNext(newNode);
                        b = false;
                    } else {
                        eval = eval2;
                    }
                }
                if (b) {
                    eval.setNext(newNode);
                }
            }
            return l;
        }
    }

    public SinglyLinkedList insertionSort() {
        SinglyLinkedList temp = new SinglyLinkedList();
        while (this.list.getHead().getNext() != null) {
            Node t = new Node();
            t.setElemen(this.list.getHead().getElemen());
            this.list.setHead(this.list.getHead().getNext());
            temp = this.insertToNewList(temp, t);
            this.cetak(temp);
        }
        Node t = new Node();
        t.setElemen(this.list.getHead().getElemen());
        temp = this.insertToNewList(temp, t);
        this.setList(temp);
        this.cetak(temp);
        return this.list;
    }
}
