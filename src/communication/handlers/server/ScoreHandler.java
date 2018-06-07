package communication.handlers.server;

import communication.messages.Message;
import communication.messages.ScoreMessage;
import communication.responses.ScoreResponse;
import communication.responses.WaitResponse;
import server.Server;

import java.util.ArrayList;
import java.util.HashMap;

public class ScoreHandler extends Handler {

    private String result;

    ScoreHandler(Message message, Server server){

        int nrPlayer = ((ScoreMessage) message).getNr_player();

        updateActivity(nrPlayer, server);
        server.addFinishedPlayer(nrPlayer);

        if(server.isGameFinished()){

            //TODO: Ordenar

            final ArrayList<Integer> playersFinished = server.getPlayersFinished();
            HashMap<String, Integer> scores = new HashMap<>();

            for(int i=0; i < playersFinished.size(); i++){
                int player = playersFinished.get(i);
                String user = server.getPlayersUsername().get(player);
                int score = server.getPlayersLogic().get(player).getNrTries();
                scores.put(user,score);
            }

            result = new ScoreResponse(scores).toString();
        }
        else result = new WaitResponse().toString();

    }

    @Override
    public String toString(){
        return result;
    }
}
