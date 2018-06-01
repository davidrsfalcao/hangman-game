package cli;

import database.Word;
import logic.GameLogic;

import java.util.Scanner;

public class Cli {

    private GameLogic logic;

    public Cli(){
        super();
    }

    public void startGame(){
        logic = new GameLogic();
        play();

    }

    public void play(){

        Scanner scan = new Scanner(System.in);
        String line = "";
        char letter;

        logic.getNewWord();
        while(!logic.isGameEnded()){
            printWord(logic.getActualWord());
            System.out.print("Try " + (logic.getActualWord().getNrTries() +1 ) + ": ");
            line = scan.nextLine();
            letter = line.charAt(0);
            logic.getActualWord().testLetter(letter);
            if(logic.checkChangeWord()){
                System.out.println("NOVA PALAVRA");
                logic.getNewWord();
            }
        }


    }

    private void printWord(Word word){

        System.out.println("Categoria: "+ word.getCategory() + "\n");

        for(int i=0; i< word.toString().length(); i++){
            System.out.print(word.toString().charAt(i) + " ");
        }

        System.out.println("\n");

    }


    private void clearScreen(){
        for (int i=0; i<20; i++){
            System.out.println("\n");
        }
    }

}
