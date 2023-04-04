
public class Container {

    private int content;
    private int CAPACITY = 100;

    public Container() {
        this.content = 0;
    }

    public int contains() {
        return this.content;
    }
    
    public int capacity() {
        return this.CAPACITY;
    }

    public void add(int amount) {
        if (amount > 0) {
            if (amount > this.CAPACITY - this.content) {
                amount = this.CAPACITY - this.content;
            }
            this.content += amount;
        }
    }

    public void remove(int amount) {
        if (amount > 0) {
            if (amount > this.content) {
                amount = this.content;
            }
            this.content -= amount;
        }
    }

    @Override
    public String toString() {
        return this.content + "/" + this.CAPACITY;
    }
}
