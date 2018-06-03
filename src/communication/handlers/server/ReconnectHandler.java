package communication.handlers.server;

import communication.messages.Message;
import communication.messages.ReconnectMessage;
import communication.messages.WordMessage;
import communication.responses.WordResponse;
import database.Word;
import logic.GameLogic;
import server.Server;

public class ReconnectHandler extends Handler{
    private String word;
    private String category;
    private int tries;

    public ReconnectHandler(Message message, Server server){
        int nr_player = ((ReconnectMessage) message).getNr_player();

        GameLogic playerLogic = server.getPlayersLogic().get(nr_player);

        if(playerLogic.getActualWord() == null)
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
