package communication.responses;

public class JoinResponse extends  Response{

    private int nr_player;

    public JoinResponse(int nr_player){
        this.nr_player = nr_player;
    }

    public JoinResponse(String[] args){

        if(args.length != 2 ){
            this.type = ERROR;
        }
        else if(args[1] == ""){
            this.type = ERROR;
            return;
        }
        else{
            this.type = JOIN;
            this.nr_player = Integer.parseInt(args[1]);
        }

    }

    @Override
    public String toString() {
        return JOIN + SEPARATOR + nr_player + END_MESSAGE;

    }

    public int getNr_player() {
        return nr_player;
    }

    
}