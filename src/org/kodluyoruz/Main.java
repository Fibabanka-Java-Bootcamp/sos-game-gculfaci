
import java.util.Scanner;
//import java.util.Random;


public class Main {
    

    private static String[][] updatedTable;

    public static void main(String[] args) throws Exception {
        

        Scanner scanner = new Scanner(System.in);


        System.out.println("Please enter n for a SOS Table of n X n matrix");
        System.out.println("n should be greater than 2 and lower than 8");
        System.out.print("Your choice: ");
        
        boolean whileLoop = true;
        while(whileLoop){
       
            String enteredAllValue = scanner.nextLine(); 
            //Random rd = new Random();

            if(enteredAllValue.matches("[0-9]")){
                //scanner.close();
                int enteredValue = Integer.parseInt(enteredAllValue);
                int newEnteredValue = enteredValue + 1;
                if(newEnteredValue < 9 && newEnteredValue > 3){
                    SosTable newTable = new SosTable();
                    newTable.sizeOfMatrix = newEnteredValue;
                    System.out.println("** GAME TABLE **");
                    updatedTable = newTable.createSosTable(newTable.sizeOfMatrix);
                    whileLoop = false;

                    int NumberOfMove=(enteredValue*enteredValue);

                    Player controller = new Player();
                    int turnToPlay = controller.whoStartToPlay();
                    
                    while(0 < NumberOfMove){

                        Player player = new Player();

                        int PlayerCoordinateX = player.playerMoveX(turnToPlay,enteredValue);
                        int PlayerCoordinateY = player.playerMoveY(turnToPlay,enteredValue);
                        
                        String selectedLetterFromComputer = controller.selectLetter(turnToPlay);
                       
                        /* COMPUTER PLAYING
                        String abc = "SO";

                        char letter = abc.charAt(rd.nextInt(abc.length()));
                        String selectedOneOfOandS = String.valueOf(letter);*/

                        if(  (0 < PlayerCoordinateX) && (PlayerCoordinateX < newEnteredValue) &&
                             (0 < PlayerCoordinateY) && (PlayerCoordinateY < newEnteredValue) ){
                            updatedTable[PlayerCoordinateX][PlayerCoordinateY]= selectedLetterFromComputer;
                            updateTable(updatedTable,newEnteredValue);

                        }
                        else System.out.println("HATALI GİRDİN TEKRAR KOORDİNAT GİR");

                        
                        NumberOfMove--;
                    }
                    

                    System.out.println( updatedTable.getClass());
                }
                
                else  System.out.print("WARNING! TRY TO CHOOSE ONE OF 3-4-5-6-7 :");
            
            }
            else{
                
                System.out.print("WARNING! TRY TO CHOOSE ONE OF 3-4-5-6-7 :");

                
            } 

         
        }
             
    }

    public static void updateTable(String[][] tableName, int sizeOfTable){
        System.out.println("** NEW TABLE **");  
        int x,y;
        for(x=0; x<sizeOfTable; x++){
            for(y=0; y<sizeOfTable; y++){
                  
                System.out.print( tableName[x][y] + " ");
            }

            System.out.println();
           
        }
        
              
    }

    
}
