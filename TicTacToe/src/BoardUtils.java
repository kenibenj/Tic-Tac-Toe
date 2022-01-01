import java.util.*;

public class BoardUtils {

    public static Player PLAYER1 = new Player();
    public static Player PLAYER2 = new Player();

    public static List<Player> PLAYERS = new ArrayList<>();


    public static void test(Board board){
        if(board.boardArray[0][1].isOccupied()==true){
            System.out.println("occupied");
        }
        else{
            System.out.println("unoccupied");
        }
        System.out.println(board.boardArray[1][2].getTeam());
        System.out.println(board.boardArray[2][2].getCoordinate());
        System.out.println("");
    }


    public static boolean isWinner(Board board){
        boolean winner = false;
        boolean xWin = false;

        for(int i = 0; i < 3; i++) {
            if ((board.boardArray[i][0].getTeam() == board.boardArray[i][1].getTeam()) &&
                    (board.boardArray[i][1].getTeam() == board.boardArray[i][2].getTeam())
                    && (board.boardArray[i][1].isOccupied())) {
                winner = true;
                if (board.boardArray[i][1].getTeam() == Tile.X) {
                    xWin = true;
                }
            }
        }

        for(int i = 0; i < 3; i++) {
            if ((board.boardArray[0][i].getTeam() == board.boardArray[1][i].getTeam()) &&
                    (board.boardArray[1][i].getTeam() == board.boardArray[2][i].getTeam())
                    && (board.boardArray[0][i].isOccupied())) {
                winner = true;
                if (board.boardArray[0][i].getTeam() == Tile.X) {
                    xWin = true;
                }
            }
        }

        if((board.boardArray[0][0].getTeam() == board.boardArray[1][1].getTeam()) &&
                (board.boardArray[1][1].getTeam() == board.boardArray[2][2].getTeam())
                &&(board.boardArray[0][0].isOccupied())){
            winner = true;
            if(board.boardArray[0][0].getTeam() == Tile.X){
                xWin = true;
            }
        }

        if((board.boardArray[0][2].getTeam() == board.boardArray[1][1].getTeam()) &&
                (board.boardArray[1][1].getTeam() ==board.boardArray[2][0].getTeam())
                &&(board.boardArray[0][2].isOccupied())){
            winner = true;
            if(board.boardArray[1][1].getTeam() == Tile.X){
                xWin = true;
            }
        }
        return winner;
    }

     public static void setup() {
         boolean vsAI = true;
         String choice = "";

         Scanner myObj = new Scanner(System.in);  // Create a Scanner object
         System.out.println("One Player or Two Player?");
         choice = myObj.nextLine();

         //2-player
         if (choice.equals("Two") || choice.equals("two") || choice.equals("2")) {
             System.out.println("Who will go first?");
             PLAYER1.setName(myObj.nextLine());
             System.out.println("Who will go second?");
             PLAYER2.setName(myObj.nextLine());
         }

         //1-player
         if(choice.equals("one") || choice.equals("One") || choice.equals("1")){
             while(!choice.equals("Yes")||!choice.equals("yes")||!choice.equals("no")||!choice.equals("No")) {
                 System.out.println("Will you go first?");
                 choice = myObj.nextLine();
                 if (choice.equals("Yes") || choice.equals("yes")) {
                     System.out.println("What is your name?");
                     choice = myObj.nextLine();
                     PLAYER1.setName(choice);
                     PLAYER2.setName("AI");
                     PLAYER2.setAI(true);
                     break;
                 }
                 if(choice.equals("No")||choice.equals("no")){
                     System.out.println("What is your name?");
                     choice = myObj.nextLine();
                     PLAYER2.setName(choice);
                     PLAYER1.setName("AI");
                     PLAYER1.setAI(true);
                     break;
                 }
                 else{
                     System.out.println("Yes or No, please.");
                 }
             }
         }
         choice = "";
         while ((choice.equals("X") || choice.equals("O")) == false) {
             System.out.println("Will "+ PLAYER1.getName() + " be X or O?");
             choice = myObj.nextLine();
             if (choice.equals("X")) {
                 PLAYER1.setTeam(Tile.X);
                 PLAYER2.setTeam(Tile.O);
             } else if (choice.equals("O")) {
                 PLAYER1.setTeam(Tile.O);
                 PLAYER2.setTeam(Tile.X);
             } else {
                 System.out.println("It said 'X' or 'O'. Maybe pay attention, yeah?");
             }
         }
     }

     public static int[] askMoveCords() {
         int[] moveCoords = new int[2];
         Scanner scanner = new Scanner(System.in);  // Create a Scanner object
         int input;
         boolean validCoords = false;
         while (validCoords == false) {
             System.out.println("Where would you like to move? (Row)");
             try {
                 input = Integer.valueOf(scanner.nextLine());
                 moveCoords[0] = input - 1;
             } catch (NumberFormatException e) {
                 System.out.println("That isn't even a number, smooth-brain");
                 continue;
             }
             System.out.println("Where would you like to move? (Column)");
             try {
                 input = Integer.valueOf(scanner.nextLine());
                 moveCoords[1] = input - 1;
             } catch (NumberFormatException e) {
                 System.out.println("That isn't even a number, smooth-brain");
                 continue;
             }
             validCoords = true;
         }
         return moveCoords;
     }

     public static boolean isTie(Player player){
        if(player.getMoveNumber() == 5){
            return true;
        }
        else{
            return false;
        }
     }
}
