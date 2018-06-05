package communication.responses;

public class ReconnectResponse extends  Response{

    private int nr_player;
    private String username;

    public ReconnectResponse(int nr_player, String username){
        this.nr_player = nr_player;
        this.username = username;
    }

    public ReconnectResponse(String[] args){

        if(args.length != 3 ){
            this.type = ERROR;
        }
        else if(args[1] == ""){
            this.type = ERROR;
            return;
        }
        else{
            this.type = RECONNECT;
            this.nr_player = Integer.parseInt(args[1]);
            this.username = args[1];
        }

    }

    @Override
    public String toString() {
        return RECONNECT + SEPARATOR + nr_player + SEPARATOR + username + END_MESSAGE;

    }

    public int getNr_player() {
        return nr_player;
    }

    public String getUsername() {
        return username;
    }
}