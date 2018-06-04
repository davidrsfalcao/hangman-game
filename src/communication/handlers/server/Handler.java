package communication.handlers.server;

import communication.Header;
import communication.messages.Message;
import logic.GameLogic;
import server.Server;

public abstract class Handler implements Header {


    public static String parse(Message message, Server server){

        String res = "";

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
}