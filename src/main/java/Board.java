import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Board {
    private final int SIZE = 5;
    private final int TO_WIN = 3;
    private Cell[][] field = new Cell[SIZE][SIZE];
    private List<Point> emptyCells = new ArrayList<>();   //Для ходов компа

    public void initField() {
       for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                emptyCells.add(new Point(x, y));
                field[x][y] = Cell.EMPTY;
            }
        }
    }

    public void printField(){
        for (int x = 0; x < SIZE; x++){
            for (int y = 0; y < SIZE; y++)
                System.out.print(field[x][y].getVal() + " ");
            System.out.println();
        }
        System.out.println();
    }

    public boolean placeXO(int x, int y, Cell val) {
        if (x >= 0 && x < SIZE && y >= 0 && y < SIZE && field[x][y].equals(Cell.EMPTY)) {
            Point pt = new Point(x,y);
            for (int i = 0; i < emptyCells.size(); i++) {
                if(emptyCells.get(i).equals(pt))
                    emptyCells.remove(i);
            }
            field[x][y] = val;
            return winCheck(x, y);
        } else {
            System.out.println("Choose another cell");
            return false;
        }
    }

    public boolean winCheck(int x, int y) {
        int row = 0;
        Cell val = field[x][y];
        for (int i = x - (TO_WIN - 1); i <= x + (TO_WIN - 1); i++) {
            try {
                if (field[i][y].equals(val))
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
                if(field[x][i].equals(val))
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
                if(field[i][j].equals(val))
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
                if(field[i][j].equals(val))
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

    public Cell[][] getField() {
        return field;
    }

    public List getEmptyCells(){
        return emptyCells;
    }

}

