package communication.handlers.server;

import communication.Header;
import communication.handlers.server.JoinHandler;
import communication.messages.Message;

public abstract class Handler implements Header {


    public static String parse(Message message){

        String res = "";

        switch (message.getType()){
            case JOIN:
                res = new JoinHandler().toString();
                break;
        }

        return res;
    }
}