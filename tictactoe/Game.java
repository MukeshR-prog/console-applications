import java.util.Scanner;

public class Game {
    private Player player1;
    private Player player2;

    private Player currentPlayer;

    private Board board;
    private Scanner scanner;

    public Game(){
        scanner = new Scanner(System.in);
        board = new Board();
    }
    private void switchplayer(){
        currentPlayer = currentPlayer == player1 ? player2 : player1;
    }
    public void intializePlayer(){
        System.out.print("Enter the name of the player 1 : ");
        String name1 = scanner.next();
        System.out.print("Enter the name of the player 2 : ");
        String name2 = scanner.next();
        player1 = new Player(name1, 'X');
        player2 = new Player(name2,'O');
        currentPlayer = player1;
    }
    public void startGame(){
        boolean gameEnd = false;
        while (!gameEnd) {
            board.printBoard();
            System.out.println(currentPlayer.getName()+ "'s turn (" + currentPlayer.getSymbol() + ")");
            System.out.print("Enter position (1-9): ");
            int position = scanner.nextInt();
            if (!board.placeMove(position,  currentPlayer.getSymbol())) {
                System.out.println("Invalid move. Try again.");
                continue;
            }
            if(board.checkWinner(currentPlayer.getSymbol())){
                board.printBoard();
                System.out.println(currentPlayer.getSymbol()+" wins");
                gameEnd = true;
            }else if(board.isBoardFull()){
                board.printBoard();
                System.out.println("Game Draws");
                gameEnd = true;
            }else{
               switchplayer();
            }

        }
    }
}
