package communication.responses;

public class QuitResponse extends Response {

    public QuitResponse() {

    }

     QuitResponse(String[] args){

        if(args.length != 2){
            this.type = ERROR;
        }
        else this.type = QUIT;
    }

    @Override
    public String toString() {
        return QUIT + SEPARATOR + OK + END_MESSAGE;
    }
}
