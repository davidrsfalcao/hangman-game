package database;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Dictionary {
    private static Dictionary instance;
    private ArrayList<Word> words = new ArrayList<>();

    public enum Category {
        animal, country, object, brand, job, color
    }

    private Dictionary() {
        try {
            loadFiles();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Dictionary getInstance() {
        if(instance == null)
            instance = new Dictionary();

        return instance;
    }

    private void loadFiles() throws IOException {
        Reader reader = new Reader();
        reader.loadFile("animals.txt",Category.animal, words);
        reader.loadFile("jobs.txt",Category.job, words);
        reader.loadFile("object.txt",Category.object, words);
        reader.loadFile("countries.txt",Category.country, words);
        reader.loadFile("brands.txt",Category.brand, words);
        reader.loadFile("colors.txt",Category.color, words);
    }

    public Word getRandomWord(){

        int size = words.size();
        Random rand = new Random();

        if(size == 0)
            return null;

        int index = rand.nextInt(size);
        Word word =  words.get(index);
        words.remove(index);

        return word;
    }

}
