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

            case 3:
               long date = System.currentTimeMillis();
                System.out.println(date);

                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                long date1 = System.currentTimeMillis();
                System.out.println((date1-date)/1000);
        }



    }

}
