import java.util.Scanner;


public class Main {
    

    private static String[][] updatedTable;

    public static void main(String[] args) throws Exception {
        

        Scanner scanner = new Scanner(System.in);
        Player scoreSaver1 = new Player();
        Player scoreSaver2 = new Player();


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

                    int NumberOfMaxMove=(enteredValue*enteredValue);

                    Player controller = new Player();
                    Player player = new Player();
                    int turnToPlay = controller.whoStartToPlay();
                    int pointsOfPlayer1 = 0;
                    int pointsOfPlayer2 = 0;
                    
                    while(0 < NumberOfMaxMove){

                        
                        if (turnToPlay == 1){
                            boolean controlSOS = false;
                            System.out.println("Your Turn");
                            int PlayerCoordinateX = player.playerMoveX(turnToPlay,enteredValue);
                            int PlayerCoordinateY = player.playerMoveY(turnToPlay,enteredValue);
                            String selectedLetter = controller.selectLetter(turnToPlay);
                            

                            if(  (0 < PlayerCoordinateX) && (PlayerCoordinateX < newEnteredValue) && (0 < PlayerCoordinateY) && (PlayerCoordinateY < newEnteredValue) && (selectedLetter.matches("[S,s,O,o]")) ){
                                
                                if(updatedTable[PlayerCoordinateX][PlayerCoordinateY] == "-"){
                                    updatedTable[PlayerCoordinateX][PlayerCoordinateY] = selectedLetter;
                                    SosTable.updateTable (updatedTable,newEnteredValue);
                                    System.out.println(" ");

                                    if(selectedLetter.matches("O")){               
                                        
                                        if( control_Up_Bottom(PlayerCoordinateX,PlayerCoordinateY) || 
                                            control_Left_Right(PlayerCoordinateX,PlayerCoordinateY) || 
                                            control_LeftTop_RightBottom(PlayerCoordinateX,PlayerCoordinateY) ||  
                                            control_RightTop_LeftBottom(PlayerCoordinateX,PlayerCoordinateY) ){
                                                System.out.println("Congratulations, You did SOS ");
                                                pointsOfPlayer1 ++;
                                                scoreSaver1.scores = pointsOfPlayer1;
                                                controlSOS = true;
                                                
                                            }                 

                                    }
                                    
                                    else{

                                            if( control_BottomS(PlayerCoordinateX,PlayerCoordinateY) || 
                                                control_UpS(PlayerCoordinateX,PlayerCoordinateY) || 
                                                control_LeftS(PlayerCoordinateX,PlayerCoordinateY) ||
                                                control_RightS(PlayerCoordinateX,PlayerCoordinateY) ||  
                                                control_LeftTopS(PlayerCoordinateX,PlayerCoordinateY) || 
                                                control_RightBottomS(PlayerCoordinateX,PlayerCoordinateY) ||  
                                                control_RightTopS(PlayerCoordinateX,PlayerCoordinateY) ||
                                                control_LeftBottomS(PlayerCoordinateX,PlayerCoordinateY)){

                                                    System.out.println("Congratulations, You did SOS ");
                                                    pointsOfPlayer1 ++;
                                                    scoreSaver1.scores = pointsOfPlayer1;
                                                    controlSOS = true;

                                            }
                                        
                                    }

                                    System.out.println("Your Score: "+ pointsOfPlayer1);
                                    System.out.println("Computer Score: "+ pointsOfPlayer2);
                                    System.out.println(" ");
                                    NumberOfMaxMove--;
                                    if(controlSOS) turnToPlay = 1;
                                    else turnToPlay = 2;
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

                        else if(turnToPlay == 2){
                           
                            boolean controlSOS = false;
                            
                            int PlayerCoordinateX = player.playerMoveX(turnToPlay,enteredValue);
                            int PlayerCoordinateY = player.playerMoveY(turnToPlay,enteredValue);

                            if(updatedTable[PlayerCoordinateX][PlayerCoordinateY] == "-"){
                                System.out.println("Computer Turn");
                                System.out.println("Computer selected row number: "+ PlayerCoordinateX);
                                System.out.println("Computer selected column number: "+ PlayerCoordinateY);
                                String selectedLetterFromComputer = controller.selectLetter(turnToPlay);
                                updatedTable[PlayerCoordinateX][PlayerCoordinateY]= selectedLetterFromComputer;
                                SosTable.updateTable (updatedTable,newEnteredValue);
                                System.out.println(" ");


                                if(selectedLetterFromComputer.matches("O")){
                                                              
                                    if( control_Up_Bottom(PlayerCoordinateX,PlayerCoordinateY) || 
                                        control_Left_Right(PlayerCoordinateX,PlayerCoordinateY) || 
                                        control_LeftTop_RightBottom(PlayerCoordinateX,PlayerCoordinateY) ||  
                                        control_RightTop_LeftBottom(PlayerCoordinateX,PlayerCoordinateY) ){
                                            System.out.println("COMPUTER did SOS");
                                            pointsOfPlayer2 ++;
                                            scoreSaver2.scores = pointsOfPlayer2;
                                            controlSOS = true;
                                            
                                    }                 

                                }

                                else{

                                    if( control_BottomS(PlayerCoordinateX,PlayerCoordinateY) || 
                                        control_UpS(PlayerCoordinateX,PlayerCoordinateY) || 
                                        control_LeftS(PlayerCoordinateX,PlayerCoordinateY) ||
                                        control_RightS(PlayerCoordinateX,PlayerCoordinateY) ||  
                                        control_LeftTopS(PlayerCoordinateX,PlayerCoordinateY) || 
                                        control_RightBottomS(PlayerCoordinateX,PlayerCoordinateY) ||  
                                        control_RightTopS(PlayerCoordinateX,PlayerCoordinateY) ||
                                        control_LeftBottomS(PlayerCoordinateX,PlayerCoordinateY)){

                                            System.out.println("COMPUTER did SOS ");
                                            pointsOfPlayer2 ++;
                                            scoreSaver2.scores = pointsOfPlayer2;
                                            controlSOS = true;

                                        }
                                
                                }


                                System.out.println("Your Score: "+ pointsOfPlayer1);
                                System.out.println("Computer Score: "+ pointsOfPlayer2);
                                System.out.println(" ");
                                NumberOfMaxMove--;
                                if(controlSOS) turnToPlay = 2;
                                else turnToPlay = 1;

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

        System.out.println("*** GAME OVER ***");
        if(scoreSaver1.scores > scoreSaver2.scores){
            System.out.println("YOU "+ scoreSaver1.scores +" - " + (scoreSaver2.scores) + " COMPUTER");
            System.out.println("YOU WON :)");

        }   
        else if(scoreSaver2.scores > scoreSaver1.scores){
            System.out.println("YOU "+ scoreSaver1.scores +" - " + scoreSaver2.scores + " COMPUTER");
            System.out.println("YOU LOST :(");
           
        } 
        else{
            System.out.println("YOU "+ scoreSaver1.scores +" - " + scoreSaver2.scores + " COMPUTER");
            System.out.println("DRAW");

        }


          
            
             
    }

    private static boolean control_RightTop_LeftBottom(int coordinateX, int coordinateY) {

        try {
            if(updatedTable[coordinateX - 1][coordinateY + 1].matches("S") && 
            updatedTable[coordinateX + 1][coordinateY - 1].matches("S") )  {

            return true;
            }
            
            else return false;
            
            } catch (ArrayIndexOutOfBoundsException e) {
                return false;
            }
        
        
    }

    private static boolean control_LeftTop_RightBottom(int coordinateX, int coordinateY) {
        try {
            if(updatedTable[coordinateX - 1][coordinateY - 1].matches("S") && 
            updatedTable[coordinateX + 1][coordinateY + 1].matches("S")){

            return true;
            }
            
            else return false;
            
            } catch (ArrayIndexOutOfBoundsException e) {
                return false;
            
            }

   
    }

    private static boolean control_Left_Right(int coordinateX, int coordinateY) {

        try {
            if(updatedTable[coordinateX][coordinateY - 1].matches("S") && 
            updatedTable[coordinateX][coordinateY + 1].matches("S")){

            return true;
            }
            
            else return false;
            
            } catch (ArrayIndexOutOfBoundsException e) {

                return false;
            }
        
    }

    private static boolean control_Up_Bottom(int coordinateX, int coordinateY) {

        try {
            if(updatedTable[coordinateX - 1][coordinateY].matches("S") && 
            updatedTable[coordinateX + 1][coordinateY].matches("S")  ){
    
                return true;
            }
            
            else return false;
            
            } catch (ArrayIndexOutOfBoundsException e) {


                return false;
            }
        
      

    }
    private static boolean control_BottomS(int coordinateX, int coordinateY) {

        try {
            if(updatedTable[coordinateX + 1][coordinateY].matches("O") 
                && updatedTable[coordinateX + 2][coordinateY].matches("S")){
    
                return true;
            }
            else return false;
            } catch (ArrayIndexOutOfBoundsException e) {

                return false;
            }
    }

    private static boolean control_UpS(int coordinateX, int coordinateY) {

        try {
            if(updatedTable[coordinateX - 1][coordinateY].matches("O") 
                && updatedTable[coordinateX - 2][coordinateY].matches("S")){
    
                return true;
            }
            else return false;
            } catch (ArrayIndexOutOfBoundsException e) {

                return false;
            }
    }

    private static boolean control_LeftS(int coordinateX, int coordinateY) {

        try {
            if(updatedTable[coordinateX][coordinateY - 1].matches("O") 
                && updatedTable[coordinateX][coordinateY - 2].matches("S")){
    
                return true;
            }
            else return false;
            } catch (ArrayIndexOutOfBoundsException e) {

                return false;
            }
    }

    private static boolean control_RightS(int coordinateX, int coordinateY) {

        try {
            if(updatedTable[coordinateX][coordinateY + 1].matches("O") 
                && updatedTable[coordinateX][coordinateY + 2].matches("S")){
    
                return true;
            }
            else return false;
            } catch (ArrayIndexOutOfBoundsException e) {

                return false;
            }
    }

    private static boolean control_LeftTopS(int coordinateX, int coordinateY) {

        try {
            if(updatedTable[coordinateX - 1][coordinateY - 1].matches("O") 
                && updatedTable[coordinateX - 2][coordinateY - 2].matches("S")){
    
                return true;
            }
            else return false;
            } catch (ArrayIndexOutOfBoundsException e) {

                return false;
            }
    }

    private static boolean control_RightBottomS(int coordinateX, int coordinateY) {

        try {
            if(updatedTable[coordinateX + 1][coordinateY + 1].matches("O") 
                && updatedTable[coordinateX + 2][coordinateY + 2].matches("S")){
    
                return true;
            }
            else return false;
            } catch (ArrayIndexOutOfBoundsException e) {

                return false;
            }
    }

    private static boolean control_RightTopS(int coordinateX, int coordinateY) {

        try {
            if(updatedTable[coordinateX - 1][coordinateY + 1].matches("O") 
                && updatedTable[coordinateX - 2][coordinateY + 2].matches("S")){
    
                return true;
            }
            else return false;
            } catch (ArrayIndexOutOfBoundsException e) {

                return false;
            }
    }

    private static boolean control_LeftBottomS(int coordinateX, int coordinateY) {

        try {
            if(updatedTable[coordinateX + 1][coordinateY - 1].matches("O") 
                && updatedTable[coordinateX + 2][coordinateY - 2].matches("S")){
    
                return true;
            }
            else return false;
            } catch (ArrayIndexOutOfBoundsException e) {

                return false;
            }
    }





    
}
