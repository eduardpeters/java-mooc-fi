package textstatistics;

import java.util.Arrays;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TextStatisticsApplication extends Application {

    @Override
    public void start(Stage window) {
        BorderPane layout = new BorderPane();
        Label lettersCount = new Label("Letters: 0");
        Label wordsCount = new Label("Words: 0");
        Label longestWord = new Label("The longest word is: ");
        TextArea textArea = new TextArea();

        textArea.textProperty().addListener((change, oldValue, newValue) -> {
            int characters = newValue.length();
            String[] parts = newValue.split(" ");
            int words = parts.length;
            String longest = Arrays.stream(parts)
                    .sorted((s1, s2) -> s2.length() - s1.length())
                    .findFirst()
                    .get();

            lettersCount.setText("Letters: " + characters);
            wordsCount.setText("Words: " + words);
            longestWord.setText("The longest word is: " + longest);
        });

        HBox texts = new HBox();
        texts.setSpacing(20);
        texts.getChildren().addAll(lettersCount, wordsCount, longestWord);

        layout.setBottom(texts);
        layout.setCenter(textArea);

        Scene view = new Scene(layout);

        window.setScene(view);
        window.show();
    }

    public static void main(String[] args) {
        launch(TextStatisticsApplication.class);
    }

}
