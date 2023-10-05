package utils;

public class EventNotFoundException extends RuntimeException {
    public EventNotFoundException(int id) {
        super("Event with id " + id + " does not exist");
    }

    public EventNotFoundException() {
        super("Requested event does not exist");
    }
}
