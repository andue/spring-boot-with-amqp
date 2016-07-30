package de.medianox.amqp;

import java.util.Date;

/**
 * Created by tom on 29.07.16.
 */
public class MyMessage {
    private String sender;
    private String text;
    private int count;

    private static int counter = 0;

    public MyMessage() {

    }



    public MyMessage(String sender, String text) {
        this.sender = sender;
        this.text = text;
        this.count = counter++;
    }

    public String getSender() {
        return sender;
    }

    public String getText() {
        return text;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "MyMessage{" +
                "sender='" + sender + '\'' +
                ", text='" + text + '\'' +
                ", count=" + count +
                '}';
    }
}
