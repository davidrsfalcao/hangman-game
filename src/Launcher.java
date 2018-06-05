import cli.Client;
import server.Server;

import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Launcher {

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        System.out.println("TESTE:\n1. Server\n2. Client");

        int i = scan.nextInt();

        switch (i){
            case 1:
                new Server();
                break;

            case 2:
                //new Client();
                System.out.print("IP: ");
                Scanner scanner = new Scanner(System.in);
                String ip = scanner.nextLine();
                new Client(ip);
                break;

            default:
                break;
        }



    }

}
