package communication.handlers.server;

import communication.responses.JoinResponse;

public class JoinHandler extends Handler {

    private String result;

    public JoinHandler(){
        this.result = SUCCESS;
    }

    @Override
    public String toString(){
        return new JoinResponse(result).toString();
    }

}
