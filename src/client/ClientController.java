package client;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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

        Scene scene = new Scene(root, 300, 200);
        scene.getStylesheets().add(
                getClass().getResource("/style.css").toExternalForm()
        );

        stage.setScene(scene);
        stage.setTitle("Chat Client");
        stage.show();

        connection.connect();
    }
}
