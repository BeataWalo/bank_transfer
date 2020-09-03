package pl.waw.sgh.bank;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Bank {

    private List<Customer> customerList = new ArrayList<>();

    private List<Account> accountList = new ArrayList<>();

    public Customer newCustomer(String firstName, String lastName, String email) {
        Customer c = new Customer(firstName, lastName, email);
        customerList.add(c);
        return c;
    }

    public Account newAccount(boolean isDebitAccount, String currency, Customer customer) {
        Account a;
        if (isDebitAccount) {
            a = new DebitAccount(currency, customer);
        } else {
            a = new SavingsAccount(currency, customer);
        }
        accountList.add(a);
        return a;
    }

    public Account newDebitAccount(String currency, Customer customer) {
        return newAccount(true, currency, customer);
    }

    public Account newSavingsAccount(String currency, Customer customer) {
        return newAccount(false, currency, customer);
    }

   //homework
    public Account findAccountById(Integer accId) throws NoAccountException {
        for (Account a : accountList) {
            if (a.getId().equals(accId)) {
                return a;
            }
        } throw new NoAccountException(accId);
    }

    public void transfer(Integer fromAccountId, Integer toAccountId, Double amount) {
        try {
            Account from = findAccountById(fromAccountId);
            Account to = findAccountById(toAccountId);
            System.out.println("Before the transfer: " + findAccountById(fromAccountId) +
                    " " + findAccountById(toAccountId));
            from.charge(amount);
            to.deposit(amount);
            System.out.println("After the transfer: " + findAccountById(fromAccountId) +
                            " " + findAccountById(toAccountId));
        } catch (NoAccountException | NotEnoughMoneyException | NonpositiveDepositException e) {
            System.out.println("ERROR: " + e);
        }
    }

    @Override
    public String toString() {
        return "Bank{" +
                "\tcusts:\n" + customerList +
                "\n\taccounts:\n" + accountList +
                '}';
    }
}
