
public class BirdEntry {

    private Bird bird;
    private int observations;
    
    public BirdEntry(Bird bird) {
        this.bird = bird;
        this.observations = 0;
    }
    
    public void addObservation() {
        this.observations += 1;
    }
    
    public String getBirdName() {
        return this.bird.getCommonName();
    }

    @Override
    public String toString() {
        return this.bird + ": " + this.observations + " observations";
    }
}
