
public class PaymentCard {

    private double balance;
    private final double affordablePrice;
    private final double heartyPrice;

    public PaymentCard(double openingBalance) {
        this.balance = openingBalance;
        this.affordablePrice = 2.60;
        this.heartyPrice = 4.60;
    }

    public String toString() {
        return "The card has a balance of " + this.balance + " euros";
    }

    public void addMoney(double amount) {
        if (amount < 0) {
            return;
        }
        if (this.balance + amount > 150.0) {
            this.balance = 150.0;
        } else {
            this.balance = this.balance + amount;
        }
    }

    public void eatAffordably() {
        if (this.balance < this.affordablePrice) {
            return;
        }
        this.balance -= this.affordablePrice;
    }

    public void eatHeartily() {
        if (this.balance < this.heartyPrice) {
            return;
        }
        this.balance -= this.heartyPrice;
    }

}
