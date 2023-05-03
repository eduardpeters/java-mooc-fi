package smiley;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SmileyApplication extends Application {

    @Override
    public void start(Stage window) {

        Canvas paintingCanvas = new Canvas(400, 400);
        GraphicsContext painter = paintingCanvas.getGraphicsContext2D();

        BorderPane paintingLayout = new BorderPane();
        paintingLayout.setCenter(paintingCanvas);

        // Clear background
        painter.setFill(Color.LIGHTSTEELBLUE);
        painter.fillRect(0, 0, 400, 400);
        
        painter.setFill(Color.CORAL);

        //Eyes
        painter.fillRect(100, 50, 50, 50);
        painter.fillRect(250, 50, 50, 50);

        //Smile ends
        painter.fillRect(50, 200, 50, 50);
        painter.fillRect(300, 200, 50, 50);

        //Smile bottom
        painter.fillRect(100, 250, 200, 50);

        Scene view = new Scene(paintingLayout);

        window.setScene(view);
        window.show();
    }

    public static void main(String[] args) {
        launch(SmileyApplication.class);
    }

}
