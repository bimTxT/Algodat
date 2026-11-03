import java.util.Scanner;

public class EvaluatingPostfix {

    static double calculate(String exp) {
        Stack stack = new Stack();

        exp = exp.replace(" ", "");

        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);

            if (Character.isDigit(c)) {
                stack.push((double) (c - '0'));
            } else {
                double b = (double) stack.pop();
                double a = (double) stack.pop();
                double hasil = 0;

                if (c == '+') {
                    hasil = a + b;
                } else if (c == '-') {
                    hasil = a - b;
                } else if (c == '*') {
                    hasil = a * b;
                } else if (c == '/') {
                    hasil = a / b;
                } else if (c == '^') {
                    hasil = Math.pow(a, b);
                }

                stack.push(hasil);
            }
        }

        return (double) stack.pop();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan postfix: ");
        String exp = input.nextLine();

        System.out.println("Hasil: " + calculate(exp));

        input.close();
    }
}
