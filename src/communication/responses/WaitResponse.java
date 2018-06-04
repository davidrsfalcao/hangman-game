package communication.responses;

public class WaitResponse extends Response {

    public WaitResponse(){
    }

    public WaitResponse(String[] args){

        if(args.length != 1 ){
            this.type = ERROR;
        }
        else this.type = WAIT;

    }

    @Override
    public String toString() {
        return WAIT + END_MESSAGE;

    }

}
