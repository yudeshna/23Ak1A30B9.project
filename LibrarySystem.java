import java.util.*;

public class LibrarySystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<String> borrowQueue = new LinkedList<>();
        Stack<String> history = new Stack<>();

        while (true) {
            System.out.println("\n1. Borrow\n2. Return\n3. Show Queue\n4. Undo\n5. Exit");
            int ch = sc.nextInt(); sc.nextLine();

            switch (ch) {
                case 1:
                    System.out.print("Enter Book: ");
                    String book = sc.nextLine();
                    borrowQueue.add(book);
                    history.push("Borrowed " + book);
                    System.out.println("Borrowed: " + book);
                    break;

                case 2:
                    if (!borrowQueue.isEmpty()) {
                        String b = borrowQueue.poll();
                        history.push("Returned " + b);
                        System.out.println("Returned: " + b);
                    }
                    break;

                case 3:
                    System.out.println("Borrow Queue: " + borrowQueue);
                    break;

                case 4:
                    if (!history.isEmpty())
                        System.out.println("Undo -> " + history.pop());
                    else
                        System.out.println("Nothing to undo!");
                    break;

                case 5:
                    sc.close(); return;
            }
        }
    }
}
