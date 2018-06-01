package logic;

import database.Dictionary;
import database.Word;

import java.util.ArrayList;

public class GameLogic {
    private int plays = 0;
    private int nrWordsDone = 0;
    private int rounds = 3;
    private boolean gameEnded = false;
    private ArrayList<Word> wordsDone = new ArrayList<Word>();
    private Word actualWord;

    public GameLogic(){
        Dictionary.getInstance();

    }

    public int getPlays() {
        return plays;
    }

    public int getNrWordsDone() {
        return nrWordsDone;
    }

    public int getRounds() {
        return rounds;
    }

    public boolean isGameEnded() {
        return gameEnded;
    }

    public ArrayList<Word> getWordsDone() {
        return wordsDone;
    }

    public Word getActualWord() {
        return actualWord;
    }

    public void getNewWord(){
        actualWord = Dictionary.getInstance().getRandomWord();
    }

    public boolean checkChangeWord(){
        if(actualWord.getRemainingLetters().size() == 0){
            this.plays += actualWord.getNrTries();
            this.nrWordsDone++;
            return true;
        }

        else return false;
    }

    public void checkGameEnd(){


    }




}
