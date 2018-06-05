package communication.handlers.server;

import communication.messages.Message;
import communication.messages.ReconnectMessage;
import communication.responses.EndGameResponse;
import communication.responses.WordResponse;
import database.Word;
import logic.GameLogic;
import server.Server;

public class ReconnectHandler extends Handler{
    private String response;


    ReconnectHandler(Message message, Server server){
        int nr_player = ((ReconnectMessage) message).getNr_player();

        GameLogic playerLogic = server.getPlayersLogic().get(nr_player);

        if(playerLogic.checkGameEnd()){
            response = new EndGameResponse().toString();
        }
        else {
            if(playerLogic.getActualWord() == null)
            playerLogic.getNewWord();

            Word word = playerLogic.getActualWord();
            String word_s = word.toString();
            String category = word.getCategory().toString();
            int tries = playerLogic.getNrTries();

            response = new WordResponse(word_s, category, tries).toString();
        }

        updateActivity(nr_player, server);

    }

    @Override
    public String toString(){
        return response;
    }

}
