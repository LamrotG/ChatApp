package client;

import java.io.BufferedReader;

public class MessageReceiver implements Runnable {

    private final BufferedReader in;

    public MessageReceiver(BufferedReader in) {
        this.in = in;
    }

    @Override
    public void run() {
        try {
            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Server: " + message);
            }
        } catch (Exception e) {
            System.out.println("Disconnected from server.");
        }
    }
}
