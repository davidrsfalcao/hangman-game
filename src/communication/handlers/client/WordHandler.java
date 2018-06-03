package communication.handlers.client;

import cli.Client;
import communication.handlers.server.Handler;
import communication.messages.PlayMessage;
import communication.messages.WordMessage;
import communication.responses.JoinResponse;
import communication.responses.Response;
import communication.responses.WordResponse;
import gui.CMDInterface;

public class WordHandler extends Handler {

    private String word;
    private String category;
    private int tries;
    private String input;
    private int nr_player;

    public WordHandler(Response response, Client client){
        nr_player = client.getNr_player();
        word = ((WordResponse) response).getWord();
        category = ((WordResponse) response).getCategory();
        tries = ((WordResponse) response).getTries();
        input = CMDInterface.playInterface(word, category, tries);
    }

    @Override
    public String toString() {
        return new PlayMessage(nr_player, input).toString();
    }
}
