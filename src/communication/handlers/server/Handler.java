package communication.handlers.server;

import communication.Header;
import communication.handlers.server.JoinHandler;
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

            case WORD:
                res = new WordHandler(message, server).toString();
                break;

            case PLAY:
                res = new PlayHandler(message , server).toString();
                break;
        }

        return res;
    }
}