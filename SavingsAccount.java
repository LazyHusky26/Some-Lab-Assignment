public class SavingsAccount extends BankAccount {
    private static double interest_rate = 0.04; 
    private int withdrawals = 0;

    public SavingsAccount(double initialBalance){
        super(initialBalance);
    }

    @Override
    public void calculateInterest(){
        if(withdrawals <= 3){
            double interest = getBalance() * interest_rate;
            setBalance(getBalance() + interest);
            System.out.println("Interest applied");
        }
        else{
            System.out.println("Withdrawal limit exceeded!");
        }
    }

    @Override
    public void withdraw(double amount){
        if(withdrawals < 3){
            super.withdraw(amount);
            withdrawals++;
        }
        else{
            System.out.println("Withdrawal limit exceeded for this month!");
        }
    }

    public void resetWithdrawals() {
        withdrawals = 0;
    }
}
