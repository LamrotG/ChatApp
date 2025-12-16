package client;

import javafx.application.Application;
import javafx.stage.Stage;

public class ClientMain extends Application {

    @Override
    public void start(Stage stage) {
        ClientController controller = new ClientController();
        controller.launch(stage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
