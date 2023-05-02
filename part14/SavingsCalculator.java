package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SavingsCalculatorApplication extends Application {

    @Override
    public void start(Stage stage) {
        BorderPane mainLayout = new BorderPane();
        mainLayout.setPadding(new Insets(20, 20, 20, 20));

        // Amount slider setup
        BorderPane amountLayout = new BorderPane();
        amountLayout.setLeft(new Label("Monthly savings"));
        Slider amountSlider = new Slider(25, 250, 25);
        amountSlider.setShowTickLabels(true);
        amountSlider.setShowTickMarks(true);
        amountSlider.setSnapToTicks(true);
        Label amountSliderValue = new Label("25");
        amountLayout.setCenter(amountSlider);
        amountLayout.setRight(amountSliderValue);
        // Interest slider setup
        BorderPane interestLayout = new BorderPane();
        interestLayout.setLeft(new Label("Yearly interest rate"));
        Slider interestSlider = new Slider(0, 10, 0);
        interestSlider.setShowTickLabels(true);
        interestSlider.setShowTickMarks(true);
        interestSlider.setMajorTickUnit(1);
        amountSlider.setSnapToTicks(true);
        Label interestSliderValue = new Label("0");
        interestLayout.setCenter(interestSlider);
        interestLayout.setRight(interestSliderValue);

        VBox topLayout = new VBox();
        topLayout.setSpacing(20);
        topLayout.getChildren().addAll(amountLayout, interestLayout);

        // LineChart setup
        NumberAxis xAxis = new NumberAxis(0, 30, 4);
        NumberAxis yAxis = new NumberAxis();
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Savings Calculator");
        lineChart.setAnimated(false);
        lineChart.setLegendVisible(false);

        mainLayout.setTop(topLayout);
        mainLayout.setCenter(lineChart);

        XYChart.Series savedAmount = new XYChart.Series();
        XYChart.Series savingsWithInterest = new XYChart.Series();
        lineChart.getData().add(savedAmount);
        lineChart.getData().add(savingsWithInterest);

        // Event handlers for sliders
        amountSlider.setOnMouseReleased((event) -> {
            amountSliderValue.setText("" + amountSlider.getValue());
            updateSeries(amountSlider.getValue(), interestSlider.getValue(), savedAmount, savingsWithInterest);
        });

        interestSlider.setOnMouseReleased((event) -> {
            String newInterestValue = "" + interestSlider.getValue();
            if (newInterestValue.length() > 4) {
                newInterestValue = newInterestValue.substring(0, 4);
            }
            interestSliderValue.setText(newInterestValue);
            updateSeries(amountSlider.getValue(), interestSlider.getValue(), savedAmount, savingsWithInterest);
        });

        Scene view = new Scene(mainLayout);
        stage.setScene(view);
        stage.show();
    }

    // Method to update both series
    private void updateSeries(double amount, double interest, XYChart.Series savedAmount, XYChart.Series savingsWithInterest) {
        savedAmount.getData().clear();
        savingsWithInterest.getData().clear();

        savedAmount.getData().add(new XYChart.Data(0, 0));
        savingsWithInterest.getData().add(new XYChart.Data(0, 0));

        double previousBalance = 0;
        for (int i = 1; i <= 30; i++) {
            savedAmount.getData().add(new XYChart.Data(i, i * amount * 12));
            previousBalance += amount * 12;
            previousBalance *= (1.0 + interest / 100.0);
            savingsWithInterest.getData().add(new XYChart.Data(i, previousBalance));
        }
    }

    public static void main(String[] args) {
        launch(SavingsCalculatorApplication.class);
    }

}
