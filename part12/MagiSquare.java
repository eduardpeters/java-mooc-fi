
import java.util.ArrayList;
import java.util.Collections;

public class MagicSquare {

    private int[][] square;

    // ready constructor
    public MagicSquare(int size) {
        if (size < 2) {
            size = 2;
        }

        this.square = new int[size][size];
    }

    // implement these three methods
    public ArrayList<Integer> sumsOfRows() {
        ArrayList<Integer> sums = new ArrayList<>();
        for (int r = 0; r < this.square.length; r++) {
            int rowSum = 0;
            for (int c = 0; c < this.square.length; c++) {
                rowSum += this.square[r][c];
            }
            sums.add(rowSum);
        }
        return sums;
    }

    public ArrayList<Integer> sumsOfColumns() {
        ArrayList<Integer> sums = new ArrayList<>();
        for (int c = 0; c < this.square.length; c++) {
            int colSum = 0;
            for (int r = 0; r < this.square.length; r++) {
                colSum += this.square[r][c];
            }
            sums.add(colSum);
        }
        return sums;
    }

    public ArrayList<Integer> sumsOfDiagonals() {
        ArrayList<Integer> sums = new ArrayList<>();
        int diagSum = 0;
        int c = 0;
        for (int r = 0; r < this.square.length; r++) {
            diagSum += this.square[r][c];
            c++;
        }
        sums.add(diagSum);
        diagSum = 0;
        c = 0;
        for (int r = this.square.length - 1; r >= 0; r--) {
            diagSum += this.square[r][c];
            c++;
        }
        sums.add(diagSum);
        return sums;
    }
    // ready-made helper methods -- don't touch these

    public boolean isMagicSquare() {
        return sumsAreSame() && allNumbersDifferent();
    }

    public ArrayList<Integer> giveAllNumbers() {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int row = 0; row < square.length; row++) {
            for (int col = 0; col < square[row].length; col++) {
                numbers.add(square[row][col]);
            }
        }

        return numbers;
    }

    public boolean allNumbersDifferent() {
        ArrayList<Integer> numbers = giveAllNumbers();

        Collections.sort(numbers);
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i - 1) == numbers.get(i)) {
                return false;
            }
        }

        return true;
    }

    public boolean sumsAreSame() {
        ArrayList<Integer> sums = new ArrayList<>();
        sums.addAll(sumsOfRows());
        sums.addAll(sumsOfColumns());
        sums.addAll(sumsOfDiagonals());

        if (sums.size() < 3) {
            return false;
        }

        for (int i = 1; i < sums.size(); i++) {
            if (sums.get(i - 1) != sums.get(i)) {
                return false;
            }
        }

        return true;
    }

    public int readValue(int x, int y) {
        if (x < 0 || y < 0 || x >= getWidth() || y >= getHeight()) {
            return - 1;
        }

        return this.square[y][x];
    }

    public void placeValue(int x, int y, int value) {
        if (x < 0 || y < 0 || x >= getWidth() || y >= getHeight()) {
            return;
        }

        this.square[y][x] = value;
    }

    public int getWidth() {
        return this.square.length;
    }

    public int getHeight() {
        return this.square.length;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int row = 0; row < square.length; row++) {
            for (int col = 0; col < square[row].length; col++) {
                result.append(square[row][col]).append("\t");
            }

            result.append("\n");
        }

        return result.toString();
    }
}
