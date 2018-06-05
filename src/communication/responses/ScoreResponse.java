package communication.responses;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ScoreResponse extends  Response{

    private HashMap<String, Integer> scores;

    public ScoreResponse(HashMap<String, Integer> scores){
        this.scores = scores;
    }

    ScoreResponse(String[] args){
        int i = 1;

        if((args.length) % 2 != 1){
            this.type = ERROR;
        }
        else while(i < args.length){
            scores.put(args[i], Integer.parseInt(args[i+1]));
            i+=2;
        }
    }

    @Override
    public String toString() {
        String message = SCORE;

        Iterator it = scores.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            message += (SEPARATOR + pair.getKey() + SEPARATOR + pair.getValue());
        }

        message += END_MESSAGE;

        return message;
    }



}