public abstract class BankAccount{
    private double balance;

    public BankAccount(double initialBalance){
        this.balance = initialBalance;
    }

    public void deposit(double amount){
        if(amount > 0){
            balance += amount;
            System.out.println("Deposit Successful");
        }
        else {
            System.out.println("Invalid Deposit Amount");
        }
    }

    public void withdraw(double amount) {
        if(amount <= 0){
            System.out.println("Invalid Withdrawal Amount");
            return;
        }

        if(balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawal successful");
        }
        else {
            System.out.println("Insufficient balance for withdrawal.");
        }
    }

    public void checkBalance() {
        System.out.println("Current Balance: $" + balance);
    }

    public abstract void calculateInterest();

    public double getBalance() {
        return balance;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }
}
