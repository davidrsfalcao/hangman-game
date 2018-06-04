package communication.handlers.server;

import communication.messages.Message;
import communication.messages.ReadyMessage;
import communication.responses.WaitResponse;
import communication.responses.WordResponse;
import database.Word;
import logic.GameLogic;
import server.Server;


public class ReadyHandler extends Handler{

    private String result;

    public ReadyHandler(Message message, Server server){

        String server_ip = server.getIP();

        if(server.getPlayers().containsKey(server_ip)){
        //if(server.getPlayers().size() >= 2){
            int nr_player = ((ReadyMessage) message).getNr_player();

            GameLogic playerLogic = server.getPlayersLogic().get(nr_player);

            playerLogic.getNewWord();
            Word word = playerLogic.getActualWord();
            String word_s = word.toString();
            String category = word.getCategory().toString();
            int tries = playerLogic.getNrTries();

            result = new WordResponse(word_s, category, tries).toString();
        }
        else result = new WaitResponse().toString();


    }

    @Override
    public String toString(){
        return result;
    }

}