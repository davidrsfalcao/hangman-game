package communication.messages;

public class ReadyMessage extends Message {
    private int nr_player;

    public ReadyMessage(int nr_player) {
        this.nr_player = nr_player;
    }

    public ReadyMessage(String[] args){

        if(args.length != 2){
            this.type = ERROR;
        }
        else{
            nr_player = Integer.parseInt(args[1]);
            this.type  = READY;
        }
    }

    @Override
    public String toString() {
        return READY + SEPARATOR + nr_player + END_MESSAGE;
    }

    public int getNr_player() {
        return nr_player;
    }
}