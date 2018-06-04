package communication.messages;

public class ScoreMessage extends Message{

    private int nr_player;

    public ScoreMessage(int nr_player) {
        this.nr_player = nr_player;
    }

    ScoreMessage(String[] args){

        if(args.length != 2){
            this.type = ERROR;
        }
        else{
            nr_player = Integer.parseInt(args[1]);
            this.type  = SCORE;
        }
    }

    @Override
    public String toString() {
        return SCORE + SEPARATOR + nr_player + END_MESSAGE;
    }

    public int getNr_player() {
        return nr_player;
    }

}
