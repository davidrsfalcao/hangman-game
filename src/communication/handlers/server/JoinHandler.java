package communication.handlers.server;

import communication.messages.JoinMessage;
import communication.messages.Message;
import communication.responses.JoinResponse;
import communication.responses.ReconnectResponse;
import logic.GameLogic;
import server.Server;

public class JoinHandler extends Handler {

    private String res;

    JoinHandler(Message message, Server server){
        String ip = ((JoinMessage) message).getIp();


        int nr_player;
        String username;
        if(server.getPlayers().containsKey(ip)){
            nr_player = server.getPlayers().get(ip);
            username = server.getPlayersUsername().get(nr_player);
            res = new ReconnectResponse(nr_player,username).toString();
            updateActivity(nr_player, server);
        }
        else {
            nr_player = server.getPlayers().size();
            server.getPlayers().put(ip, nr_player);
            server.getPlayersLogic().put(nr_player,new GameLogic(server.getRounds()));
            res = new JoinResponse(nr_player).toString();
            createActivity(nr_player, server);
        }


    }

    @Override
    public String toString(){
        return res;
    }

}
