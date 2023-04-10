
import java.util.HashMap;

public class IOU {

    private HashMap<String, Double> debtRecord;

    public IOU() {
        this.debtRecord = new HashMap<>();
    }

    public void setSum(String toWhom, double amount) {
        debtRecord.put(toWhom, amount);
    }

    public double howMuchDoIOweTo(String toWhom) {
        return debtRecord.getOrDefault(toWhom, 0.0);
    }
}
