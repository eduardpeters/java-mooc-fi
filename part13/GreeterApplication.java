package application;

import javafx.geometry.Insets;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GreeterApplication extends Application {

    @Override
    public void start(Stage window) {
        // Create first view with name input
        Label instructionText = new Label("Enter your name and start");
        TextField nameField = new TextField();
        Button startButton = new Button("Start");

        GridPane layout = new GridPane();
        layout.add(instructionText, 0, 0);
        layout.add(nameField, 0, 1);
        layout.add(startButton, 0, 2);

        layout.setPrefSize(300, 180);
        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setPadding(new Insets(20, 20, 20, 20));

        Scene startView = new Scene(layout);

        // Create second view
        Label greetingText = new Label("Welcome");

        StackPane greetingLayout = new StackPane();
        greetingLayout.setPrefSize(300, 180);
        greetingLayout.getChildren().add(greetingText);
        greetingLayout.setAlignment(Pos.CENTER);

        Scene greetingView = new Scene(greetingLayout);

        startButton.setOnAction((event) -> {
            if (nameField.getLength() > 0) {
                greetingText.setText("Welcome " + nameField.getText().trim() + "!");
                window.setScene(greetingView);
            }
        });

        window.setScene(startView);
        window.show();

    }

    public static void main(String[] args) {
        launch(GreeterApplication.class);
    }
}
