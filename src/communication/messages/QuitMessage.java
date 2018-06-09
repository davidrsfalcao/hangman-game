package communication.messages;

public class QuitMessage extends Message {

    public QuitMessage() {

    }

    public QuitMessage(String[] args){

        if(args.length != 1){
            this.type = ERROR;
        }
        else this.type = QUIT;
    }

    @Override
    public String toString() {
        return QUIT + END_MESSAGE;
    }


}