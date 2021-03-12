public class TestBankAccounts {

    public static void main(String[] args) {

        // TODO Auto-generated method stub

        BasicAccount bacc0 = new BasicAccount(0);

        System.out.println(bacc0.toString());


        BasicAccount bacc1 = new BasicAccount(5000);

        System.out.println(bacc1.toString());


        CheckingAccount chacc1 = new CheckingAccount(500.0);

        System.out.println(chacc1.toString());


        SavingsAccount sacc1 = new SavingsAccount(1000.0, 1.0);

        System.out.println(sacc1.toString());

        System.out.println("after 1 month, after calculating interest:");

        sacc1.calculateInterest();

        System.out.println(sacc1.toString());

    }

}
