
import java.util.ArrayList;
import java.util.HashMap;

public class StorageFacility {

    private HashMap<String, ArrayList<String>> storageUnits;

    public StorageFacility() {
        this.storageUnits = new HashMap<>();
    }

    public void add(String unit, String item) {
        this.storageUnits.putIfAbsent(unit, new ArrayList<>());
        this.storageUnits.get(unit).add(item);
    }

    public ArrayList<String> contents(String storageUnit) {
        return this.storageUnits.getOrDefault(storageUnit, new ArrayList<>());
    }

    public void remove(String storageUnit, String item) {
        ArrayList<String> contents = this.storageUnits.get(storageUnit);
        if (contents == null) {
            return;
        }

        contents.remove(item);

        if (contents.isEmpty()) {
            this.storageUnits.remove(storageUnit);
        }
    }

    public ArrayList<String> storageUnits() {
        ArrayList<String> occupiedUnits = new ArrayList<>();

        for (String storageUnit : storageUnits.keySet()) {
            if (storageUnits.get(storageUnit).isEmpty()) {
                continue;
            }
            occupiedUnits.add(storageUnit);
        }

        return occupiedUnits;
    }
}
