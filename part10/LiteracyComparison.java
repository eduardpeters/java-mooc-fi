
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LiteracyComparison {

    public static void main(String[] args) {

        try {
            Files.lines(Paths.get("literacy.csv"))
                    .map(line -> {
                        String[] parts = line.split(",");
                        return new LiteracyData(parts[3], Integer.valueOf(parts[4]), parts[2], Double.valueOf(parts[5]));
                    })
                    .sorted((data1, data2) -> {
                        if (data1.getPercentage() < data2.getPercentage()) {
                            return -1;
                        } else if (data1.getPercentage() > data2.getPercentage()) {
                            return 1;
                        }
                        return 0;
                    })
                    .forEach(data -> System.out.println(data));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
