package communication.responses;

public class WordResponse extends  Response{

    private String word;
    private String category;
    private int tries;

    public WordResponse(String word, String category, int tries){
        this.category = category;
        this.tries = tries;

        this.word = "" + (int) word.charAt(0);

        if(word.length() > 1){
            for(int i=1; i< word.length(); i++){
                this.word += SEPARATOR_STRING + (int) word.charAt(i);
            }
        }

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
            this.category = args[2];
            this.tries = Integer.parseInt(args[3]);

            String[] chars = args[1].split(SEPARATOR_STRING);
            this.word = "";

            for(int i=0; i < chars.length; i++){
                this.word += (char) Integer.parseInt(chars[i]);
            }

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