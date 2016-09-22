//upgrades:
//printField from Board to GameManager
//handle draws and input number >4 in choosemode
//make choice of turn ordering
//write tests for mr. Chewey
//implement MVC?
//improve AI - sweet dreams are made of...

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        GameManager gm = new GameManager();
        Player[] opponents = new Player[2];
        gm.chooseMode(opponents);

        board.printField();
        boolean reachedWinCond;
        boolean firstPlayerTurn = true;    //for turn sequence
        Point current;
        Cell lastTurnSymbol;    //for congratulating winner
        do {
            Player currentPlayer = firstPlayerTurn ? opponents[0] : opponents[1];
            current = currentPlayer.turn(board);
            lastTurnSymbol = currentPlayer.getSymbol();
            board.printField();
            reachedWinCond = board.winCheck(current.x, current.y);
            firstPlayerTurn = !firstPlayerTurn;
        } while (!reachedWinCond);
        System.out.println(lastTurnSymbol.getVal() + " wins!");
    }
}