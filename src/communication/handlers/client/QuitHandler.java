package communication.handlers.client;

import cli.Client;

public class QuitHandler extends Handler {

    QuitHandler(Client cli){
        cli.setEnd(true);
    }

    @Override
    public String toString() {
        return "BYE" + (char) 13;
    }
}
