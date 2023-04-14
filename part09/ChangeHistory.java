
import java.util.ArrayList;

public class ChangeHistory {

    private ArrayList<Double> movements;

    public ChangeHistory() {
        this.movements = new ArrayList<>();
    }

    public void add(double status) {
        this.movements.add(status);
    }

    public void clear() {
        this.movements.clear();
    }

    public double maxValue() {
        double maxValue = 0.0;

        for (double movement : this.movements) {
            if (movement > maxValue) {
                maxValue = movement;
            }
        }

        return maxValue;
    }

    public double minValue() {

        if (this.movements.isEmpty()) {
            return 0.0;
        }

        double minValue = this.movements.get(0);

        for (int index = 1; index < this.movements.size(); index++) {
            if (this.movements.get(index) < minValue) {
                minValue = this.movements.get(index);
            }
        }

        return minValue;
    }

    public double average() {
        if (this.movements.isEmpty()) {
            return 0.0;
        }

        double sum = 0;

        for (double movement : this.movements) {
            sum += movement;
        }

        return sum / this.movements.size();
    }

    @Override
    public String toString() {
        return this.movements.toString();
    }
}
