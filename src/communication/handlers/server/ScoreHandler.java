package communication.handlers.server;

import communication.messages.Message;
import communication.messages.ReadyMessage;
import communication.messages.ScoreMessage;
import communication.responses.WaitResponse;
import communication.responses.WordResponse;
import database.Word;
import logic.GameLogic;
import server.Server;

public class ScoreHandler extends Handler {

    private String result;

    ScoreHandler(Message message, Server server){

        int nrPlayer = ((ScoreMessage) message).getNr_player();

        updateActivity(nrPlayer, server);
        server.addFinishedPlayer(nrPlayer);

        //TODO: Check all players ended game

        if(server.isGameFinished()){
            result = "ACABOU" + (char) 13;
        }
        else result = new WaitResponse().toString();

    }

    @Override
    public String toString(){
        return result;
    }
}
