import java.util.Scanner;


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

                    System.out.println(" ");
                    System.out.println("** GAME TABLE **");
                    updatedTable = newTable.createSosTable(newTable.sizeOfMatrix);
                    whileLoop = false;

                    int NumberOfMove=(enteredValue*enteredValue);

                    Player controller = new Player();
                    Player player = new Player();
                    int turnToPlay = controller.whoStartToPlay();
                    
                    while(0 < NumberOfMove){

                        
                        if (turnToPlay == 1){
                            System.out.println("Your Turn");
                            int PlayerCoordinateX = player.playerMoveX(turnToPlay,enteredValue);
                            int PlayerCoordinateY = player.playerMoveY(turnToPlay,enteredValue);

                        
                            String selectedLetter = controller.selectLetter(turnToPlay);

                            if(  (0 < PlayerCoordinateX) && (PlayerCoordinateX < newEnteredValue) && (0 < PlayerCoordinateY) && (PlayerCoordinateY < newEnteredValue) && (selectedLetter.matches("[S,s,O,o]")) ){
                                
                                if(updatedTable[PlayerCoordinateX][PlayerCoordinateY] == "-"){
                                    updatedTable[PlayerCoordinateX][PlayerCoordinateY]= selectedLetter;
                                    SosTable.updateTable (updatedTable,newEnteredValue);
                                    System.out.println(" ");
                                    NumberOfMove--;
                                    turnToPlay = 2;
                                }
                                else{
                                    System.out.println("WARNING! Selected coordinates are full. Please try to select empty coordinates");
                                    System.out.println(" ");

                                }

                                

                            }
                            else if( ( (0 < PlayerCoordinateX) && (PlayerCoordinateX < newEnteredValue) && (0 < PlayerCoordinateY) && (PlayerCoordinateY < newEnteredValue) ) && !(selectedLetter.matches("[S,s,O,o]"))){

                                System.out.println("WARNING! Please try to enter just S or O");
                                System.out.println(" ");
                            }

                            else if( !( (0 < PlayerCoordinateX) && (PlayerCoordinateX < newEnteredValue) && (0 < PlayerCoordinateY) && (PlayerCoordinateY < newEnteredValue) ) && (selectedLetter.matches("[S,s,O,o]"))){

                                System.out.println("WARNING! Please enter a value between 1 and "+ enteredValue+ " for row and column");
                                System.out.println(" ");
                            }

                            else{
                                System.out.println("Both the entered coordinates and the character are incorrect. Please try again.");
                                System.out.println(" ");

                            }

                        }

                        if(turnToPlay == 2){
                            System.out.println("Computer Turn");
                            int PlayerCoordinateX = player.playerMoveX(turnToPlay,enteredValue);
                            int PlayerCoordinateY = player.playerMoveY(turnToPlay,enteredValue);

                            if(updatedTable[PlayerCoordinateX][PlayerCoordinateY] == "-"){
                                
                                String selectedLetterFromComputer = controller.selectLetter(turnToPlay);
                                updatedTable[PlayerCoordinateX][PlayerCoordinateY]= selectedLetterFromComputer;
                                SosTable.updateTable (updatedTable,newEnteredValue);
                                System.out.println(" ");
                                NumberOfMove--;
                                turnToPlay = 1;

                            }
                            else{
                                System.out.println("Computer searching empty coordinates ...");
                                System.out.println(" ");

                            }
                            
                        
                            



                            

  

                        }
                        

                    }
                
                }
                
                else{
                    System.out.print("WARNING! TRY TO CHOOSE ONE OF 3-4-5-6-7 :");

                }  
            
            }
            else{
                
                System.out.print("WARNING! TRY TO CHOOSE ONE OF 3-4-5-6-7 :");

                
            } 

         
        }
             
    }

    
}
