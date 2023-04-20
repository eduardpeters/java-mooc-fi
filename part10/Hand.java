
import java.util.ArrayList;
import java.util.Collections;

public class Hand implements Comparable<Hand> {
    
    private ArrayList<Card> cards;
    
    public Hand() {
        this.cards = new ArrayList<>();
    }
    
    public void add(Card card) {
        this.cards.add(card);
    }
    
    public void print() {
        cards.stream().forEach(c -> System.out.println(c));
    }
    
    public void sort() {
        Collections.sort(this.cards);
    }
    
    public void sortBySuit() {
        Collections.sort(this.cards, new BySuitInValueOrder());
    }

    private int sumOfHand() {
        return this.cards.stream()
                .mapToInt(c -> c.getValue())
                .sum();
    }

    @Override
    public int compareTo(Hand otherHand) {
        return this.sumOfHand() - otherHand.sumOfHand();
    }

}
