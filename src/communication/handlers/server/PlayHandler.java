package communication.handlers.server;

import communication.messages.Message;
import communication.messages.PlayMessage;
import communication.responses.WordResponse;
import database.Word;
import logic.GameLogic;


public class PlayHandler extends  Handler{
    private String message;

    public PlayHandler(Message message, GameLogic logic){

        String input = ((PlayMessage) message).getInput();
        Word word = logic.getActualWord();
        String newWord = "";

        if(input.length() > 1){
            newWord = word.testWord(input);
        }
        else newWord = word.testLetter(input.charAt(0));



        this.message = new WordResponse(newWord, logic.getActualWord().getCategory().toString(), logic.getNrTries()).toString();
    }

    @Override
    public String toString(){
        return message;
    }

}
