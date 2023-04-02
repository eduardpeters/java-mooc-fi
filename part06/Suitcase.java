
import java.util.ArrayList;

public class Suitcase {

    private ArrayList<Item> items;
    private int maxWeight;

    public Suitcase(int maxWeight) {
        this.maxWeight = maxWeight;
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        if (this.totalWeight() + item.getWeight() > maxWeight) {
            return;
        }

        this.items.add(item);
    }

    public int totalWeight() {
        int weight = 0;

        for (Item item : items) {
            weight += item.getWeight();
        }

        return weight;
    }

    public void printItems() {
        for (Item item : items) {
            System.out.println(item);
        }
    }

    public Item heaviestItem() {
        if (this.items.isEmpty()) {
            return null;
        }

        Item heaviest = this.items.get(0);

        for (Item item : items) {
            if (item.getWeight() > heaviest.getWeight()) {
                heaviest = item;
            }
        }

        return heaviest;
    }

    @Override
    public String toString() {
        String returnString;

        if (this.items.isEmpty()) {
            return "no items (0 kg)";
        }

        if (this.items.size() == 1) {
            returnString = "1 item ";
        } else {
            returnString = this.items.size() + " items ";
        }

        return returnString + "(" + this.totalWeight() + " kg)";
    }
}
