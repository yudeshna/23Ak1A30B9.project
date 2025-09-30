import java.util.*;

class Patient {
    String name;
    int age;
    String problem;
    int severity;
    Patient(String name, int age, String problem, int severity) {
        this.name = name;
        this.age = age;
        this.problem = problem;
        this.severity = severity;
    }
}

public class HospitalQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Patient> queue = new PriorityQueue<>(
            (p1, p2) -> p2.severity - p1.severity // higher severity first
        );
        System.out.print("Enter number of patients: ");
        int n = sc.nextInt();
        for(int i=0;i<n;i++) {
            System.out.println("\nPatient " + (i+1) + ":");
            System.out.print("Name: ");
            String name = sc.next();
            System.out.print("Age: ");
            int age = sc.nextInt();
            System.out.print("Problem: ");
            String problem = sc.next();
            System.out.print("Severity (1-5): ");
            int severity = sc.nextInt();
            queue.add(new Patient(name, age, problem, severity));
        }
        System.out.println("\nPatient Queue (Highest severity first):");
        for(Patient p : queue) {
            System.out.println(p.name + ", Age: " + p.age + ", Problem: " + p.problem + ", Severity: " + p.severity);
        }
        System.out.println();
        while(!queue.isEmpty()) {
            Patient p = queue.poll();
            System.out.println("Treating next patient: " + p.name + ", Age: " + p.age + ", Problem: " + p.problem + ", Severity: " + p.severity);
        }
        System.out.println("\nAll patients have been treated.");
    }
}
