
import java.util.ArrayList;

public class SimpleCollection {

    private String name;
    private ArrayList<String> elements;

    public SimpleCollection(String name) {
        this.name = name;
        this.elements = new ArrayList<>();
    }

    public void add(String element) {
        this.elements.add(element);
    }

    public ArrayList<String> getElements() {
        return this.elements;
    }

    public String longest() {
        if (this.elements.isEmpty()) {
            return null;
        }

        String returnElement = this.elements.get(0);

        for (String element : elements) {
            if (element.length() > returnElement.length()) {
                returnElement = element;
            }
        }

        return returnElement;
    }

    @Override
    public String toString() {
        String printOutput = "The collection " + this.name + " ";

        if (this.elements.isEmpty()) {
            return printOutput + "is empty.";
        }

        if (this.elements.size() == 1) {
            return printOutput + "has 1 element:\n" + this.elements.get(0);
        }
        
        printOutput += "has " + this.elements.size() + " elements:\n";

        for (String element : elements) {
            printOutput += element + "\n";
        }

        return printOutput;
    }

}
