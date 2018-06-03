package server;

import communication.handlers.server.Handler;
import communication.messages.Message;
import logic.GameLogic;

import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class Server implements Runnable {

    private Socket connection;
    private ConcurrentHashMap<String, Integer> players = new ConcurrentHashMap<>();
    private HashMap<Integer, GameLogic> playersLogic = new HashMap<>();
    private ArrayList<Thread> threads = new ArrayList<>();

    public Server(){
        int port = 8082;
        try {
            System.out.println("IP:" + InetAddress.getLocalHost().getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        try{
            ServerSocket socket1 = new ServerSocket(port);

            System.out.println("Server Initialized");
            while (true) {
                connection = socket1.accept();
                Runnable runnable = this;
                threads.add(new Thread(runnable));
                threads.get(threads.size()-1).start();

            }
        }
        catch (Exception e) {}

    }


    public void run() {
        try {
            BufferedInputStream is = new BufferedInputStream(connection.getInputStream());
            InputStreamReader isr = new InputStreamReader(is);
            int character;
            StringBuffer message = new StringBuffer();
            while((character = isr.read()) != 13) {
                message.append((char)character);
            }
            System.out.println("RECEIVE: "+ message);

            String response = Handler.parse(Message.parse(message.toString()), this);
            BufferedOutputStream os = new BufferedOutputStream(connection.getOutputStream());
            OutputStreamWriter osw = new OutputStreamWriter(os, "US-ASCII");
            osw.write(response);
            System.out.println("SEND: "+ response);
            System.out.println();
            osw.flush();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        finally {
            try {
                connection.close();
            }
            catch (IOException e){}
        }
    }



    public ConcurrentHashMap<String, Integer> getPlayers() {
        return players;
    }

    public HashMap<Integer, GameLogic> getPlayersLogic() {
        return playersLogic;
    }
}
