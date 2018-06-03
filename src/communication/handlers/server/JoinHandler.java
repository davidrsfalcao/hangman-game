package communication.handlers.server;

import communication.messages.JoinMessage;
import communication.messages.Message;
import communication.responses.JoinResponse;
import logic.GameLogic;
import server.Server;

public class JoinHandler extends Handler {

    private String ip;
    private int nr_player;

    public JoinHandler(Message message, Server server){
        ip = ((JoinMessage) message).getIp();


        if(server.getPlayers().containsKey(ip)){
            nr_player = server.getPlayers().get(ip);
        }
        else {
            nr_player = server.getPlayers().size();
            server.getPlayers().put(ip,nr_player);
            server.getPlayersLogic().put(nr_player,new GameLogic());
        }


    }

    @Override
    public String toString(){
        return new JoinResponse(nr_player).toString();
    }

}
