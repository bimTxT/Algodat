package sorting;

import linkedlist.SinglyLinkedList;

public class QuickSort {
    private SinglyLinkedList list;

    public QuickSort(SinglyLinkedList list) {
        this.list = list;
    }

    public void sort() {
        int[] array = this.list.toArray();
        quickSort(array, 0, array.length - 1);
        this.list.fromArray(array);
        this.list.display();
    }

    public void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);

            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    public int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;

                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }
}
