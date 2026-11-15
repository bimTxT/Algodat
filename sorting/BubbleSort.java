package sorting;

import linkedlist.Entity;
import linkedlist.Node;
import linkedlist.SinglyLinkedList;

public class BubbleSort {
    private SinglyLinkedList list;

    public BubbleSort(SinglyLinkedList list) {
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

    private void tukar(Node a, Node b) {
        Object t = a.getElemen();
        a.setElemen(b.getElemen());
        b.setElemen(t);
    }

    public void cetak() {
        this.list.display();
    }

    public void bubbleSort() {
        int n = this.list.ukuran();
        int i = 1;
        boolean b = false;
        while ((n > 0) && (!b)) {
            Node aktif = list.getHead();
            i = 1;
            b = true;
            while ((n > 0) && (i < n)) {
                if (this.compare(aktif, aktif.getNext())) {
                    this.tukar(aktif, aktif.getNext());
                    b = false;
                }
                aktif = aktif.getNext();
                i++;
            }
            this.cetak();
            n--;
        }
    }
}
