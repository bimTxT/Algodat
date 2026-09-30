class Mahasiswa extends Entity {
    public Mahasiswa(Object bebas) {
        super(bebas);
    }

    public void teks() {
        System.out.println("Hi My name is  " + this.bebas);
    }
}

class Tahun extends Entity {
    public Tahun(Object bebas) {
        super(bebas);
    }

    public void teks() {
        System.out.println("now is " + this.bebas);
    }
}

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        list.insertTail(new Mahasiswa("Budi"));
        list.insertTail(new Tahun(2026));
        list.insertHead(new Mahasiswa("Yanto"));
        list.insertIndex(2, new Tahun(2019));
        list.display();

        Node current = list.head;
        while (current != null) {
            if (current.data instanceof Mahasiswa) {
                ((Mahasiswa) current.data).teks();
            } else if (current.data instanceof Tahun) {
                ((Tahun) current.data).teks();
            }
            current = current.next;
        }

        list.deleteHead();
        list.deleteTail();
        list.deleteIndex(1);
        list.display();

        System.out.println("Budi: indeks " + list.search(new Mahasiswa("Budi")));
        System.out.println("2017: indeks " + list.search(new Tahun(2017)));
    }
}