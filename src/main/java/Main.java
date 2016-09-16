//upgrades:
//mb move some methods from Board to GameManager, I'm not sure
//write tests for mr. Chewey
//improve AI - sweet dreams are made of...

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        board.initField();
        GameManager gm = new GameManager();
        Player[] opponents = new Player[2];
        gm.chooseMod(opponents);

        board.printField();
        boolean reachedWinCond;
        boolean turn = true;    //for turn sequence
        Point current;
        Cell lastTurnSymbol;    //for congratulating winner
        do {
            if (turn) {
                current = opponents[0].turn(board);
                lastTurnSymbol = opponents[0].getSymbol();
                board.printField();
                reachedWinCond = board.winCheck(current.x, current.y);
            } else {
                current = opponents[1].turn(board);
                lastTurnSymbol = opponents[1].getSymbol();
                board.printField();
                reachedWinCond = board.winCheck(current.x, current.y);
            }
            turn = !turn;
        } while (!reachedWinCond);
        System.out.println(lastTurnSymbol.getVal() + " wins!");
    }
}