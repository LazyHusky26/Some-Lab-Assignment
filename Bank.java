import java.util.Scanner;

public class Bank{
    private static Scanner s = new Scanner(System.in);
    private static BankAccount account = null;
    private static int month = 0;

    public static void main(String[] args) {
        createAccount();
        while(true) {
            menu();
        }
    }

    public static void menu() {
        System.out.println("\nMENU:");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Check Balance");
        if(account instanceof SavingsAccount){
            System.out.println("4. Apply Interest");
        }
        System.out.println("5. Next Month!");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
        int choice = s.nextInt();

        switch(choice) {
            case 1: 
                deposit();
                break;
            case 2: 
                withdraw();
                break;
            case 3: 
                checkBalance();
                break;
            case 4:
                if(account instanceof SavingsAccount) {
                    account.calculateInterest();
                }
                break;
            case 5:
                nextmonth();
                break;
            case 6:
                System.out.println("Exiting...");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid Choice!");
        }
    }

    public static void createAccount() {
        System.out.println("Welcome to the Banking System!");
        System.out.println("Select Account Type: ");
        System.out.println("1. Savings Account");
        System.out.println("2. Current Account");
        int choice = s.nextInt();

        if(choice == 1){
            System.out.print("Enter initial deposit (minimum $1000): ");
            double deposit = s.nextDouble();

            if(deposit >= 1000){
                account = new SavingsAccount(deposit);
                System.out.println("Sucessfully Created");
            }
            else{
                System.out.println("Insufficient initial deposit.");
                System.exit(0);
            }
        }

        else if(choice == 2){
            System.out.print("Enter initial deposit (minimum $500): ");
            double deposit = s.nextDouble();

            if(deposit >= 500){
                account = new CurrentAccount(deposit);
                System.out.println("Sucessfully Created");
            }
            else{
                System.out.println("Insufficient initial deposit.");
                System.exit(0);
            }
        }
        
        else {
            System.out.println("Invalid choice!");
        }
    }

    public static void deposit() {
        System.out.print("Enter deposit amount: ");
        double amount = s.nextDouble();
        account.deposit(amount);
    }

    public static void withdraw() {
        System.out.print("Enter withdrawal amount: ");
        double amount = s.nextDouble();
        account.withdraw(amount);
    }

    public static void checkBalance() {
        account.checkBalance();
    }

    public static void nextmonth() {
        month++;
        System.out.println("\nNext Month!");

        if(account instanceof SavingsAccount){
            ((SavingsAccount) account).resetWithdrawals();
        }
    }
}
