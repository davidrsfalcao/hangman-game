package communication.messages;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class JoinMessage extends Message {

    private String ip;

    public JoinMessage() {
        try {
            ip = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    public JoinMessage(String[] args){

        if(args.length != 2){
            this.type = ERROR;
        }
        else if(args[1].equals("")){
            this.type = ERROR;
        }
        else {
            this.type  = JOIN;
            this.ip = args[1];
        }

    }

    @Override
    public String toString() {
        return JOIN + SEPARATOR + ip + END_MESSAGE;
    }

    public String getIp() {
        return ip;
    }
}