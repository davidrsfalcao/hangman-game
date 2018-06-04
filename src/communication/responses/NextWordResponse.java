package communication.responses;

public class NextWordResponse extends Response {

    public NextWordResponse(){

    }

    NextWordResponse(String[] args){
        if(args.length != 1 ){
            this.type = ERROR;
        }
        else{
            this.type = NEXTWORD;
        }
    }

    @Override
    public String toString() {
        return NEXTWORD + END_MESSAGE;
    }
}
