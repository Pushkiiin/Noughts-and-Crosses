import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {
    private final int SIZE = 5;
    private final int TO_WIN = 3;
    private Point[][] field = new Point[SIZE][SIZE];
    private List<Point> emptyPointsList = new ArrayList<>();   //for AI turns, not to repeat it each turn into AI.turn()
    private Map<Point, Cell> cellStates = new HashMap<>();

    public void initField() {
       for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                field[x][y] = new Point(x,y);
                cellStates.put(field[x][y], Cell.EMPTY);
                emptyPointsList.add(field[x][y]);
            }
        }
    }

    public void printField(){
        for (int y = 0; y < SIZE; y++){
            for (int x = 0; x < SIZE; x++)
                System.out.print(cellStates.get(field[x][y]).getVal() + " ");
            System.out.println();
        }
        System.out.println();
    }

    public Point placeXO(int x, int y, Cell val) {
        if (x >= 0 && x < SIZE && y >= 0 && y < SIZE && cellStates.get(field[x][y]).equals(Cell.EMPTY)) {
            if(val == Cell.XMARK){
                cellStates.put(field[x][y], Cell.XMARK);
            } else{
                cellStates.put(field[x][y], Cell.OMARK);
            }
            emptyPointsList.remove(field[x][y]);
            return field[x][y];
        } else {
            printField();
            System.out.println("Choose another cell");
            return null;
        }
    }

    public boolean winCheck(int x, int y) {
        Cell val = cellStates.get(field[x][y]);
        int row = 0;

        for (int i = x - (TO_WIN - 1); i <= x + (TO_WIN - 1); i++) {
            try {
                if (cellStates.get(field[i][y]).equals(val))
                    row++;
                else row = 0;
            }
            catch(Exception e){
                continue;
            }
            if (row == TO_WIN)
                return true;
        }
        row = 0;

        for (int i = y - (TO_WIN - 1); i <= y + (TO_WIN - 1); i++) {
            try {
                if(cellStates.get(field[x][i]).equals(val))
                    row++;
                else row = 0;
            }
            catch(Exception e){
                continue;
            }
            if (row == TO_WIN)
                return true;
        }
        row = 0;

        for (int i = x - (TO_WIN - 1), j = y - (TO_WIN - 1); i <= x + (TO_WIN - 1); i++, j++) {
            try{
                if(cellStates.get(field[i][j]).equals(val))
                    row++;
                else row = 0;
            }
            catch(Exception e){
                continue;
            }
            if (row == TO_WIN)
                return true;
        }
        row = 0;

        for (int i = x + (TO_WIN - 1), j = y - (TO_WIN - 1); i >= x - (TO_WIN - 1); i--, j++) {
            try{
                if(cellStates.get(field[i][j]).equals(val))
                    row++;
                else row = 0;
            }
            catch(Exception e){
                continue;
            }
            if (row == TO_WIN)
                return true;
        }

        return false;
    }

    //getters&setters
    public int getSize() {
        return SIZE;
    }

    public Point[][] getField() {
        return field;
    }

    public List<Point> getEmptyPointsList(){
        return emptyPointsList;
    }
}