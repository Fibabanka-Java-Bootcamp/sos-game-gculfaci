
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
