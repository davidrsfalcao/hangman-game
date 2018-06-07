package communication.messages;

public class PlayMessage extends Message {
    private String input;
    private int nr_player;

    public PlayMessage(int nr_player, String input) {
        this.nr_player = nr_player;

        if(!input.equals("")){
            this.input = "" + (int) input.charAt(0);

            if(input.length() > 1){
                for(int i=1; i< input.length(); i++){
                    this.input += SEPARATOR_STRING + (int) input.charAt(i);
                }
            }

        }


    }

    public PlayMessage(String[] args){

        if(args.length != 3){
            this.type = ERROR;
        }
        else{
            nr_player = Integer.parseInt(args[1]);

            String[] chars = args[2].split(SEPARATOR_STRING);

            this.input = "";

            for(int i=0; i < chars.length; i++){
                input += (char) Integer.parseInt(chars[i]);
            }

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