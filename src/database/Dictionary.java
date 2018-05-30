package database;

import java.io.IOException;
import java.util.ArrayList;

public class Dictionary {
    private static Dictionary instance;
    private ArrayList<Word> words = new ArrayList<Word>();

    public enum Category {
        animal, countrie, object, brand, job
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
        reader.loadfile("animals.txt",Category.animal);
        reader.loadfile("jobs.txt",Category.job);
        reader.loadfile("object.txt",Category.object);
    }

}
