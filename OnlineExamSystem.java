import java.util.*;

// Class for storing student details
class Student {
    String name;
    int roll;
    int score;

    Student(String name, int roll, int score) {
        this.name = name;
        this.roll = roll;
        this.score = score;
    }
}

// Node for BST Leaderboard
class Node {
    Student student;
    Node left, right;

    Node(Student student) {
        this.student = student;
        left = right = null;
    }
}

// Leaderboard using BST (sorted by marks)
class Leaderboard {
    Node root;

    // Insert student into BST
    void insert(Student student) {
        root = insertRec(root, student);
    }

    Node insertRec(Node root, Student student) {
        if (root == null) {
            return new Node(student);
        }
        // Higher scores on left
        if (student.score > root.student.score)
            root.left = insertRec(root.left, student);
        else
            root.right = insertRec(root.right, student);
        return root;
    }

    // Inorder traversal to display leaderboard
    void display(Node root) {
        if (root != null) {
            display(root.left);
            System.out.println(root.student.roll + " - " + root.student.name + " - " + root.student.score);
            display(root.right);
        }
    }
}

// Main Exam System
public class OnlineExamSystem {  // Make sure your file name is OnlineExamSystem.java
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Questions in HashMap
        HashMap<String, String> questions = new HashMap<>();
        questions.put("2 + 2 = ? \n a) 3 \n b) 4 \n c) 5 \n d) 6", "b");
        questions.put("Capital of India? \n a) Mumbai \n b) Delhi \n c) Kolkata \n d) Chennai", "b");

        // Input number of students
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        Leaderboard lb = new Leaderboard();

        for (int i = 0; i < n; i++) {
            System.out.print("\nEnter Student Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Roll Number: ");
            int roll = sc.nextInt();
            sc.nextLine();

            int score = 0;
            for (String q : questions.keySet()) {
                System.out.println("\n" + q);
                System.out.print("Your answer: ");
                String ans = sc.nextLine();
                if (ans.equalsIgnoreCase(questions.get(q))) {
                    score++;
                }
            }

            System.out.println(name + " scored: " + score);
            lb.insert(new Student(name, roll, score));
        }

        // Display leaderboard
        System.out.println("\n===== Leaderboard =====");
        lb.display(lb.root);

        sc.close();
    }
}
