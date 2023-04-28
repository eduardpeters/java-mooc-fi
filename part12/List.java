
public class List<T> {

    private T[] values;
    private int firstFreeIndex;

    public List() {
        this.values = (T[]) new Object[10];
        this.firstFreeIndex = 0;
    }

    public void add(T value) {
        if (this.firstFreeIndex == this.values.length) {
            this.grow();
        }
        this.values[firstFreeIndex] = value;
        this.firstFreeIndex++;
    }

    private void grow() {
        int newSize = this.values.length + this.values.length / 2;
        T[] newValues = (T[]) new Object[newSize];
        for (int i = 0; i < this.values.length; i++) {
            newValues[i] = this.values[i];
        }
        this.values = newValues;
    }

    public int indexOfValue(T value) {
        for (int i = 0; i < this.firstFreeIndex; i++) {
            if (this.values[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    private void shiftLeftFrom(int fromIndex) {
        if (fromIndex < 0) {
            return;
        }
        for (int i = fromIndex; i < this.firstFreeIndex - 1; i++) {
            this.values[i] = this.values[i + 1];
        }
    }

    public void remove(T value) {
        int indexOfValue = this.indexOfValue(value);
        if (indexOfValue < 0) {
            return;
        }
        this.shiftLeftFrom(indexOfValue);
        this.firstFreeIndex--;
    }

    public boolean contains(T value) {
        return this.indexOfValue(value) >= 0;
    }

    public T value(int index) {
        if (index < 0 || index >= this.firstFreeIndex) {
            throw new ArrayIndexOutOfBoundsException("Index " + index + " outside of [0, " + (this.firstFreeIndex - 1) + "]");
        }
        return this.values[index];
    }

    public int size() {
        return this.firstFreeIndex;
    }
}
