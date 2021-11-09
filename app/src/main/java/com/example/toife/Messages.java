package com.example.toife;

public class Messages {
    String Message;
    String Sendrid;
    long timeStamp;

    public Messages() {
    }

    public Messages(String message, String sendrid, long timeStamp) {
        this.Message = message;
        this.Sendrid = sendrid;
        this.timeStamp = timeStamp;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public String getSendrid() {
        return Sendrid;
    }

    public void setSendrid(String sendrid) {
        Sendrid = sendrid;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
