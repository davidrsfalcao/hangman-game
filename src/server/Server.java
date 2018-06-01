package server;

import communication.handlers.server.Handler;
import communication.messages.Message;

import java.net.*;
import java.io.*;
import java.util.*;

public class Server implements Runnable {

    private static Server instance = new Server();
    private Socket connection;
    private int ID;
    private int count = 0;
    private ArrayList<Thread> threads = new ArrayList<Thread>();

    private Server(){
        int port = 8082;
        try{
            ServerSocket socket1 = new ServerSocket(port);
            System.out.println("Server Initialized");
            while (true) {
                Socket connection = socket1.accept();
                Runnable runnable = new Server(connection, ++count);
                threads.add(new Thread(runnable));
                threads.get(threads.size()-1).start();

            }
        }
        catch (Exception e) {}

    }

    private Server(Socket s, int i) {
        this.connection = s;
        this.ID = i;
    }

    public void run() {
        try {
            BufferedInputStream is = new BufferedInputStream(connection.getInputStream());
            InputStreamReader isr = new InputStreamReader(is);
            int character;
            StringBuffer process = new StringBuffer();
            while((character = isr.read()) != 13) {
                process.append((char)character);
            }
            System.out.println(process);

            String returnCode = Handler.parse(Message.parse(process.toString()));
            BufferedOutputStream os = new BufferedOutputStream(connection.getOutputStream());
            OutputStreamWriter osw = new OutputStreamWriter(os, "US-ASCII");
            osw.write(returnCode);
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

    public static Server getInstance() {
        return instance;
    }
}
