package communication.handlers.client;

import cli.Client;
import communication.Header;
import communication.responses.Response;

public abstract class Handler implements Header {

    public static String parse(Response response, Client cli){

        String res = "";

        switch (response.getType()){
            case JOIN:
                res = new JoinHandler(response, cli).toString();
                break;

            case RECONNECT:
                res = new ReconnectHandler(response, cli).toString();
                break;

            case WAIT:
                res = new WaitHandler(cli).toString();
                break;

            case WORD:
                res = new WordHandler(response, cli).toString();
                break;

            case NEXTWORD:
                res = new NextWordHandler(cli).toString();
                break;

            case ENDGAME:
                res = new EndGameHandler(cli).toString();
                break;

            case SCORE:
                res = new ScoreHandler(response, cli).toString();
                break;
        }

        return res;
    }

}