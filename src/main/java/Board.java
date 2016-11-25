import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {
    private final int SIZE = 10;
    private final int TO_WIN = 5;
    private Point[][] field = new Point[SIZE][SIZE];
    private List<Point> emptyPointsList = new ArrayList<>();   //for AI turns, not to repeat it each turn into AI.turn()
    private Map<Point, Cell> cellStates = new HashMap<>();

    public Board() {
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                field[x][y] = new Point(x, y);
                cellStates.put(field[x][y], Cell.EMPTY);
                emptyPointsList.add(field[x][y]);
            }
        }
    }

    public void printField() {
        for (int y = 0; y < SIZE; y++) {
            for (int x = 0; x < SIZE; x++)
                System.out.print(cellStates.get(field[x][y]).getVal() + " ");
            System.out.println();
        }
        System.out.println();
    }

    public Point placeXO(int x, int y, Cell val) {
        if (x >= 0 && x < SIZE && y >= 0 && y < SIZE && cellStates.get(field[x][y]).equals(Cell.EMPTY)) {
            cellStates.put(field[x][y], val);
            emptyPointsList.remove(field[x][y]);
            return field[x][y];
        } else {
            printField();
            System.out.println("Choose another cell");
            return null;
        }
    }

    public boolean winCheck(int x, int y) {
        Cell cellVal = cellStates.get(field[x][y]);
        //
        int[][] directions = {{1, 1}, {1, 0}, {1, -1}, {0, 1}};
        int dx, dy;
        for (int[] direction : directions) {
            dx = direction[0];
            dy = direction[1];

            int row = 0;
            //
            boolean flag = false;
            for (int i = x, j = y; i >= 0 && j >= 0; i += dx, j += dy) {
                if (
                        i < x + TO_WIN &&
                                i > x - TO_WIN &&
                                j < y + TO_WIN &&
                                j > y - TO_WIN &&
                                i < SIZE &&
                                j < SIZE &&
                                cellStates.get(field[i][j]) == cellVal) {
                    row++;
                } else {
                    if (flag) {
                        break;
                    }
                    flag = true;
                    i = x;
                    j = y;
                    dx = -dx;
                    dy = -dy;
                }
                if (row == TO_WIN) {
                    return true;
                }
            }
        }
        return false;
    }

    //getters&setters (only used ones)

    public List<Point> getEmptyPointsList() {
        return emptyPointsList;
    }

    public int getSIZE() {
        return SIZE;
    }

    public int getTO_WIN() {
        return TO_WIN;
    }
}
