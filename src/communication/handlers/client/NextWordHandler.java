package communication.handlers.client;

import cli.Client;
import communication.messages.NextWordMessage;
import communication.responses.Response;
import gui.CMDInterface;

public class NextWordHandler extends Handler {

    private int nr_player;

    NextWordHandler(Response response, Client client){
        nr_player = client.getNr_player();
        CMDInterface.nextWordInterface();
    }

    @Override
    public String toString() {
        return new NextWordMessage(nr_player).toString();
    }
}
