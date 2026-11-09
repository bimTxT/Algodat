public class Main {
    public static void main(String[] args) {
        MyQueue<Integer> number = new MyQueue<>();
        number.addData(10);
        number.addData(20);
        number.printQueue();

        MyQueue<String> name = new MyQueue<>();
        name.addData("Budi");
        name.addData("Siti");
        name.printQueue();
    }
}