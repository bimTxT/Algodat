import linkedlist.Entity;
import linkedlist.SinglyLinkedList;

public class MainLinkedList {
    public static void main(String[] args) {
        System.out.println("=== PENGUJIAN LINKED LIST ===");
        SinglyLinkedList list = new SinglyLinkedList();

        System.out.println("\n1. Test Insert Tail:");
        list.insertTail(new Entity(10));
        list.insertTail(new Entity(20));
        list.insertTail(new Entity(30));
        list.display();

        System.out.println("\n2. Test Insert Head:");
        list.insertHead(new Entity(5));
        list.display();

        System.out.println("\n3. Test Insert Index (Indeks ke-2):");
        list.insertIndex(2, new Entity(15));
        list.display();

        System.out.println("\n4. Test Search (Nilai 20):");
        int hasilCari = list.search(new Entity(20));
        System.out.println("Ditemukan pada indeks ke-: " + hasilCari);

        System.out.println("\n5. Test Delete Head:");
        list.deleteHead();
        list.display();

        System.out.println("\n6. Test Delete Tail:");
        list.deleteTail();
        list.display();

        System.out.println("\n7. Test Delete Index (Indeks ke-1):");
        list.deleteIndex(1);
        list.display();

        System.out.println("\nTotal ukuran list saat ini: " + list.ukuran());
    }
}