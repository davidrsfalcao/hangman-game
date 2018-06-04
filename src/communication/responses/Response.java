package communication.responses;

import communication.Header;

public abstract class Response implements Header {

    protected String type = "NONE";

    public String getType() {
        return type;
    }

    public static Response parse(String message){

        String[] args = message.split(SEPARATOR);
        String tp;

        tp = args[0];

        switch (tp){
            case JOIN:
                return new JoinResponse(args);

            case WORD:
                return new WordResponse(args);

            case RECONNECT:
                return new ReconnectResponse(args);

            case WAIT:
                return new WaitResponse(args);
        }

        return new ErrorResponse("Invalid response type");
    }
}