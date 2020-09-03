package pl.waw.sgh.bank;

import java.math.BigDecimal;

public abstract class Account {

    private static Integer lastAccountId = 0;

    private Integer id;

    private BigDecimal balance;

    private String currency = "EUR";

    private Customer customer;

    public Account(String currency, Customer customer) {
        this.balance = new BigDecimal(0);
        this.currency = currency;
        this.customer = customer;
        this.id = lastAccountId++;
    }

    //homework
    public void deposit(Double amount) throws NonpositiveDepositException {
        deposit(BigDecimal.valueOf(amount));
    }

    public void deposit(BigDecimal amount) throws NonpositiveDepositException {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new NonpositiveDepositException("Deposit has to be positive");
        } else {
            this.balance = balance.add(amount);
        }
    }

    public void charge(Double amount) throws NotEnoughMoneyException {
        charge(BigDecimal.valueOf(amount));
    }

    public void charge(BigDecimal amount) throws NotEnoughMoneyException {
        if (balance.compareTo(amount) >= 0) {
            this.balance = balance.subtract(amount);
        } else {
            throw new NotEnoughMoneyException("Not enough money");
        }
    }

    public static Integer getLastAccountId() {
        return lastAccountId;
    }

    public Integer getId() {
        return id;
    }

    public BigDecimal getBalance() {
        //BigDecimal b = balance.add(new BigDecimal(35));
        return balance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName().replace("Account", "") + "{" +
                "id=" + id +
                ", " + balance + " " + currency + '\'' +
                ", cust=" + customer.getId() + " " + customer.getLastName() +
                "}\n";
    }
}
