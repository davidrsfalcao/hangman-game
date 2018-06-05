package communication.messages;

public class ReadyMessage extends Message {
    private int nr_player;
    private String username;

    public ReadyMessage(int nr_player, String username) {
        this.nr_player = nr_player;
        this.username = username;
    }

    public ReadyMessage(String[] args){

        if(args.length != 3){
            this.type = ERROR;
        }
        else{
            nr_player = Integer.parseInt(args[1]);
            username = args[2];
            this.type  = READY;
        }
    }

    @Override
    public String toString() {
        return READY + SEPARATOR + nr_player + SEPARATOR + username + END_MESSAGE;
    }

    public int getNr_player() {
        return nr_player;
    }

    public String getUsername() {
        return username;
    }
}