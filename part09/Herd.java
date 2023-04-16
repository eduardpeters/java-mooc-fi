
import java.util.ArrayList;
import java.util.List;

public class Herd implements Movable {
    
    private List<Movable> members;
    
    public Herd() {
        this.members = new ArrayList<>();
    }
    
    @Override
    public String toString() {
        String positions = "";
        for (Movable member : this.members) {
            positions = positions + member + "\n";
        }
        return positions;
    }
    
    public void addToHerd(Movable movable) {
        this.members.add(movable);
    }
    
    @Override
    public void move(int dx, int dy) {
        for (Movable member : this.members) {
            member.move(dx, dy);
        }
    }
}
