package utils;

import java.time.LocalDateTime;

public class ErrorResponse {
    private LocalDateTime timeStamp;
    private int status;
    private String message;

    public ErrorResponse(LocalDateTime timeStamp, int status, String message) {
        this.timeStamp = timeStamp;
        this.status = status;
        this.message = message;
    }

    public ErrorResponse() {}

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
