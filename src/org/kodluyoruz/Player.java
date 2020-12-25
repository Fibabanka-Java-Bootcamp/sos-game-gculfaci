package Sos;

import java.util.Scanner;
import java.util.Random;

public class Player {
    int point;
    int numberOfPlayer;
    
    Scanner scanner = new Scanner(System.in);
    Random rd = new Random();

    public int playerMoveX(int turnOfPlayer, int enteredValue){

        if(turnOfPlayer==1){

            System.out.println("Please enter row number: ");
            String PlayerMoveX = scanner.nextLine();
            int PlayerCoordinateX = Integer.parseInt(PlayerMoveX);
            return PlayerCoordinateX;
        }
        else{
            System.out.println("Computer selected row number");
            //Random randomRow = new Random();
            int PlayerCoordinateX = rd.nextInt(enteredValue)+1;
            return PlayerCoordinateX;
        }
        
    }

    public int playerMoveY(int turnOfPlayer, int enteredValue){
        if(turnOfPlayer==1){

            System.out.println("Please enter column number:  ");
            String PlayerMoveY = scanner.nextLine();
            int PlayerCoordinateY = Integer.parseInt(PlayerMoveY);
            return PlayerCoordinateY;
        }
        else{
            System.out.println("Computer selected column ");
            //Random randomColumn = new Random();
            int PlayerCoordinateY = rd.nextInt(enteredValue)+1;
            return PlayerCoordinateY;

        }
        
    }

    public int whoStartToPlay(){

        int turnNumber;
        Random randomDice = new Random();
		int dice1 = randomDice.nextInt(6)+1;
        int dice2 = randomDice.nextInt(6)+1;
        System.out.println("THE DICE ARE ROLLED ... ");

        if(dice1>= dice2){

            turnNumber = 1;
            System.out.println("YOU WON. IT IS YOUR TURN TO PLAY");
            return turnNumber;
        } 
        
        else{
            System.out.println("YOU LOST. IT IS COMPUTER TURN TO PLAY");
            turnNumber = 1;
            return turnNumber;
        } 

        
        
    }

    public String selectLetter(int turnOfPlayer){
        if(turnOfPlayer==1){

            System.out.println("Please select one of S or O: ");  
            String selectedLetter = scanner.nextLine();
            return selectedLetter;

        }
        else{
            System.out.println("Computer selected column ");
            String abc = "SO";

            char letter = abc.charAt(rd.nextInt(abc.length()));
            String selectedLetter = String.valueOf(letter);
            return selectedLetter;

        }

    }

    
}
