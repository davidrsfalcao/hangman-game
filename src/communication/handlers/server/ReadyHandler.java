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

    ReadyHandler(Message message, Server server){

        String server_ip = server.getIP();
        int nr_player = ((ReadyMessage) message).getNr_player();
        String username = ((ReadyMessage) message).getUsername();
        server.updatePlayersUsername(nr_player, username);

        if(server.getPlayers().containsKey(server_ip)){
        //if(server.getPlayers().size() >= 2){

            GameLogic playerLogic = server.getPlayersLogic().get(nr_player);

            playerLogic.getNewWord();
            Word word = playerLogic.getActualWord();
            String word_s = word.toString();
            String category = word.getCategory().toString();
            int tries = playerLogic.getNrTries();

            result = new WordResponse(word_s, category, tries).toString();
        }
        else result = new WaitResponse().toString();

        updateActivity(nr_player, server);

    }

    @Override
    public String toString(){
        return result;
    }

}