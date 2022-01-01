import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean again = true;
//        while (again) {
            Player currentPlayer;
            Board boardMain = new Board();
            BoardUtils.setup();

            BoardUtils.PLAYERS.add(BoardUtils.PLAYER1);
            BoardUtils.PLAYERS.add(BoardUtils.PLAYER2);

            currentPlayer = BoardUtils.PLAYER1;

            boardMain.printBoard();

            //2-Player Game Loop
            while (BoardUtils.isWinner(boardMain) == false && (BoardUtils.PLAYER1.getAI() == false
                    && BoardUtils.PLAYER2.getAI() == false)) {
                System.out.println(currentPlayer.getName() + ", it is your turn!");
                boardMain.setBoardArray(BoardUtils.askMoveCords(), currentPlayer.getTeam());
                currentPlayer.setMoveNumber(currentPlayer.getMoveNumber() + 1);
                boardMain.printBoard();
                if (BoardUtils.isTie(currentPlayer) == true && BoardUtils.isWinner(boardMain) == false) {
                    System.out.println("It's a Tie!");
                    break;
                }
                if (BoardUtils.isWinner(boardMain) == true) {
                    System.out.println(currentPlayer.getName() + " wins");
                    break;
                }
                BoardUtils.PLAYERS.remove(currentPlayer);
                BoardUtils.PLAYERS.add(1, currentPlayer);
                currentPlayer = BoardUtils.PLAYERS.get(0);
            }

            //1-Player Game Loop
            if (((BoardUtils.PLAYER1.getAI() == true) || (BoardUtils.PLAYER2.getAI() == true))) {
                Random random = new Random();
                while (BoardUtils.isWinner(boardMain) == false) {
                    if (currentPlayer.getAI() == false) {
                        System.out.println("\n" + currentPlayer.getName() + ", it is your turn!");
                        boardMain.setBoardArray(BoardUtils.askMoveCords(), currentPlayer.getTeam());
                        currentPlayer.setMoveNumber(currentPlayer.getMoveNumber() + 1);
                        boardMain.printBoard();
                    }
                    if (currentPlayer.getAI()) {
                        System.out.println("\nAI's Turn");
                        Tile aiMove = boardMain.UnplayedTiles.get(random.nextInt(boardMain.UnplayedTiles.size()));
                        boardMain.setBoardArray(aiMove.getCoordinate(), currentPlayer.getTeam());
                        currentPlayer.setMoveNumber(currentPlayer.getMoveNumber() + 1);
                        boardMain.printBoard();
                    }
                    if (BoardUtils.isTie(currentPlayer) == true && BoardUtils.isWinner(boardMain) == false) {
                        System.out.println("It's a Tie!");
                        break;
                    }
                    if (BoardUtils.isWinner(boardMain) == true) {
                        System.out.println("\n" + currentPlayer.getName() + " wins!");
                        break;
                    }
                    BoardUtils.PLAYERS.remove(currentPlayer);
                    BoardUtils.PLAYERS.add(1, currentPlayer);
                    currentPlayer = BoardUtils.PLAYERS.get(0);
                }
            }
            System.out.println("\nGame Over");
//            System.out.println("Would you like to play again?");
//            Scanner scanner = new Scanner(System.in);
//            String choice = scanner.nextLine();
//            if((choice.equals("Yes") || choice.equals("yes"))){
//                again = true;
//            }
//            else{
//                again = false;
//            }
//        }
    }
}