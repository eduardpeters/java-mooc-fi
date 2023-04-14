
import java.util.ArrayList;

public class MisplacingBox extends Box {

    private ArrayList<Item> contents;

    public MisplacingBox() {
        this.contents = new ArrayList<>();
    }

    @Override
    public void add(Item item) {
        this.contents.add(item);
    }

    @Override
    public boolean isInBox(Item item) {
        return false;
    }
}
