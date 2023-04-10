
public class Container {

    private int contents;
    private int CAPACITY;

    public Container() {
        this.contents = 0;
        this.CAPACITY = 100;
    }

    public int contains() {
        return this.contents;
    }

    public void add(int amount) {
        if (amount > 0) {
            this.contents += amount;
            if (this.contents > this.CAPACITY) {
                this.contents = this.CAPACITY;
            }
        }
    }

    public void remove(int amount) {
        if (amount > 0) {
            this.contents -= amount;
            if (this.contents < 0) {
                this.contents = 0;
            }
        }
    }

    @Override
    public String toString() {
        return this.contents + "/100";
    }
}
