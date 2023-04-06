
public class Bird {
    private String commonName;
    private String scientificName;
    
    public Bird(String commonName, String scientificName) {
        this.commonName = commonName;
        this.scientificName = scientificName;
    }
    
    public String getCommonName() {
        return this.commonName;
    }
    
    public String getScientificName() {
        return this.scientificName;
    }
    
    @Override
    public String toString() {
        return this.commonName + " (" + this.scientificName + ")";
    }
}
