import java.awt.*;
import java.util.Random;

public class AI implements Player {
    private Cell symbol;

    AI(int order) {
        this.symbol = order == 1 ? Cell.CROSS : Cell.NOUGHT;
    }

    public Point turn(Board board) {
        Point point = board.getEmptyPointsList().get((new Random()).nextInt(board.getEmptyPointsList().size()));
        return board.placeXO(point.x, point.y, symbol);
    }

    public Cell getSymbol() {
        return symbol;
    }
}
