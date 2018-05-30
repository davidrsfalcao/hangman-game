package database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import database.Dictionary.Category;

public class Word {
    private String complete;
    private Category category;
    private HashMap<Integer, Character> remainingLetters = new HashMap<Integer, Character>();

    public Word(String word, Category category){
        this.complete = word;
        this.category = category;

        for(int i=0; i < complete.length(); i++){
            remainingLetters.put(i, complete.charAt(i));
        }
    }

    public String getComplete() {
        return complete;
    }

    public Category getCategory() {
        return category;
    }

    public HashMap<Integer, Character> getRemainingLetters() {
        return remainingLetters;
    }

    @Override
    public String toString(){
        String result="";

        for (int i=0; i < complete.length(); i++){
            if(!remainingLetters.containsKey(i))
                result += complete.charAt(i);
            else result += "_";
        }
        return result;
    }

    public String testLetter(char letter){

        if(remainingLetters.containsValue(letter)){
            Iterator it = remainingLetters.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry)it.next();
                if(pair.getValue().equals(letter)){
                    it.remove();
                }

            }

        }

        return this.toString();
    }
}
