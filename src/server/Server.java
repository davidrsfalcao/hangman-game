package server;

import communication.handlers.server.Handler;
import communication.messages.Message;
import logic.GameLogic;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class Server implements Runnable {

    private String IP;
    private Socket connection;
    private int rounds = 3;
    private ConcurrentHashMap<String, Integer> players = new ConcurrentHashMap<>();
    private HashMap<Integer, GameLogic> playersLogic = new HashMap<>();
    private HashMap<Integer, String> playersUsername = new HashMap<>();
    private ServerMaintenance serverMaintenance = new ServerMaintenance();
    private ArrayList<Integer> playersFinished = new ArrayList<>();

    public Server(){
        int port = 8082;
        try {
            IP = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        try{
            ServerSocket socket1 = new ServerSocket(port);

            System.out.println("Server Initialized");
            System.out.println("IP: " + IP);
            while (true) {
                connection = socket1.accept();
                Thread thread = new Thread(this);
                thread.start();

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

    public String getIP() {
        return IP;
    }

    public ServerMaintenance getServerMaintenance() {
        return serverMaintenance;
    }

    public void addFinishedPlayer(int nrPlayer){
        if(!playersFinished.contains(nrPlayer)){
            playersFinished.add(nrPlayer);
        }
    }

    public boolean isGameFinished(){

        ArrayList<Integer> activePlayers =  serverMaintenance.getActivePlayers();

        for(int i=0; i < activePlayers.size(); i++){
            if(!playersFinished.contains(activePlayers.get(i))){
                return false;
            }
        }
        return true;
    }

    public HashMap<Integer, String> getPlayersUsername() {
        return playersUsername;
    }

    public void updatePlayersUsername(int nrPlayer, String username){

        if(playersUsername.containsValue(nrPlayer)){
            playersUsername.replace(nrPlayer, username);
        }
        else playersUsername.put(nrPlayer, username);
    }

    public ArrayList<Integer> getPlayersFinished() {
        return playersFinished;
    }

    public int getRounds() {
        return rounds;
    }
}
