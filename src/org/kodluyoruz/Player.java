package Sos;

import java.util.Scanner;

public class Player {
    int point;
    
    int numberOfTurn;
    
    Scanner scanner = new Scanner(System.in);

    public int playerMoveX(){
        System.out.println("Please enter row of table: ");
        String PlayerMoveX = scanner.nextLine();
        int PlayerCoordinateX = Integer.parseInt(PlayerMoveX);
        return PlayerCoordinateX;
    }

    public int playerMoveY(){
        System.out.println("Please enter column of table: ");
        String PlayerMoveY = scanner.nextLine();
        int PlayerCoordinateY = Integer.parseInt(PlayerMoveY);
        return PlayerCoordinateY;
    }

   
    
}
