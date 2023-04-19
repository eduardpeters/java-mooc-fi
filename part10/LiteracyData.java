
public class LiteracyData {

    String country;
    int year;
    String gender;
    double percentage;

    public LiteracyData(String country, int year, String gender, double percentage) {
        this.country = country;
        this.year = year;
        if (gender.contains("f")) {
            this.gender = "female";
        } else {
            this.gender = "male";
        }
        this.percentage = percentage;
    }

    public String getCountry() {
        return this.country;
    }

    public int getYear() {
        return this.year;
    }

    public String getGender() {
        return this.gender;
    }

    public double getPercentage() {
        return this.percentage;
    }

    @Override
    public String toString() {
        return this.country + " (" + this.year + "), " + this.gender + ", " + this.percentage;
    }

}
