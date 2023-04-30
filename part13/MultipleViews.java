package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MultipleViews extends Application {

    @Override
    public void start(Stage window) {
        // Set up first view
        BorderPane borderLayout = new BorderPane();
        borderLayout.setTop(new Label("First view!"));
        Button goToSecond = new Button("To the second view!");

        borderLayout.setCenter(goToSecond);

        Scene firstView = new Scene(borderLayout);

        // Set up second view
        VBox verticalLayout = new VBox();
        Button goToThird = new Button("To the third view!");

        verticalLayout.getChildren().addAll(goToThird, new Label("Second view!"));

        Scene secondView = new Scene(verticalLayout);

        // Set up third view
        GridPane gridLayout = new GridPane();
        Button goToFirst = new Button("To the first view!");

        gridLayout.add(new Label("Third view!"), 0, 0);
        gridLayout.add(goToFirst, 1, 1);

        Scene thirdView = new Scene(gridLayout);

        // Set up event handlers
        goToSecond.setOnAction((event) -> {
            window.setScene(secondView);
        });

        goToThird.setOnAction((event) -> {
            window.setScene(thirdView);
        });

        goToFirst.setOnAction((event) -> {
            window.setScene(firstView);
        });
        // Set up application starting view
        window.setScene(firstView);
        window.show();
    }

    public static void main(String[] args) {
        launch(MultipleViews.class);
    }

}
