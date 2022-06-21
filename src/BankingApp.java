import java.util.Scanner;

public class BankingApp {
    public static void main(String[] args) {
        BankAccount obj = new BankAccount("MJ", "007");
        obj.showMenu();

    }

    static class BankAccount {
        int balance;
        int prevTrans;
        String customerName;
        String customerId;

        BankAccount(String cname, String cid) {
            customerName = cname;
            customerId = cid;
        }
        //money you put into atm
        void deposit(int amount) {
            if (amount != 0) {
                balance += amount;
                prevTrans = amount;
            }
        }
        //money you take from atm
        void withdraw(int amount) {
            if (amount != 0) {
                balance -= amount;
                prevTrans = -amount;
            }
        }
        //info about previous transaction
        void getPrevTrans() {
            if (prevTrans > 0)
                System.out.println("Deposited " + prevTrans);
            else if (prevTrans < 0)
                System.out.println("Withdrawn " + Math.abs(prevTrans));
            else
                System.out.println("No transaction occurred");
        }
        //menu
        void showMenu() {
            char option = '\0';
            Scanner scanner = new Scanner(System.in);
            System.out.println("Welcome " + customerName);
            System.out.println("Your ID is " + customerId);
            System.out.println("A. Check balance");
            System.out.println("B. Deposit");
            System.out.println("C. Withdraw");
            System.out.println("D. Previous Transaction");
            System.out.println("E. Exit");
            do {
                //System.out.println("===============");
                System.out.println("Enter an option");
                //System.out.println("===============");
                option = scanner.next().charAt(0);

                switch(option) {
                    case 'A':
                        //System.out.println("--------------------");
                        System.out.println("Balance = " + balance);
                        //System.out.println("--------------------");
                        break;
                    case 'B':
                        //System.out.println("--------------------");
                        System.out.println("Enter an amount to deposit: ");
                        //System.out.println("--------------------");
                        int amount = scanner.nextInt();
                        deposit(amount);
                        break;
                    case 'C':
                        //System.out.println("--------------------");
                        System.out.println("Enter an amount to withdraw: ");
                        //System.out.println("--------------------");
                        int amount2 = scanner.nextInt();
                        withdraw(amount2);
                        break;
                    case 'D':
                        //System.out.println("--------------------");
                        getPrevTrans();
                        break;
                    case 'E':
                        System.out.println("******");
                        break;
                    default:
                        System.out.println("Invalid option. Please enter again");
                        break;

                }
            } while (option != 'E');
            System.out.println("Thank you for using our services");
        }
    }
}
