package pl.waw.sgh.bank;

public class PlayWithBank {

    public static void main(String[] args) {
        try {
            Bank myBank = new Bank();
            Customer c1 = myBank.newCustomer("Pawel", "Rubach", "pawel.rubach@sgh.waw.pl");
            Customer c2 = myBank.newCustomer("Anna", "Smith", "anna.smith@sgh.waw.pl");

            Account a1 = myBank.newDebitAccount("EUR", c1);
            a1.deposit(150d);
//        System.out.println("a1 id: " + a1.getId());

//        a1.charge(40d);
            Account a2 = myBank.newSavingsAccount("PLN", c2);
            a2.deposit(200d);

            Account a3 = myBank.newDebitAccount("PLN", c1);
            a3.deposit(130d);
            Account a4 = myBank.newSavingsAccount("EUR", c2);
            a4.deposit(180d);

            System.out.println(myBank);
//        Spr findAccountById
            System.out.print("Account with id 1: ");
            System.out.println(myBank.findAccountById(1));
            System.out.print("Account with id 4: ");
            System.out.println(myBank.findAccountById(4));


            //Spr transferów
            System.out.println("First transfer: ");
            myBank.transfer(0, 2, 50d);

            System.out.println("Second transfer: ");
            myBank.transfer(0, 2, 120d);

            System.out.println("Third transfer: ");
            myBank.transfer(4, 1, 20d);

            System.out.println("Fourth transfer: ");
            myBank.transfer(1, 5, 20d);
        } catch (NoAccountException | NonpositiveDepositException e) {
            System.out.println(e);
        }
    }
}
