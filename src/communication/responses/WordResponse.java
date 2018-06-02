package communication.responses;

public class WordResponse extends  Response{

    private String word;
    private String category;
    private int tries;

    public WordResponse(String word, String category, int tries){
        this.word = word;
        this.category = category;
        this.tries = tries;
    }

    public WordResponse(String[] args){

        if(args.length != 4 ){
            this.type = ERROR;
        }
        else if(args[1] == ""){
            this.type = ERROR;
            return;
        }
        else if(args[2] == ""){
            this.type = ERROR;
            return;
        }
        else if(args[3] == ""){
            this.type = ERROR;
            return;
        }
        else{
            this.type = WORD;
            this.word = args[1];
            this.category = args[2];
            this.tries = Integer.parseInt(args[3]);
        }

    }

    @Override
    public String toString() {
        return WORD + SEPARATOR + word + SEPARATOR + category + SEPARATOR + tries + END_MESSAGE;

    }

    public String getWord() {
        return word;
    }

    public String getCategory() {
        return category;
    }

    public int getTries() {
        return tries;
    }
}