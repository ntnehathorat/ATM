import java.util.Scanner;

class ATM {
    private static final String USER_ID = "34512"; // predefined user id
    private static final String USER_PIN = "0921"; // predefined user pin
    private double balance; // current balance

    public static void main(String[] args) {
        ATM atm = new ATM();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the ATM");

        // prompt user for id and pin
        System.out.print("Enter user id: ");
        String userId = scanner.nextLine();

        System.out.print("Enter user pin: ");
        String userPin = scanner.nextLine();

        if (!userId.equals(USER_ID) || !userPin.equals(USER_PIN)) {
            System.out.println("Invalid user id or pin. Exiting...");
            return;
        }

        // user authenticated, show menu
        while (true) {
            System.out.println("\nATM Menu:");
            System.out.println("1. View Transactions History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.print("Enter option: ");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    atm.viewTransactionHistory();
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    atm.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(depositAmount);
                    break;
                case 4:
                    System.out.print("Enter amount to transfer: ");
                    double transferAmount = scanner.nextDouble();
                    System.out.print("Enter recipient's account number: ");
                    String recipient = scanner.next();
                    atm.transfer(transferAmount, recipient);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
                    break;
            }
        }
    }

    public void viewTransactionHistory() {
        System.out.println("Transaction History:");
        // implementation of transaction history
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("$" + amount + " withdrawn successfully.");
            System.out.println("New balance: $" + balance);
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("$" + amount + " deposited successfully.");
        System.out.println("New balance: $" + balance);
    }

    public void transfer(double amount, String recipient) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("$" + amount + " transferred to account " + recipient + " successfully.");
            System.out.println("New balance: $" + balance);
        } else {
            System.out.println("Insufficient funds.");
        }
    }
}