package exceptions;

public class TransferCannotBeNegativeException {
    private double transfer;
    public TransferCannotBeNegativeException(String message, double transfer) {
        //super(message);
        this.transfer = transfer;
    }
}
