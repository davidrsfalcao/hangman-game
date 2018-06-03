package communication.messages;

public class PlayMessage extends Message {
    private String input;
    private int nr_player;

    public PlayMessage(int nr_player,String input) {
        this.input = input;
        this.nr_player = nr_player;
    }

    public PlayMessage(String[] args){

        if(args.length != 3){
            this.type = ERROR;
        }
        else{
            nr_player = Integer.parseInt(args[1]);
            input = args[2];
            this.type  = PLAY;


        }
    }

    @Override
    public String toString() {
        return PLAY + SEPARATOR + nr_player + SEPARATOR + input + END_MESSAGE;
    }

    public String getInput() {
        return input;
    }

    public int getNr_player() {
        return nr_player;
    }
}