package communication;

public interface Header {
    String SEPARATOR = "!@!";
    char END_MESSAGE = (char) 13;

    String ERROR = "ERROR";
    String JOIN = "JOIN";
    String RECONNECT = "RECONNECT";
    String WORD = "WORD";
    String PLAY = "PLAY";

    String LOGIN = "LOGIN";
    String REGISTER = "REGISTER";
    String LISTROOMS = "LISTROOMS";

    String CREATEROOM = "CREATEROOM";




    String SUCCESS = "SUCCESS";
    String FAILURE = "FAILURE";
}