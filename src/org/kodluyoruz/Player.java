import java.util.Scanner;
import java.util.Random;

public class Player {
    int point;
    int numberOfPlayer;
    
    Scanner scanner = new Scanner(System.in);
    Random rd = new Random();

    public int playerMoveX(int turnOfPlayer, int enteredValue){

        if(turnOfPlayer==1){
            System.out.print("Please enter row number: ");
            String PlayerMoveX = scanner.nextLine();
            int PlayerCoordinateX = Integer.parseInt(PlayerMoveX);
            return PlayerCoordinateX;
  
        }
        else{
            
            int PlayerCoordinateX = rd.nextInt(enteredValue)+1;
            System.out.println("Computer selected row number: "+ PlayerCoordinateX);
            return PlayerCoordinateX;
        }
        
    }

    public int playerMoveY(int turnOfPlayer, int enteredValue){
        if(turnOfPlayer==1){
            System.out.print("Please enter column number:  ");
            String PlayerMoveY = scanner.nextLine();
            int PlayerCoordinateY = Integer.parseInt(PlayerMoveY);
            return PlayerCoordinateY;
        }
        else{
            
            int PlayerCoordinateY = rd.nextInt(enteredValue)+1;
            System.out.println("Computer selected column number: "+ PlayerCoordinateY);
            return PlayerCoordinateY;

        }
        
    }

    public int whoStartToPlay(){

        int turnNumber;
        Random randomDice = new Random();
		int dice1 = randomDice.nextInt(6)+1;
        int dice2 = randomDice.nextInt(6)+1;
        System.out.println(" ");
        System.out.println("THE DICE ARE ROLLED ... ");

        if(dice1 > dice2){

            System.out.println("YOU "+ dice1 +" - " + dice2 + " COMPUTER");
            System.out.println("YOU WON");
            System.out.println(" ");
            turnNumber = 1;
            return turnNumber;
        }
        else if(dice1 == dice2){

            System.out.println("YOU "+ dice1 +" - " + dice2 + " COMPUTER");
            System.out.println("DRAW. THE COMPUTER LET YOU TO START GAME ");
            System.out.println(" ");
            turnNumber = 1;
            return turnNumber;


        } 
        
        else{
            System.out.println("YOU "+ dice1 +" - " + dice2 + " COMPUTER");
            System.out.println("YOU LOST");
            System.out.println(" ");
            turnNumber = 2;
            return turnNumber;
        } 

        
        
    }

    public String selectLetter(int turnOfPlayer){
        if(turnOfPlayer==1){

            System.out.print("Please select one of S or O: ");  
            String selectedLetter = scanner.nextLine();
            System.out.println(" ");
            selectedLetter = selectedLetter.toUpperCase();
            return selectedLetter;

        }
        else{
            
            String abc = "SO";

            char letter = abc.charAt(rd.nextInt(abc.length()));
            String selectedLetter = String.valueOf(letter);
            System.out.println("Computer selected "+ selectedLetter);
            System.out.println(" ");
            return selectedLetter;

        }

    }
    
}
