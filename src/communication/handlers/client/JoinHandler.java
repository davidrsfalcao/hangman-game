package communication.handlers.client;


import cli.Client;
import communication.messages.ReadyMessage;
import communication.responses.JoinResponse;
import communication.responses.Response;
import gui.CMDInterface;

public class JoinHandler extends Handler{

    private int nr_player;
    private String username;

    JoinHandler(Response response, Client cli){
        nr_player = ((JoinResponse) response).getNr_player();
        cli.setNr_player(nr_player);
        username = cli.getUsername();

        if(username.equals("")){
            username = CMDInterface.insertUsername();
            cli.setUsername(username);
        }

    }

    @Override
    public String toString() {
        return new ReadyMessage(nr_player, username).toString();
    }
}
