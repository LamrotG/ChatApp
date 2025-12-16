package client;

public interface ClientConnection {
    void connect();
    void sendMessage(String message);
    void disconnect();
    boolean isConnected();
}
