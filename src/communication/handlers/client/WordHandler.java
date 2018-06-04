package communication.handlers.client;

import cli.Client;
import communication.handlers.server.Handler;
import communication.messages.PlayMessage;
import communication.responses.Response;
import communication.responses.WordResponse;
import gui.CMDInterface;

public class WordHandler extends Handler {

    private String input;
    private int nr_player;

    WordHandler(Response response, Client client){
        nr_player = client.getNr_player();
        String word = ((WordResponse) response).getWord();
        String category = ((WordResponse) response).getCategory();
        int tries = ((WordResponse) response).getTries();
        input = CMDInterface.playInterface(word, category, tries);
    }

    @Override
    public String toString() {
        return new PlayMessage(nr_player, input).toString();
    }
}
