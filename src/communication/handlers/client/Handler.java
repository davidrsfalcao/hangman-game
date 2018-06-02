package communication.handlers.client;

import communication.Header;
import communication.handlers.client.JoinHandler;
import communication.responses.Response;

public abstract class Handler implements Header {


    public static String parse(Response response){

        String res = "";
        //System.out.println("HANDLER PARSE "+ response.getType());

        switch (response.getType()){
            case JOIN:
                res = new JoinHandler(response).toString();
                break;

            case WORD:
                res = new WordHandler(response).toString();
                break;
        }

        return res;
    }
}