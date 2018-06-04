package communication.handlers.server;

import communication.messages.Message;
import communication.messages.PlayMessage;
import communication.responses.NextWordResponse;
import communication.responses.WordResponse;
import database.Word;
import logic.GameLogic;
import server.Server;


public class PlayHandler extends Handler{
    private String message;

    PlayHandler(Message message, Server server){

        int nr_player = ((PlayMessage) message).getNr_player();
        String input = ((PlayMessage) message).getInput();
        GameLogic playerLogic = server.getPlayersLogic().get(nr_player);

        Word word = playerLogic.getActualWord();
        String newWord;

        if(input.length() > 1){
            newWord = word.testWord(input);
        }
        else if(input.length() == 1){
            newWord = word.testLetter(input.charAt(0));
        }
        else newWord = playerLogic.getActualWord().toString();

        if(playerLogic.checkChangeWord()){
            this.message = new NextWordResponse().toString();
        }
        else this.message = new WordResponse(newWord, playerLogic.getActualWord().getCategory().toString(), playerLogic.getNrTries()).toString();
    }

    @Override
    public String toString(){
        return message;
    }

}
