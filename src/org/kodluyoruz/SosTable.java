package Sos;

import java.lang.reflect.Array;

public class SosTable {
  
    int sizeOfMatrix;
    
    public String[][] createSosTable(int sizeOfMatrix){
        String[][] sosTable = new String[sizeOfMatrix][sizeOfMatrix];
        int x,y;
        for(x=0; x<sizeOfMatrix; x++){
            for(y=0; y<sizeOfMatrix; y++){
                if(x==0){
                    sosTable[x][y]=String.valueOf(y);
                    System.out.print( sosTable[x][y] + " ");
                }    
                else if(y==0){
                    sosTable[x][y]=String.valueOf(x);
                    System.out.print( sosTable[x][y] + " ");
                }    
                    
                else{
                    sosTable[x][y]= "-";
                    System.out.print( sosTable[x][y] + " ");
                    
                }

            }
            System.out.println();
        }
        
        return sosTable;

        //return sosTable[0][0];
    }


        
       // System.out.println(sosTable);
      //  return sosTable;


       // System.out.println("bu ilk satırdır" + sosTable[0][0]);

    

}
