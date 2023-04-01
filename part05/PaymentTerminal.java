
public class PaymentTerminal {

    private double money;  // amount of cash
    private int affordableMeals; // number of sold affordable meals
    private int heartyMeals;  // number of sold hearty meals
    private final double AFFORDABLECOST = 2.50;
    private final double HEARTYCOST = 4.30;

    public PaymentTerminal() {
        // register initially has 1000 euros of money
        this.money = 1000.0;
        this.affordableMeals = 0;
        this.heartyMeals = 0;
    }

    public double eatAffordably(double payment) {
        // an affordable meal costs 2.50 euros
        // increase the amount of cash by the price of an affordable mean and return the change
        // if the payment parameter is not large enough, no meal is sold and the method should return the whole payment
        if (payment < this.AFFORDABLECOST) {
            return payment;
        }

        this.affordableMeals += 1;
        this.money += this.AFFORDABLECOST;
        double change = payment - this.AFFORDABLECOST;
        return change;
    }

    public boolean eatAffordably(PaymentCard card) {
        if (card.takeMoney(this.AFFORDABLECOST)) {
            this.affordableMeals += 1;
            return true;
        }

        return false;
    }

    public double eatHeartily(double payment) {
        // a hearty meal costs 4.30 euros
        // increase the amount of cash by the price of a hearty mean and return the change
        // if the payment parameter is not large enough, no meal is sold and the method should return the whole payment

        if (payment < this.HEARTYCOST) {
            return payment;
        }

        this.heartyMeals += 1;
        this.money += this.HEARTYCOST;
        double change = payment - this.HEARTYCOST;
        return change;
    }

    public boolean eatHeartily(PaymentCard card) {
        if (card.takeMoney(this.HEARTYCOST)) {
            this.heartyMeals += 1;
            return true;
        }

        return false;
    }

    public void addMoneyToCard(PaymentCard card, double sum) {
        if (sum <= 0) {
            return;
        }

        this.money += sum;
        card.addMoney(sum);
    }

    @Override
    public String toString() {
        return "money: " + money + ", number of sold affordable meals: " + affordableMeals + ", number of sold hearty meals: " + heartyMeals;
    }
}
