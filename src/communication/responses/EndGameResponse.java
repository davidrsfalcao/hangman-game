package communication.responses;

public class EndGameResponse extends Response {

    public EndGameResponse(){

    }

    EndGameResponse(String[] args){

        if(args.length != 1 ){
            this.type = ERROR;
        }
        else{
            this.type = ENDGAME;
        }

    }

    @Override
    public String toString() {
        return ENDGAME + END_MESSAGE;

    }

}
