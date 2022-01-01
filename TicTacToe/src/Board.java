import java.util.ArrayList;
import java.util.List;

public class Board {

    Tile[][] boardArray = new Tile[3][3];
    public List<Tile> UnplayedTiles = new ArrayList<>();

   public Board(){
       int index = 0;
        for (int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++){
                boardArray[i][j] = new Tile(new int[]{i,j}, false, index);
                UnplayedTiles.add(boardArray[i][j]);
                index++;
            }
        }
   }

    public void printBoard(){
       System.out.println("   1     2     3");
        for (int i = 0; i < 3; i++) {
              System.out.println((i+1)+ "   " + boardArray[i][0].toString() + " |  " +
                      boardArray[i][1].toString()+ "  | " + boardArray[i][2].toString());
              if(i <2){
                  System.out.println("   ---+-----+---");
              }
        }
    }

    public void setBoardArray(int[] cord, int team){
       boolean retread = false;
       while(!retread) {
           try {
               if (boardArray[cord[0]][cord[1]].isOccupied()) {
                   System.out.println("That space is already occupied. You have eyes, don't you?");
                   cord = BoardUtils.askMoveCords();
               } else {
                   boardArray[cord[0]][cord[1]].setTeam(team);
                   UnplayedTiles.remove(boardArray[cord[0]][cord[1]]);
                   retread = true;
               }
           } catch (IndexOutOfBoundsException e) {
               System.out.println("Those are not valid coordinates, wanna try that again?");
               cord = BoardUtils.askMoveCords();
           }
       }
    }
}
