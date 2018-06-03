package communication.handlers.server;

import communication.messages.Message;
import communication.messages.PlayMessage;
import communication.responses.WordResponse;
import database.Word;
import logic.GameLogic;
import server.Server;


public class PlayHandler extends  Handler{
    private String message;

    public PlayHandler(Message message, Server server){

        int nr_player = ((PlayMessage) message).getNr_player();
        String input = ((PlayMessage) message).getInput();
        GameLogic playerLogic = server.getPlayersLogic().get(nr_player);

        Word word = playerLogic.getActualWord();
        String newWord = "";

        if(input.length() > 1){
            newWord = word.testWord(input);
        }
        else newWord = word.testLetter(input.charAt(0));

        this.message = new WordResponse(newWord, playerLogic.getActualWord().getCategory().toString(), playerLogic.getNrTries()).toString();
    }

    @Override
    public String toString(){
        return message;
    }

}
