package communication.handlers.server;

import communication.Header;
import communication.messages.Message;
import communication.responses.ErrorResponse;
import server.Server;

public abstract class Handler implements Header {


    public static String parse(Message message, Server server){

        String res = new ErrorResponse("Wrong response").toString();

        switch (message.getType()){
            case JOIN:
                res = new JoinHandler(message, server).toString();
                break;

            case RECONNECT:
                res = new ReconnectHandler(message , server).toString();
                break;

            case READY:
                res = new ReadyHandler(message , server).toString();
                break;

            case PLAY:
                res = new PlayHandler(message , server).toString();
                break;

            case WORD:
                res = new WordHandler(message, server).toString();
                break;

            case NEXTWORD:
                res = new NextWordHandler(message, server).toString();
                break;

            case SCORE:
                res = new ScoreHandler(message, server).toString();
                break;

        }

        return res;
    }

    void updateActivity(int nrPlayer, Server server){

        if(server.getServerMaintenance().getPlayersActivity().containsKey(nrPlayer)){
            server.getServerMaintenance().getPlayersActivity().replace(nrPlayer, System.currentTimeMillis());
        }
        else {
            createActivity(nrPlayer, server);
        }
    }

    void createActivity(int nrPlayer, Server server){
        if(!server.getServerMaintenance().getPlayersActivity().containsKey(nrPlayer)){
            server.getServerMaintenance().getPlayersActivity().put(nrPlayer, System.currentTimeMillis());
        }
    }
}