package dictionary;

import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class SaveableDictionary {

    private HashMap<String, String> dictionary;
    private String file;

    public SaveableDictionary() {
        this.dictionary = new HashMap<>();
    }

    public SaveableDictionary(String file) {
        this.dictionary = new HashMap<>();
        this.file = file;
    }

    public boolean load() {
        try ( Scanner fileReader = new Scanner(Paths.get(this.file))) {
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                String[] parts = line.split(":");

                this.add(parts[0], parts[1]);
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean save() {
        ArrayList<String> printed = new ArrayList<>();
        try ( PrintWriter filePrinter = new PrintWriter(this.file)) {
            this.dictionary.forEach((key, value) -> {
                if (!printed.contains(key)) {
                    filePrinter.println(key + ":" + value);
                    printed.add(value);
                }
            });
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public void add(String words, String translation) {
        this.dictionary.putIfAbsent(words, translation);
        this.dictionary.putIfAbsent(translation, words);
    }

    public String translate(String word) {
        return this.dictionary.get(word);
    }

    public void delete(String word) {
        String translation = this.dictionary.get(word);
        if (translation == null) {
            return;
        }
        this.dictionary.remove(translation);
        this.dictionary.remove(word);
    }
}
