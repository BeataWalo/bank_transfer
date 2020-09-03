package pl.waw.sgh.bank;

public class NoAccountException extends Exception {
    NoAccountException(int id) {
        super("The account with " + id + " does not exist.");
    }
}
