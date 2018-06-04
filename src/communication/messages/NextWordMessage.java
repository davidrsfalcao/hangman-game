package communication.messages;

public class NextWordMessage extends Message{

    private int nr_player;

    public NextWordMessage(int nr_player) {
        this.nr_player = nr_player;
    }

    NextWordMessage(String[] args){

        if(args.length != 2){
            this.type = ERROR;
        }
        else{
            nr_player = Integer.parseInt(args[1]);
            this.type  = NEXTWORD;

        }
    }

    @Override
    public String toString() {
        return NEXTWORD + SEPARATOR + nr_player + END_MESSAGE;
    }

    public int getNr_player() {
        return nr_player;
    }
}
