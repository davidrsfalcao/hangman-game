package communication.messages;

import communication.Header;

public abstract class Message implements Header {

    protected String type = "NONE";


    public String getType() {
        return type;
    }

    public static Message parse(String message){

        String[] args = message.split(SEPARATOR);
        String tp;

        tp = args[0];


        switch (tp){
            case JOIN:
                return new JoinMessage(args);

            case RECONNECT:
                return new ReconnectMessage(args);

            case READY:
                return new ReadyMessage(args);

            case PLAY:
                return new PlayMessage(args);

            case WORD:
                return new WordMessage(args);

            case NEXTWORD:
                return new NextWordMessage(args);

            case SCORE:
                return new ScoreMessage(args);

            case QUIT:
                return new QuitMessage(args);


        }

        return new ErrorMessage("Invalid message");

    }
}