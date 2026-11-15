package sorting;

import linkedlist.Entity;
import linkedlist.Node;
import linkedlist.SinglyLinkedList;

public class SelectionSort {
    private SinglyLinkedList list;

    public SelectionSort(SinglyLinkedList list) {
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

    public void selectionSort() {
        Node aktif = this.list.getHead();
        while (aktif.getNext() != null) {
            Node berjalan = aktif;
            Node terkecil = aktif;
            while (berjalan.getNext() != null) {
                berjalan = berjalan.getNext();
                if (this.compare(terkecil, berjalan)) {
                    terkecil = berjalan;
                }
            }
            if (this.compare(terkecil, berjalan)) terkecil = berjalan;
            this.tukar(aktif, terkecil);
            this.cetak();
            aktif = aktif.getNext();
        }
    }
}
