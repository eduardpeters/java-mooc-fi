
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int PASSINGGRADE = 50;

        Scanner scanner = new Scanner(System.in);
        Grades grades = new Grades(PASSINGGRADE);

        UserInterface ui = new UserInterface(scanner, grades);
        ui.start();
        printStatistics(grades);
    }

    public static void printStatistics(Grades grades) {
        double average = grades.average();
        System.out.print("Point average (all): ");
        if (average < 0) {
            System.out.println("-");
        } else {
            System.out.println(average);
        }

        double averagePassing = grades.averagePassing();
        System.out.print("Point average (passing): ");
        if (average < 0) {
            System.out.println("-");
        } else {
            System.out.println(averagePassing);
        }

        double percentagePassing = grades.percentagePassing();
        System.out.println("Pass percentage: " + percentagePassing);

        System.out.println("Grade distribution:");
        System.out.println("5: " + stringOfStars(grades.countGrades(90, 100)));
        System.out.println("4: " + stringOfStars(grades.countGrades(80, 89)));
        System.out.println("3: " + stringOfStars(grades.countGrades(70, 79)));
        System.out.println("2: " + stringOfStars(grades.countGrades(60, 69)));
        System.out.println("1: " + stringOfStars(grades.countGrades(50, 59)));
        System.out.println("0: " + stringOfStars(grades.countGrades(0, 49)));
    }

    public static String stringOfStars(int number) {
        String stars = "";

        for (int i = 0; i < number; i++) {
            stars += "*";
        }

        return stars;
    }
}
