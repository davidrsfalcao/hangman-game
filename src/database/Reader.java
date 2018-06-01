package database;

import database.Dictionary.Category;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Reader {

    public Reader(){};

    public void loadfile(String fileName, Category cat, ArrayList<Word> words) throws IOException {

        InputStream in = getClass().getResourceAsStream("res/"+ fileName);

        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String readWord;

        //InputStream in = getClass().getResourceAsStream("res/"+fileName);

        while((readWord = br.readLine()) != null)
            words.add(new Word(readWord.toLowerCase(), cat));

        br.close();
    }

}
