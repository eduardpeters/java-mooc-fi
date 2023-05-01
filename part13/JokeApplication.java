package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class JokeApplication extends Application {

    @Override
    public void start(Stage window) throws Exception {

        // 1. Create main layout
        BorderPane layout = new BorderPane();

        // 1.1. Create menu for main layout
        HBox menu = new HBox();
        menu.setPadding(new Insets(20, 20, 20, 20));
        menu.setSpacing(10);

        // 1.2. Create buttons for menu
        Button jokeButton = new Button("Joke");
        Button answerButton = new Button("Answer");
        Button explanationButton = new Button("Explanation");

        // 1.3. Add buttons to menu
        menu.getChildren().addAll(jokeButton, answerButton, explanationButton);

        layout.setTop(menu);

        // 2. Add subviews and add them to the menu buttons
        // 2.1. Create subview layout
        StackPane jokeLayout = createView("What do you call a bear with no teeth?");
        StackPane answerLayout = createView("A gummy bear.");
        StackPane explanationLayout = createView("You know... because candy is bad for your teeth");

        // 2.2. Add subviews to button. Pressing the buttons will change the view
        jokeButton.setOnAction((event) -> layout.setCenter(jokeLayout));
        answerButton.setOnAction((event) -> layout.setCenter(answerLayout));
        explanationButton.setOnAction((event) -> layout.setCenter(explanationLayout));

        // 2.3. Set initial view
        layout.setCenter(jokeLayout);

        // 3. Create main scene with layout 
        Scene scene = new Scene(layout);

        // 4. Show the main scene
        window.setScene(scene);
        window.show();
    }

    private StackPane createView(String text) {

        StackPane layout = new StackPane();
        layout.setPrefSize(300, 180);
        layout.getChildren().add(new Label(text));
        layout.setAlignment(Pos.CENTER);

        return layout;
    }

    public static void main(String[] args) {
        launch(JokeApplication.class);
    }
}
