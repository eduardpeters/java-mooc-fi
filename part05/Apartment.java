
public class Apartment {

    private int rooms;
    private int squares;
    private int princePerSquare;

    public Apartment(int rooms, int squares, int pricePerSquare) {
        this.rooms = rooms;
        this.squares = squares;
        this.princePerSquare = pricePerSquare;
    }

    public boolean largerThan(Apartment compared) {
        return this.squares > compared.squares;
    }

    public int getPrice() {
        return this.squares * this.princePerSquare;
    }

    public int priceDifference(Apartment compared) {
        int priceDifference = this.getPrice() - compared.getPrice();
        return priceDifference < 0 ? priceDifference * -1 : priceDifference;
    }

    public boolean moreExpensiveThan(Apartment compared) {
        return this.getPrice() > compared.getPrice();
    }

}
