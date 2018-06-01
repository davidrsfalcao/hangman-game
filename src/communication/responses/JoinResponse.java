package communication.responses;

public class JoinResponse extends  Response{

    private String result;

    public JoinResponse(String result){
        this.result = result;
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
            this.result = args[1];
        }



    }

    @Override
    public String toString() {
        return JOIN + SEPARATOR + result + END_MESSAGE;

    }

    public String getResult() {
        return result;
    }
    
}