
public class Division {

    public static void main(String[] args) {
        division(3, 5);
    }

    // implement the method here
    public static void division(int numerator, int denominator) {
        if (denominator == 0) {
            System.out.println("Cannot divide by zero");
        } else {
            System.out.println((double) numerator / denominator);
        }
    }
}
