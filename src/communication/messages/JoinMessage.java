package communication.messages;

public class JoinMessage extends Message {

    public JoinMessage() {
    }

    public JoinMessage(String[] args){

        if(args.length != 1){
            this.type = ERROR;
        }
        else this.type  = JOIN;
    }

    @Override
    public String toString() {
        return JOIN + END_MESSAGE;
    }

}