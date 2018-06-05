package communication.handlers.server;

import communication.messages.Message;
import communication.messages.ReconnectMessage;
import communication.responses.EndGameResponse;
import communication.responses.JoinResponse;
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
            response = new JoinResponse(nr_player).toString();
        }

        updateActivity(nr_player, server);

    }

    @Override
    public String toString(){
        return response;
    }

}
