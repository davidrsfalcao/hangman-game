package communication.messages;


public class ReconnectMessage extends Message {
    private int nr_player;

    public ReconnectMessage(int nr_player) {
        this.nr_player = nr_player;
    }

    public ReconnectMessage(String[] args){

        if(args.length != 2){
            this.type = ERROR;
        }
        else{
            nr_player = Integer.parseInt(args[1]);
            this.type  = RECONNECT;

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