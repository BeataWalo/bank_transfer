package pl.waw.sgh.bank;

public class NotEnoughMoneyException extends Exception {
    NotEnoughMoneyException(String s) {
        super(s);
    }

}
