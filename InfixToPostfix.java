import java.util.Scanner;

public class InfixToPostfix {

    static int priority(char op) {
        if (op == '+' || op == '-') {
            return 1;
        } else if (op == '*' || op == '/') {
            return 2;
        } else if (op == '^') {
            return 3;
        }

        return 0;
    }

    static String convert(String exp) {
        Stack stack = new Stack();
        String postfix = "";

        exp = exp.replace(" ", "");

        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);

            if (Character.isDigit(c)) {
                postfix += c;
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && (char) stack.top() != '(') {
                    postfix += stack.pop();
                }

                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                while (!stack.isEmpty() && (char) stack.top() != '(' &&
                       (priority((char) stack.top()) > priority(c) ||
                       (priority((char) stack.top()) == priority(c) && c != '^'))) {
                    postfix += stack.pop();
                }

                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            postfix += stack.pop();
        }

        return postfix;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan infix: ");
        String exp = input.nextLine();

        System.out.println("Postfix: " + convert(exp));

        input.close();
    }
}
