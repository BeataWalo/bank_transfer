package pl.waw.sgh.bank;

public class NonpositiveDepositException extends Exception {
    NonpositiveDepositException(String s) {
        super(s);
    }
}
