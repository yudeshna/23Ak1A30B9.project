import java.util.*;

// Student class for record system
class RecordStudent {
    String name;
    int roll, marks;

    RecordStudent(String name, int roll, int marks) {
        this.name = name;
        this.roll = roll;
        this.marks = marks;
    }
}

public class StudentRecordSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<RecordStudent> list = new ArrayList<>();

        while (true) {
            System.out.println("\n1. Add Student\n2. Display\n3. Search\n4. Delete\n5. Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Roll: ");
                    int roll = sc.nextInt();
                    System.out.print("Enter Marks: ");
                    int marks = sc.nextInt();
                    list.add(new RecordStudent(name, roll, marks));
                    System.out.println("Student Added!");
                    break;

                case 2:
                    if (list.isEmpty()) {
                        System.out.println("No records found.");
                    } else {
                        for (RecordStudent s : list) {
                            System.out.println(s.roll + " - " + s.name + " - " + s.marks);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Roll to Search: ");
                    int sr = sc.nextInt();
                    boolean found = false;
                    for (RecordStudent s : list) {
                        if (s.roll == sr) {
                            System.out.println("Found: " + s.name + " - Marks: " + s.marks);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Student not found!");
                    }
                    break;

                case 4:
                    System.out.print("Enter Roll to Delete: ");
                    int dr = sc.nextInt();
                    boolean removed = list.removeIf(s -> s.roll == dr);
                    if (removed)
                        System.out.println("Student deleted!");
                    else
                        System.out.println("Student not found!");
                    break;

                case 5:
                    sc.close();
                    System.out.println("Exiting program...");
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
