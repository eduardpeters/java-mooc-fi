
public class OneItemBox extends Box {

    private Item content;

    @Override
    public void add(Item item) {
        if (content == null) {
            this.content = item;
        }
    }

    @Override
    public boolean isInBox(Item item) {
        if (content == null) {
            return false;
        }
        return this.content.equals(item);
    }

}
