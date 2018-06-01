package communication.messages;

public class WordMessage extends Message {

    public WordMessage() {
    }

    public WordMessage(String[] args){

        if(args.length != 1){
            this.type = ERROR;
        }
        else this.type  = WORD;
    }

    @Override
    public String toString() {
        return WORD + END_MESSAGE;
    }

}