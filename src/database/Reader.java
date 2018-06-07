package database;

import database.Dictionary.Category;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Reader {

    Reader(){};

    void loadFile(String fileName, Category cat, ArrayList<Word> words) throws IOException {

        InputStream in = getClass().getResourceAsStream("res/"+ fileName);

        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String readWord;


        while((readWord = br.readLine()) != null)
            words.add(new Word(readWord, cat));

        br.close();
    }

}
