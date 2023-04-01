
public class SimpleDate {

    private int day;
    private int month;
    private int year;

    public SimpleDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override
    public String toString() {
        return this.day + "." + this.month + "." + this.year;
    }

    public boolean before(SimpleDate compared) {
        if (this.year < compared.year) {
            return true;
        }

        if (this.year == compared.year && this.month < compared.month) {
            return true;
        }

        if (this.year == compared.year && this.month == compared.month
                && this.day < compared.day) {
            return true;
        }

        return false;
    }

    public void advance(int howManyDays) {
        final int MONTHDAYS = 30;
        final int YEARDAYS = 30 * 12;
        final int YEARMONTHS = 12;

        if (howManyDays >= YEARDAYS) {
            this.year += howManyDays / YEARDAYS;
            howManyDays = howManyDays % YEARDAYS;
        }

        if (howManyDays >= MONTHDAYS) {
            this.month += howManyDays / MONTHDAYS;
            if (this.month > YEARMONTHS) {
                this.month = this.month - YEARMONTHS;
            }
            howManyDays = howManyDays % MONTHDAYS;
        }

        this.day += howManyDays;
        if (this.day > MONTHDAYS) {
            this.month += 1;
            if (this.month > YEARMONTHS) {
                this.month = 1;
                this.year += 1;
            }
            this.day = this.day - MONTHDAYS;
        }

    }

    public void advance() {
        this.advance(1);
    }

    public SimpleDate afterNumberOfDays(int days) {
        SimpleDate newDate = new SimpleDate(this.day, this.month, this.year);
        newDate.advance(days);
        return newDate;
    }

}
