package account;

public class BalanceCannotBeNegativeException extends IllegalAccessException {
    private double balanceAmount;
    public BalanceCannotBeNegativeException(String message, double balance) {
        super(message);
        this.balanceAmount = balance;
    }

}
