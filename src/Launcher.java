import cli.Cli;
import cli.Client;
import jdk.nashorn.internal.runtime.regexp.joni.ScanEnvironment;
import server.Server;

import java.util.Scanner;

public class Launcher {

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        System.out.println("TESTE:\n1. Server\n2. Client");

        int i = scan.nextInt();

        switch (i){
            case 1:
                Server.getInstance();
                break;

            case 2:
                //new Client();
                System.out.print("IP: ");
                Scanner scanner = new Scanner(System.in);
                String ip = scanner.nextLine();
                new Client(ip);
                break;
        }



    }

}
