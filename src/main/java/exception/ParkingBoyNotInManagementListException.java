package exception;

public class ParkingBoyNotInManagementListException extends RuntimeException{
    public ParkingBoyNotInManagementListException(String message) {
        super(message);
    }
}
