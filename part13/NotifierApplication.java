package notifier;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NotifierApplication extends Application {

    @Override
    public void start(Stage window) {
        Button buttonComponent = new Button("Update");
        TextField textFieldComponent = new TextField();
        Label textComponent = new Label();

        buttonComponent.setOnAction((event) -> {
            textComponent.setText(textFieldComponent.getText());
        });

        VBox componentGroup = new VBox();
        componentGroup.getChildren().addAll(textFieldComponent, buttonComponent, textComponent);

        Scene view = new Scene(componentGroup);

        window.setScene(view);
        window.show();
    }

    public static void main(String[] args) {
        launch(NotifierApplication.class);
    }

}
