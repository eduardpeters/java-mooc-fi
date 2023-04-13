
public class Student extends Person {

    private int studyCredits;

    public Student(String fullName, String address) {
        super(fullName, address);
        this.studyCredits = 0;
    }

    public void study() {
        this.studyCredits += 1;
    }

    public int credits() {
        return this.studyCredits;
    }

    @Override
    public String toString() {
        return super.toString() + "  Study credits " + this.studyCredits;
    }
}
