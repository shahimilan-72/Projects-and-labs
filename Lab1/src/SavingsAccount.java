public class SavingsAccount extends BasicAccount {

    private double interestRate;

    public SavingsAccount(double InitialAmount, double rate) {

        super(InitialAmount);

        interestRate = rate;

    }


    public double getInterestRate() {

        return interestRate;

    }

    public void calculateInterest() {

        double interest = (getBalance() * interestRate) / 100;

        super.deposit(interest);

    }

    public String toString() {

        return "SavingsAccount : Balance $" + getBalance() + ", interest rate " + interestRate;

    }

}
