package cli;

import communication.handlers.client.Handler;
import communication.messages.JoinMessage;
import communication.responses.JoinResponse;
import communication.responses.Response;

import java.net.*;
import java.io.*;


public class Client implements Runnable {

    private Thread thread;
    private String host = "localhost";
    private int port = 8082;
    private int nr_player;
    private boolean finished = false;


    public Client() {

        Runnable runnable = this;
        thread = new Thread(runnable);
        thread.start();

        System.out.println("SocketClient initialized");


    }

    public Client(String ip) {
        this.host = ip;
        Runnable runnable = this;
        thread = new Thread(runnable);
        thread.start();

        System.out.println("SocketClient initialized");

    }

    @Override
    public void run() {
        StringBuffer response = new StringBuffer();
        Socket connection = null;
        boolean end = false;

        String message = new JoinMessage().toString();

        while(!end){
            try {
                InetAddress address = InetAddress.getByName(host);
                connection = new Socket(address, port);

                /* Enviar mensagem */
                BufferedOutputStream bos = new BufferedOutputStream(connection.getOutputStream());
                OutputStreamWriter osw = new OutputStreamWriter(bos, "US-ASCII");

                osw.write(message);
                osw.flush();

                /* Resceber resposta */
                BufferedInputStream bis = new BufferedInputStream(connection.getInputStream());
                InputStreamReader isr = new InputStreamReader(bis, "US-ASCII");

                /**Read the socket's InputStream and append to a StringBuffer */
                int c;
                response = new StringBuffer();
                while ( (c = isr.read()) != 13)
                    response.append( (char) c);


                System.out.println("RECEIVE: "+response);
                message = Handler.parse(Response.parse(response.toString()), this);
                System.out.println("SEND: "+message);
            }
            catch (IOException f) {
                System.out.println("IOException: " + f);
            }
            catch (Exception g) {
                System.out.println("Exception: " + g);
            }

        }

        /** Close the socket connection. */
        try {
            connection.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getNr_player() {
        return nr_player;
    }

    public void setNr_player(int nr_player) {
        this.nr_player = nr_player;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }
}
