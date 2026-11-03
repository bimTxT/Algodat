import java.util.Scanner;

public class CheckingParenthesis {

    static boolean checkParenthesis(String exp) {
        Stack stack = new Stack();

        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);

            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    return false;
                }

                char buka = (char) stack.pop();

                if (c == ')' && buka != '(') {
                    return false;
                }
                if (c == '}' && buka != '{') {
                    return false;
                }
                if (c == ']' && buka != '[') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan expression: ");
        String exp = input.nextLine();

        if (checkParenthesis(exp)) {
            System.out.println("Parenthesis is MATCHED");
        } else {
            System.out.println("Parenthesis is NOT MATCHED");
        }

        input.close();
    }
}
