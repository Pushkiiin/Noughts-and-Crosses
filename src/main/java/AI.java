import java.awt.Point;

public class AI implements Player {
    public void turn(Board board) {
        int random = (int) (Math.random() * (board.getEmptyCells().size()));
        Point rnd = (Point) board.getEmptyCells().get(random);

        board.placeXO(rnd.x, rnd.y, Cell.AIMARK);
    }
}
