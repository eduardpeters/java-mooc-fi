
import java.util.ArrayList;

public class Grades {

    private ArrayList<Integer> grades;
    private int passingGrade;

    public Grades(int passingGrade) {
        this.grades = new ArrayList<>();
        this.passingGrade = passingGrade;
    }

    public void add(int grade) {
        if (grade >= 0) {
            this.grades.add(grade);
        }
    }

    public double average() {
        if (grades.isEmpty()) {
            return -1;
        }

        int sum = 0;

        for (int grade : grades) {
            sum += grade;
        }

        return (double) sum / grades.size();
    }

    public double averagePassing() {
        if (grades.isEmpty()) {
            return -1;
        }

        int count = 0;
        int sum = 0;

        for (int grade : grades) {
            if (grade >= this.passingGrade) {
                count++;
                sum += grade;
            }
        }

        return (double) sum / count;
    }

    public int count() {
        return this.grades.size();
    }

    public int countPassing() {
        int count = 0;

        for (int grade : grades) {
            if (grade >= this.passingGrade) {
                count++;
            }
        }

        return count;
    }

    public double percentagePassing() {
        int total = this.count();
        if (total == 0) {
            return 0;
        }

        return 100.0 * this.countPassing() / total;
    }

    public int countGrades(int lowerLimit, int upperLimit) {
        int count = 0;

        for (int grade : grades) {
            if (grade >= lowerLimit && grade <= upperLimit) {
                count++;
            }
        }

        return count;
    }

}
