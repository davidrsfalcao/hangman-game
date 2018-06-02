package communication.handlers.server;

import communication.Header;
import communication.handlers.server.JoinHandler;
import communication.messages.Message;
import logic.GameLogic;

public abstract class Handler implements Header {


    public static String parse(Message message, GameLogic logic){

        String res = "";

        switch (message.getType()){
            case JOIN:
                res = new JoinHandler().toString();
                break;

            case WORD:
                res = new WordHandler(logic).toString();
                break;

            case PLAY:
                res = new PlayHandler(message , logic).toString();
                break;
        }

        return res;
    }
}