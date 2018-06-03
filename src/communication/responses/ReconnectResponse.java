package communication.responses;

public class ReconnectResponse extends  Response{

    private int nr_player;

    public ReconnectResponse(int nr_player){
        this.nr_player = nr_player;
    }

    public ReconnectResponse(String[] args){

        if(args.length != 2 ){
            this.type = ERROR;
        }
        else if(args[1] == ""){
            this.type = ERROR;
            return;
        }
        else{
            this.type = RECONNECT;
            this.nr_player = Integer.parseInt(args[1]);
        }

    }

    @Override
    public String toString() {
        return RECONNECT + SEPARATOR + nr_player + END_MESSAGE;

    }

    public int getNr_player() {
        return nr_player;
    }


}