package logic;

import database.Dictionary;
import database.Word;


public class GameLogic {
    private int plays = 0;
    private int nrWordsDone = 0;
    private int rounds;
    private Word actualWord;

    public GameLogic(int rounds){
        this.rounds = rounds;
        Dictionary.getInstance();

    }

    public Word getActualWord() {
        return actualWord;
    }

    public void getNewWord(){
        actualWord = Dictionary.getInstance().getRandomWord();
    }


    public boolean checkChangeWord(){
        if(actualWord.isComplete()){
            this.plays += actualWord.getNrTries();
            this.nrWordsDone++;
            return true;
        }

        else return false;
    }

    public boolean checkGameEnd(){
        return (nrWordsDone == this.rounds);
    }

    public int getNrTries(){
        int res = plays;

        if(actualWord != null)
            res += actualWord.getNrTries();

        return res;
    }

}
