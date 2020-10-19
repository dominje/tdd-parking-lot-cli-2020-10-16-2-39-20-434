package exception;

public class NoParkingTicketException extends RuntimeException {
    public NoParkingTicketException(String message) {
        super(message);
    }
}
