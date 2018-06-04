package gui;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class CMDInterface {

    public static String playInterface(String word, String category, int tries){
        clearScreen();
        System.out.println("Categoria: " + category);
        System.out.println("Word: " + word);
        System.out.println();
        System.out.print("Try nr " + (tries+1) + ": ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static void nextWordInterface(){
        clearScreen();
        System.out.println("Word completed");
        System.out.println("\n\n");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void clearScreen(){
        for (int i=0; i<40; i++){
            System.out.println();
        }
    }

}
