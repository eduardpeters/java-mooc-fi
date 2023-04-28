
public class Hideout<T> {

    private T object;

    public void putIntoHideout(T toHide) {
        this.object = toHide;
    }

    public T takeFromHideout() {
        T leaving = this.object;
        this.object = null;
        return leaving;
    }

    public boolean isInHideout() {
        return this.object != null;
    }
}
