import java.awt.*;
import java.util.Random;

public class AI implements Player {
    public Point turn(Board board) {
        Point point = board.getEmptyPointsList().get((new Random()).nextInt(board.getEmptyPointsList().size()));
        return board.placeXO(point.x, point.y, Cell.OMARK);
    }
}
