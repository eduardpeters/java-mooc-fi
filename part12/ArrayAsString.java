
public class Program {

    public static void main(String[] args) {
        int rows = 2;
        int columns = 3;
        int[][] matrix = new int[rows][columns];
        matrix[0][1] = 5;
        matrix[1][0] = 3;
        matrix[1][2] = 7;
        System.out.println(arrayAsString(matrix));
    }

    public static String arrayAsString(int[][] array) {
        StringBuilder str = new StringBuilder();
        int rows = array.length;
        for (int r = 0; r < rows; r++) {
            int cols = array[r].length;
            for (int c = 0; c < cols; c++) {
                str.append(array[r][c]);
            }
            str.append('\n');
        }
        return str.toString();
    }

}
