package client;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ClientController {

    private final ClientConnection connection = new ClientConnectionImpl();

    public void launch(Stage stage) {

        TextField input = new TextField();
        Button send = new Button("Send");

        send.setOnAction(e -> {
            connection.sendMessage(input.getText());
            input.clear();
        });

        VBox root = new VBox(10, input, send);

        stage.setScene(new Scene(root, 300, 200));
        stage.setTitle("Chat Client");
        stage.show();

        connection.connect();
    }
}
