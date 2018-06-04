package communication.handlers.client;


import cli.Client;
import communication.messages.ReadyMessage;
import communication.responses.JoinResponse;
import communication.responses.Response;

public class JoinHandler extends Handler{

    private int nr_player;

    JoinHandler(Response response, Client cli){
        nr_player = ((JoinResponse) response).getNr_player();
        cli.setNr_player(nr_player);

    }

    @Override
    public String toString() {
        return new ReadyMessage(nr_player).toString();
    }
}
