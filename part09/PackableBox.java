
import java.util.ArrayList;

public class Box implements Packable {

    private ArrayList<Packable> contents;
    private double maxCapacity;

    public Box(double maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.contents = new ArrayList<>();
    }

    public double weight() {
        double weight = 0.0;

        for (Packable item : this.contents) {
            weight += item.weight();
        }

        return weight;
    }

    public void add(Packable item) {
        if (this.weight() + item.weight() > this.maxCapacity) {
            return;
        }

        this.contents.add(item);
    }

    @Override
    public String toString() {
        return "Box: " + this.contents.size() + " items, total weight " + this.weight() + " kg";
    }
}
