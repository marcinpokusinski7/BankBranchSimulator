package exceptions;

public class TransferCannotBeNegativeException extends Throwable {
    private double transfer;
    public TransferCannotBeNegativeException(String message, double transfer) {
        super(message);
        this.transfer = transfer;
    }
}
