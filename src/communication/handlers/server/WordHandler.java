package communication.handlers.server;

import communication.responses.WordResponse;
import database.Word;
import logic.GameLogic;

public class WordHandler extends  Handler{
    private String word;
    private String category;
    private int tries;

    public WordHandler(GameLogic logic){
        logic.getNewWord();
        Word word = logic.getActualWord();
        this.word = word.toString();
        this.category = word.getCategory().toString();
        this.tries = logic.getNrTries();
    }

    @Override
    public String toString(){
        return new WordResponse(word, category, tries).toString();
    }

}
