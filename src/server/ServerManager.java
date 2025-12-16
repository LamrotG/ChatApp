package server;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ServerManager {

    private static final Set<ClientHandler> clients =
            ConcurrentHashMap.newKeySet();

    public static void register(ClientHandler client) {
        clients.add(client);
        broadcast("SYSTEM", "A user joined the chat");
    }

    public static void remove(ClientHandler client) {
        clients.remove(client);
        broadcast("SYSTEM", "A user left the chat");
    }

    public static void broadcast(String sender, String message) {
        for (ClientHandler client : clients) {
            client.send(sender + ": " + message);
        }
    }
}
