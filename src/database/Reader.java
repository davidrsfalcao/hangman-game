package database;

import database.Dictionary.Category;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Reader {

    public void loadfile(String fileName, Category cat) throws IOException {

        InputStream in = getClass().getResourceAsStream("res/"+ fileName);

        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String readWord;

        //InputStream in = getClass().getResourceAsStream("res/"+fileName);

        while((readWord = br.readLine()) != null)
            Dictionary.getInstance().getWords().add(new Word(readWord.toLowerCase(), cat));

        br.close();
    }

}
