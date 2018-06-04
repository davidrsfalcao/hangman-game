package communication.handlers.server;

import communication.messages.Message;
import communication.messages.ReadyMessage;
import communication.responses.WaitResponse;
import communication.responses.WordResponse;
import database.Word;
import logic.GameLogic;
import server.Server;

public class ScoreHandler extends Handler {

    private String result;

    ScoreHandler(Message message, Server server){

        //TODO: Check all players ended game
        result = new WaitResponse().toString();

    }

    @Override
    public String toString(){
        return result;
    }
}
