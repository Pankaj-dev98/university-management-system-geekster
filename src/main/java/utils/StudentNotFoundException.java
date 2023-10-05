package utils;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException() {
        super("Requested student does not exist");
    }

    public StudentNotFoundException(int id) {
        super("Student with id " + id + " does not exist");
    }
}
