package communication.handlers.client;

import cli.Client;
import communication.messages.ReadyMessage;

import java.util.concurrent.TimeUnit;


public class WaitHandler extends Handler {

    private int nr_player;

    public WaitHandler(Client client){
        nr_player = client.getNr_player();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String toString(){
        return new ReadyMessage(nr_player).toString();
    }
}
