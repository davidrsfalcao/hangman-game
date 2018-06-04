package communication.handlers.client;

import cli.Client;
import communication.messages.ScoreMessage;
import gui.CMDInterface;

public class EndGameHandler extends Handler {

    private int nr_player;

    EndGameHandler(Client cli){
        cli.setFinished(true);
        nr_player = cli.getNr_player();
        CMDInterface.waitingScore();
    }

    @Override
    public String toString() {
        return new ScoreMessage(nr_player).toString();
    }
}
