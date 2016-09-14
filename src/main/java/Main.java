//possible upgrades:
//possibility for 2 AI's or 2 Humans to play
//create gameManager for more OOP
//amend board.winCheck() since current implementation is pretty stupid
//handle over9k exceptional situations
//improve AI

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        board.initField();
        Human human = new Human();
        AI ai = new AI();
        board.printField();
        boolean reachedWinCond;

        boolean turn = true;    //for turn sequence
        Point current;
        do {
            if(turn){
                current = human.turn(board);
                board.printField();
                reachedWinCond = board.winCheck(current.x, current.y);
            } else{
                current = ai.turn(board);
                board.printField();
                reachedWinCond = board.winCheck(current.x, current.y);
            }
            turn = !turn;
        } while (!reachedWinCond);
        System.out.println("awe winner");
    }
}