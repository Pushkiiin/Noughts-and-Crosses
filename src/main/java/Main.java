//possible upgrades:
//possibility for 2 AI's or 2 Humans to play; change AIMARK & HUMANMARK identifiers
//create gameManager for more OOP
//amend winCheck since current implementation is pretty stupid

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
        System.out.println("awe");

    }
}