package database;

import database.Dictionary.Category;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Word {
    private String complete;
    private Category category;
    private int nrTries;
    private HashMap<Integer, Character> remainingLetters = new HashMap<>();
    private final ArrayList<Character> specialChars = new ArrayList<>();

    public Word(String word, Category category){
        this.complete = word;
        this.category = category;
        this.nrTries = 0;

        defineSpecialChars();

        for(int i=0; i < complete.length(); i++){

            if(!specialChars.contains(complete.charAt(i))){
                remainingLetters.put(i, Character.toLowerCase(complete.charAt(i)));
            }
        }
    }

    private void defineSpecialChars(){
        specialChars.add('-');
        specialChars.add(' ');
        specialChars.add('ã');
        specialChars.add('ç');
        specialChars.add('á');
        specialChars.add('à');
        specialChars.add('é');
        specialChars.add('ê');
        specialChars.add('ô');
        specialChars.add('ó');
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
        StringBuilder result= new StringBuilder();

        for (int i=0; i < complete.length(); i++){
            if(!remainingLetters.containsKey(i))
                result.append(complete.charAt(i));
            else result.append("_");
        }
        return result.toString();
    }

    public String testLetter(char letter){
        if((remainingLetters.containsValue(Character.toLowerCase(letter)))){
            Iterator it = remainingLetters.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry)it.next();

                if(Character.toLowerCase((Character) pair.getValue()) == (Character.toLowerCase(letter))){
                    it.remove();
                }

            }

        }

        this.nrTries++;

        return this.toString();
    }

    public int getNrTries() {
        return nrTries;
    }

    public String testWord(String word){

        if(complete.toLowerCase().equals(word.toLowerCase())){
            remainingLetters = new HashMap<>();
            nrTries++;
        }
        else nrTries+= 10;

        return this.toString();
    }

    public boolean isComplete(){
        return this.toString().equals(complete);

    }
}
