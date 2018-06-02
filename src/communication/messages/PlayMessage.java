package communication.messages;

public class PlayMessage extends Message {
    private String input;

    public PlayMessage(String input) {
        this.input = input;
    }

    public PlayMessage(String[] args){

        if(args.length != 2){
            this.type = ERROR;
        }
        else{
            input = args[1];
            this.type  = PLAY;

        }

    }

    @Override
    public String toString() {
        return PLAY + SEPARATOR + input + END_MESSAGE;
    }

    public String getInput() {
        return input;
    }
}