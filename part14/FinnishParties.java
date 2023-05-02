package application;

import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class PartiesApplication extends Application {

    private HashMap<String, HashMap<Integer, Double>> dataSet;

    public PartiesApplication() {
        HashMap<String, HashMap<Integer, Double>> dataSet = new HashMap<>();
        try ( Scanner fileScanner = new Scanner(Paths.get("partiesdata.tsv"))) {
            String headersLine = fileScanner.nextLine();
            String[] headers = headersLine.split("\t");
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] lineContents = line.split("\t");
                String party = lineContents[0];
                HashMap<Integer, Double> partyData = new HashMap<>();
                for (int i = 1; i < lineContents.length; i++) {
                    double percentage;
                    try {
                        percentage = Double.valueOf(lineContents[i]);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        continue;
                    }
                    partyData.put(Integer.valueOf(headers[i]), percentage);
                }
                dataSet.put(party, partyData);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        this.dataSet = dataSet;
    }

    @Override
    public void start(Stage stage) {
        NumberAxis xAxis = new NumberAxis(1968, 2008, 4);
        NumberAxis yAxis = new NumberAxis(0, 30, 4);

        xAxis.setLabel("Year");
        yAxis.setLabel("Relative support (%)");

        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Relative support in the years 1968-2008");

        for (String key : this.dataSet.keySet()) {
            XYChart.Series data = new XYChart.Series();
            data.setName(key);
            HashMap<Integer, Double> partyData = this.dataSet.get(key);
            for (int year : partyData.keySet()) {
                data.getData().add(new XYChart.Data(year, partyData.get(year)));
            }
            lineChart.getData().add(data);
        }

        Scene view = new Scene(lineChart, 640, 480);
        stage.setScene(view);
        stage.show();
    }

    public static void main(String[] args) {
        launch(PartiesApplication.class);
    }

}
