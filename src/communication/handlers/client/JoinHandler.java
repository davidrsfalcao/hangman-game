package communication.handlers.client;


import communication.messages.WordMessage;
import communication.responses.JoinResponse;
import communication.responses.Response;

public class JoinHandler extends Handler{

    private String message = "";

    public JoinHandler(Response response){
        if(((JoinResponse) response).getResult().equals(SUCCESS)){
            message = new WordMessage().toString();
        }
    }

    @Override
    public String toString() {
        return message;
    }
}
