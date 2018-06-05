package communication.handlers.client;

import cli.Client;
import communication.messages.ReconnectMessage;
import communication.responses.ReconnectResponse;
import communication.responses.Response;


public class ReconnectHandler extends Handler{

    private int nr_player;

    ReconnectHandler(Response response, Client cli){
        nr_player = ((ReconnectResponse) response).getNr_player();
        String username = ((ReconnectResponse) response).getUsername();
        cli.setNr_player(nr_player);
        cli.setUsername(username);
    }

    @Override
    public String toString() {
        return new ReconnectMessage(nr_player).toString();
    }
}
