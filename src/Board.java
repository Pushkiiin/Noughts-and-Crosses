public class Board {
    private final int SIZE = 5;
    private final int TO_WIN = 3;
    private char[][] field = new char[SIZE][SIZE];
    public int emptyCellsLeft = SIZE*SIZE;

    public void initField(){
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                field[i][j] = '*';
    }

    public void printField(){
        for (int i = 0; i < SIZE; i++){
            for (int j = 0; j < SIZE; j++)
                System.out.print(field[i][j] + " ");
            System.out.println();
        }
        System.out.println();
    }

    public void placeXO(int x, int y, char xo){
        if(x >= 1 && x <= SIZE && y >= 1 && y <= SIZE && field[x-1][y-1] == '*')
            field[x-1][y-1] = xo;
        else
            System.out.println("Choose another cell");
    }

    //getters&setters
    public int getSize(){
        return SIZE;
    }

    public char[][] getField(){
        return field;
    }

}
