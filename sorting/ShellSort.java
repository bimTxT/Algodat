package sorting;

import linkedlist.Entity;
import linkedlist.Node;
import linkedlist.SinglyLinkedList;

public class ShellSort {
    private SinglyLinkedList list;

    public ShellSort(SinglyLinkedList list) {
        this.list = list;
    }

    private int ambilNilai(Node n) {
        Object isi = n.getElemen();
        if (isi instanceof Entity) {
            return (int) ((Entity) isi).bebas;
        }
        return (int) isi;
    }

    private boolean bandingkan(Node a, Node b) {
        int ia = ambilNilai(a);
        int ib = ambilNilai(b);
        return (ia > ib);
    }

    private void tukar(Node a, Node b) {
        Object t = a.getElemen();
        a.setElemen(b.getElemen());
        b.setElemen(t);
    }

    private Node getNextGap(Node aktif, int gap) {
        int i = 0;
        Node theNextGap = aktif;
        while (i < gap) {
            i++;
            if (aktif.getNext() != null) aktif = aktif.getNext();
            else {
                theNextGap = null;
                break;
            }
            theNextGap = aktif;
        }
        return theNextGap;
    }

    public void bubbleSort() {
        BubbleSort bs = new BubbleSort(this.list);
        bs.bubbleSort();
    }

    public void shellSort() {
        int n = this.list.ukuran();
        int gap = n / 2;
        while (gap >= 2) {
            Node aktif = this.list.getHead();
            while (this.getNextGap(aktif, gap) != null) {
                Node gapNode = this.getNextGap(aktif, gap);
                if (this.bandingkan(aktif, gapNode))
                    this.tukar(aktif, gapNode);
                aktif = aktif.getNext();
            }
            this.list.display();
            gap /= 2;
        }
        this.bubbleSort();
    }
}
