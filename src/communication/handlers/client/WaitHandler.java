package communication.handlers.client;

import cli.Client;
import communication.messages.ReadyMessage;
import communication.messages.ScoreMessage;

import java.util.concurrent.TimeUnit;


public class WaitHandler extends Handler {

    private String message;

    WaitHandler(Client client){
        int nr_player = client.getNr_player();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(client.isFinished()){
            message = new ScoreMessage(nr_player).toString();
        }
        else message = new ReadyMessage(nr_player).toString();

    }

    @Override
    public String toString(){
        return message;
    }
}
