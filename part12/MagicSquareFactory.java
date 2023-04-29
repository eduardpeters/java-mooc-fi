
public class MagicSquareFactory {

    public MagicSquare createMagicSquare(int size) {

        MagicSquare square = new MagicSquare(size);

        // implement the creation of a magic square with the Siamese method algorithm here
        int row = 0;
        int column = size / 2;
        square.placeValue(column, row, 1);
        for (int nextNumber = 2; nextNumber <= size * size; nextNumber++) {
            int nextRow = row - 1 < 0 ? size - 1 : row - 1;
            int nextColumn = (column + 1) % size;
            // Check if diagonal is filled, go down if not
            if (square.readValue(nextColumn, nextRow) > 0) {
                row = row + 1 == size ? 0 : row + 1;
            } else {
                row = nextRow;
                column = nextColumn;
            }
            square.placeValue(column, row, nextNumber);
        }
        return square;
    }

}
