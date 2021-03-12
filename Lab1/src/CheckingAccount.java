public class CheckingAccount extends BasicAccount {

    private int transactionCount;

    private static final int FREE_TRANSACTIONS = 3;

    private static final double TRANSACTION_FEE = 2.0;


    public CheckingAccount(double initialAmount) {

        super(initialAmount);

        transactionCount = 0;

    }


    public int getTransactionCount() {

        return transactionCount;

    }

    public void deposit(double amount) {

        transactionCount += 1;

        super.deposit(amount);

    }


    public void withdraw(double amount) {

        transactionCount += 1;

        super.withdraw(amount);

    }


    public void deductFees() {

        if (transactionCount > FREE_TRANSACTIONS) {

            double fees = (transactionCount - FREE_TRANSACTIONS) * TRANSACTION_FEE;

            super.withdraw(fees);

        }

        transactionCount = 0;

    }


    public String toString() {

        return "CheckingAccount: Balance $ " + getBalance() + ", transactions " + transactionCount;

    }

}
