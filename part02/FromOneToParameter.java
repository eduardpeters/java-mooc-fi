

public class FromOneToParameter {

    public static void main(String[] args) {
        printUntilNumber(7);
    }
    
    public static void printUntilNumber(int number) {
        for (int i = 1; i <= number; i++) {
            System.out.println(i);
        }
    }

}
