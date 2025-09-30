import java.util.*;

class Account {
    String name;
    int accNo;
    double balance;

    Account(String name, int accNo) {
        this.name = name;
        this.accNo = accNo;
        this.balance = 0;
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Account> accounts = new HashMap<>();

        while (true) {
            System.out.println("\n1. Create\n2. Deposit\n3. Withdraw\n4. Balance\n5. Exit");
            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1:
                    System.out.print("Enter Acc No: ");
                    int no = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    accounts.put(no, new Account(name, no));
                    System.out.println("Account Created!");
                    break;

                case 2:
                    System.out.print("Enter Acc No: ");
                    int dn = sc.nextInt();
                    System.out.print("Enter Amount: ");
                    double amt = sc.nextDouble();
                    accounts.get(dn).balance += amt;
                    System.out.println("Deposited!");
                    break;

                case 3:
                    System.out.print("Enter Acc No: ");
                    int wn = sc.nextInt();
                    System.out.print("Enter Amount: ");
                    double wam = sc.nextDouble();
                    if (accounts.get(wn).balance >= wam) {
                        accounts.get(wn).balance -= wam;
                        System.out.println("Withdrawn!");
                    } else {
                        System.out.println("Insufficient Balance!");
                    }
                    break;

                case 4:
                    System.out.print("Enter Acc No: ");
                    int bn = sc.nextInt();
                    System.out.println("Balance: " + accounts.get(bn).balance);
                    break;

                case 5:
                    sc.close(); return;
            }
        }
    }
}
