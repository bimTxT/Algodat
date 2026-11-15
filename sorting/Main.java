import linkedlist.Entity;
import linkedlist.SinglyLinkedList;
import sorting.BubbleSort;
import sorting.InsertionSort;
import sorting.MergeSort;
import sorting.QuickSort;
import sorting.SelectionSort;
import sorting.ShellSort;

public class Main {
    public static SinglyLinkedList buatDataAwal() {
        int[] data = {4, 8, 2, 7, 9, 6, 5, 1, 3};
        SinglyLinkedList l = new SinglyLinkedList();
        for (int i = 0; i < data.length; i++) {
            l.insertTail(new Entity(data[i]));
        }
        return l;
    }

    public static void main(String[] args) {
        System.out.println("=== BUBBLE SORT ===");
        SinglyLinkedList listBubble = buatDataAwal();
        System.out.print("Data Awal : ");
        listBubble.display();
        BubbleSort bs = new BubbleSort(listBubble);
        bs.bubbleSort();
        System.out.print("Hasil Akhir : ");
        listBubble.display();
        System.out.println();

        System.out.println("=== SELECTION SORT ===");
        SinglyLinkedList listSelection = buatDataAwal();
        System.out.print("Data Awal : ");
        listSelection.display();
        SelectionSort ss = new SelectionSort(listSelection);
        ss.selectionSort();
        System.out.print("Hasil Akhir : ");
        listSelection.display();
        System.out.println();

        System.out.println("=== INSERTION SORT ===");
        SinglyLinkedList listInsertion = buatDataAwal();
        System.out.print("Data Awal : ");
        listInsertion.display();
        InsertionSort is = new InsertionSort(listInsertion);
        listInsertion = is.insertionSort();
        System.out.print("Hasil Akhir : ");
        listInsertion.display();
        System.out.println();

        System.out.println("=== SHELL SORT ===");
        SinglyLinkedList listShell = buatDataAwal();
        System.out.print("Data Awal : ");
        listShell.display();
        ShellSort shs = new ShellSort(listShell);
        shs.shellSort();
        System.out.print("Hasil Akhir : ");
        listShell.display();
        System.out.println();

        System.out.println("=== MERGE SORT ===");
        SinglyLinkedList listMerge = buatDataAwal();
        System.out.print("Data Awal : ");
        listMerge.display();
        MergeSort ms = new MergeSort(listMerge);
        System.out.print("Hasil Akhir : ");
        ms.sort();
        System.out.println();

        System.out.println("=== QUICK SORT ===");
        SinglyLinkedList listQuick = buatDataAwal();
        System.out.print("Data Awal : ");
        listQuick.display();
        QuickSort qs = new QuickSort(listQuick);
        System.out.print("Hasil Akhir : ");
        qs.sort();
    }
}
