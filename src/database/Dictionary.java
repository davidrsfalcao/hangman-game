package database;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Dictionary {
    private static Dictionary instance;
    private ArrayList<Word> words = new ArrayList<Word>();

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

    public ArrayList<Word> getWords() {
        return words;
    }

    private void loadFiles() throws IOException {
        Reader reader = new Reader();
        reader.loadfile("animals.txt",Category.animal, words);
        reader.loadfile("jobs.txt",Category.job, words);
        reader.loadfile("object.txt",Category.object, words);
        reader.loadfile("countries.txt",Category.country, words);
        reader.loadfile("brands.txt",Category.brand, words);
        reader.loadfile("colors.txt",Category.color, words);
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
