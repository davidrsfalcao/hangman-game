package communication.messages;

public class WordMessage extends Message {

    private int nr_player;

    public WordMessage(int nr_player) {
        this.nr_player = nr_player;
    }

    public WordMessage(String[] args){

        if(args.length != 2){
            this.type = ERROR;
        }
        else {
            this.type  = WORD;
            this.nr_player = Integer.parseInt(args[1]);
        }
    }

    @Override
    public String toString() {
        return WORD + SEPARATOR + nr_player + END_MESSAGE;
    }

    public int getNr_player() {
        return nr_player;
    }
}