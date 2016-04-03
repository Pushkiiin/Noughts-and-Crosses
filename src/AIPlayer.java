public class AIPlayer extends Player {
    public void turn(Board board){
        if (Main.board.emptyCellsLeft == 0)
            return;
        int y, x;
        do {
            x = (int) (Math.random() * board.getSize()) + 1;
            y = (int) (Math.random() * board.getSize()) + 1;
        }
        while (board.getField()[x-1][y-1] != '*');
        board.placeXO(x, y, 'O');
        board.emptyCellsLeft--;
    }
}
