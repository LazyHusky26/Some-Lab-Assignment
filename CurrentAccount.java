public class CurrentAccount extends BankAccount {
    private static double penalty = 50;
    private static double min_bal = 500;

    public CurrentAccount(double initialBalance) {
        super(initialBalance);
    }

    @Override
    public void calculateInterest() {
    }

    @Override
    public void withdraw(double amount) {
        super.withdraw(amount);
        if(getBalance() < min_bal) {
            setBalance(getBalance() - penalty);
            System.out.println("Balance under $500. Penalty applied");
        }
    }
}
