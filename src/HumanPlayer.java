import java.util.Scanner;

public class HumanPlayer extends Player {
    public HumanPlayer() {
        xo = 'X';
    }

    public void turn(Board board){
        if (board.emptyCellsLeft == 0)
            return;
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        board.placeXO(x, y , 'X');
        board.emptyCellsLeft--;
    }
}
