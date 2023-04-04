
import java.util.Arrays;

public class MainProgram {

    public static void main(String[] args) {
        // write your test code here
        int[] array = {3, 1, 5, 99, 3, 12};
        System.out.println(Arrays.toString(array));
        sort(array);
    }

    public static int smallest(int[] array) {
        int smallest = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] < smallest) {
                smallest = array[i];
            }
        }

        return smallest;
    }

    public static int indexOfSmallest(int[] array) {
        int index = 0;

        while (array[index] != smallest(array)) {
            index++;
        }

        return index;
    }

    public static int indexOfSmallestFrom(int[] table, int startIndex) {
        int indexOfSmallest = startIndex;

        for (int i = startIndex + 1; i < table.length; i++) {
            if (table[i] < table[indexOfSmallest]) {
                indexOfSmallest = i;
            }
        }

        return indexOfSmallest;
    }

    public static void swap(int[] array, int index1, int index2) {
        int temp;

        temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void sort(int[] array) {

        for (int i = 0; i < array.length; i++) {
            swap(array, i, indexOfSmallestFrom(array, i));
            System.out.println(Arrays.toString(array));
        }
    }

}
