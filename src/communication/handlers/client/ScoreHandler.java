package communication.handlers.client;

import cli.Client;
import communication.responses.Response;

public class ScoreHandler extends Handler {

    ScoreHandler(Response response, Client cli){
        cli.setEnd(true);

        System.out.println("-----------------------");
        System.out.println(response.toString());
        System.out.println("-----------------------");

    }

    @Override
    public String toString() {
        return "QUIT" + (char) 13;
    }
}
