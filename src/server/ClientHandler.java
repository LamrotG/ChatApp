package server;

import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable {

    private final Socket socket;
    private PrintWriter out;
    private BufferedReader in;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            setupStreams();
            ServerManager.register(this);

            String message;
            while ((message = in.readLine()) != null) {
                ServerManager.broadcast("Client", message);
            }

        } catch (IOException e) {
            // client disconnected
        } finally {
            cleanup();
        }
    }

    private void setupStreams() throws IOException {
        out = new PrintWriter(socket.getOutputStream(), true);
        in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
    }

    public void send(String message) {
        out.println(message);
    }

    private void cleanup() {
        try {
            ServerManager.remove(this);
            socket.close();
        } catch (IOException ignored) {}
    }
}

