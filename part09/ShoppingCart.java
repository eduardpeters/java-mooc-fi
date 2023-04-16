
import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {

    private Map<String, Item> contents;

    public ShoppingCart() {
        this.contents = new HashMap<>();
    }

    public void add(String product, int price) {

        Item item = this.contents.get(product);

        if (item != null) {
            item.increaseQuantity();
        } else {
            this.contents.put(product, new Item(product, 1, price));
        }

    }

    public int price() {
        int totalPrice = 0;

        for (Item item : contents.values()) {
            totalPrice += item.price();
        }

        return totalPrice;
    }

    public void print() {
        for (Item item : contents.values()) {
            System.out.println(item);
        }
    }
}
