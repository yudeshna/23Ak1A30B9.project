import java.util.*;

public class TextEditor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<String> undo = new Stack<>();
        Stack<String> redo = new Stack<>();
        String text = "";

        while (true) {
            System.out.println("\n1. Write\n2. Undo\n3. Redo\n4. Display\n5. Exit");
            int ch = sc.nextInt(); sc.nextLine();

            switch (ch) {
                case 1:
                    System.out.print("Enter text: ");
                    String t = sc.nextLine();
                    undo.push(text);
                    text += t + " ";
                    redo.clear();
                    break;

                case 2:
                    if (!undo.isEmpty()) {
                        redo.push(text);
                        text = undo.pop();
                    }
                    break;

                case 3:
                    if (!redo.isEmpty()) {
                        undo.push(text);
                        text = redo.pop();
                    }
                    break;

                case 4:
                    System.out.println("Current Text: " + text);
                    break;

                case 5:
                    sc.close(); return;
            }
        }
    }
}
