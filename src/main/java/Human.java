import java.awt.*;
import java.util.Scanner;

public class Human implements Player {
    private Cell symbol;

    Human(int order) {
        this.symbol = order == 1 ? Cell.CROSS : Cell.NOUGHT;
    }

    public Point turn(Board board) {
        Point done = null;
        while (done == null) {   //handling wrong input
            Scanner sc = new Scanner(System.in);
            System.out.print("Input x: ");
            int x = sc.nextInt() - 1;           //to make input start with 1 instead of 0
            System.out.print("Input y: ");
            int y = sc.nextInt() - 1;           //to make input start with 1 instead of 0
            done = board.placeXO(x, y, symbol);
        }
        return done;
    }

    public Cell getSymbol() {
        return symbol;
    }
}
