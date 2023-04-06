
import java.util.ArrayList;

public class BirdDatabase {

    private ArrayList<BirdEntry> birdEntries;

    public BirdDatabase() {
        this.birdEntries = new ArrayList<>();
    }

    public void addEntry(Bird newBird) {
        birdEntries.add(new BirdEntry(newBird));
    }

    public ArrayList<BirdEntry> get() {
        return this.birdEntries;
    }

    public BirdEntry get(String commonName) {
        for (BirdEntry entry : birdEntries) {
            if (entry.getBirdName().equals(commonName)) {
                return entry;
            }
        }
        return null;
    }

    public boolean addObservation(String commonName) {
        BirdEntry entry = get(commonName);
        if (entry == null) {
            return false;
        }
        entry.addObservation();
        return true;
    }
}
