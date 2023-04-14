
import java.util.ArrayList;

public class BoxWithMaxWeight extends Box {

    private int capacity;
    private ArrayList<Item> contents;

    public BoxWithMaxWeight(int capacity) {
        this.capacity = capacity;
        this.contents = new ArrayList<>();
    }

    public int getWeight() {
        int weight = 0;

        for (Item item : this.contents) {
            weight += item.getWeight();
        }

        return weight;
    }

    @Override
    public void add(Item item) {

        if (this.getWeight() + item.getWeight() > this.capacity) {
            return;
        }

        this.contents.add(item);
    }

    @Override
    public boolean isInBox(Item item) {
        return this.contents.contains(item);
    }
}
