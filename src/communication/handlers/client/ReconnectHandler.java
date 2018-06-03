package communication.handlers.client;

import cli.Client;
import communication.messages.WordMessage;
import communication.responses.ReconnectResponse;
import communication.responses.Response;


public class ReconnectHandler extends Handler{

    private int nr_player;

    public ReconnectHandler(Response response, Client cli){
        nr_player = ((ReconnectResponse) response).getNr_player();
        cli.setNr_player(nr_player);

    }

    @Override
    public String toString() {
        return new WordMessage(nr_player).toString();
    }
}
