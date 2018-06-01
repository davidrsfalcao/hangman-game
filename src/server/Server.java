package server;

import java.net.*;
import java.io.*;
import java.util.*;

public class Server implements Runnable {

    private Socket connection;
    private int ID;

    public static void main(String[] args) {
        int port = 8082;
        int count = 0;
        try{
            ServerSocket socket1 = new ServerSocket(port);
            System.out.println("Server Initialized");
            while (true) {
                Socket connection = socket1.accept();
                Runnable runnable = new Server(connection, ++count);
                Thread thread = new Thread(runnable);
                thread.start();
            }
        }
        catch (Exception e) {}
    }
    Server(Socket s, int i) {
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

            String returnCode = "Hello David" + (char) 13;
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
}
