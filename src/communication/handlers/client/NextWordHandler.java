package communication.handlers.client;

import cli.Client;
import communication.messages.NextWordMessage;
import gui.CMDInterface;

public class NextWordHandler extends Handler {

    private int nr_player;

    NextWordHandler(Client client){
        nr_player = client.getNr_player();
        CMDInterface.nextWordInterface();
    }

    @Override
    public String toString() {
        return new NextWordMessage(nr_player).toString();
    }
}
