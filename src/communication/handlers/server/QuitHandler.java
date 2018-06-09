package communication.handlers.server;


import communication.responses.QuitResponse;

public class QuitHandler extends Handler {


    QuitHandler() {

    }

    @Override
    public String toString() {
        return new QuitResponse().toString();
    }
}