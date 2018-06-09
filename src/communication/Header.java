package communication;

public interface Header {
    String SEPARATOR = "!@!";
    String SEPARATOR_STRING = "###";
    char END_MESSAGE = (char) 13;

    String ERROR = "ERROR";
    String JOIN = "JOIN";
    String RECONNECT = "RECONNECT";
    String READY = "READY";
    String WAIT = "WAIT";
    String PLAY = "PLAY";
    String WORD = "WORD";
    String NEXTWORD = "NEXTWORD";
    String ENDGAME = "ENDGAME";
    String SCORE = "SCORE";
    String QUIT = "QUIT";
    String OK = "OK";

}