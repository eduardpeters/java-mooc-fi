
public class Gift {

    private String name;
    private int weigth;

    public Gift(String name, int weight) {
        this.name = name;
        this.weigth = weight;
    }

    public String getName() {
        return this.name;
    }

    public int getWeight() {
        return this.weigth;
    }

    @Override
    public String toString() {
        return this.name + " (" + this.weigth + ")";
    }
}
