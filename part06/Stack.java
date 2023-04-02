
import java.util.ArrayList;

public class Stack {

    private ArrayList<String> content;

    public Stack() {
        this.content = new ArrayList<>();
    }

    public boolean isEmpty() {
        return this.content.isEmpty();
    }

    public void add(String value) {
        this.content.add(value);
    }

    public ArrayList<String> values() {
        return this.content;
    }

    public String take() {
        int lastIndex = this.content.size() - 1;
        return this.content.remove(lastIndex);
    }
}
