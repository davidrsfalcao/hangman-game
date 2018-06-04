package communication.handlers.server;

import communication.messages.Message;
import communication.messages.WordMessage;
import communication.responses.WordResponse;
import database.Word;
import logic.GameLogic;
import server.Server;

public class WordHandler extends  Handler{
    private String word;
    private String category;
    private int tries;

    WordHandler(Message message, Server server){
        int nr_player = ((WordMessage) message).getNr_player();

        GameLogic playerLogic = server.getPlayersLogic().get(nr_player);

        playerLogic.getNewWord();
        Word word = playerLogic.getActualWord();
        this.word = word.toString();
        this.category = word.getCategory().toString();
        this.tries = playerLogic.getNrTries();
    }

    @Override
    public String toString(){
        return new WordResponse(word, category, tries).toString();
    }

}
