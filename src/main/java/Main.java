//wincheck обернуть в trycatch и проходить по всему множеству вдоль одной прямой

//я не уверен, что тут вообще нужен Board.placeXO(,,)
//в board.placeXO заделать большой цикл
//переписать board.winCheck с dx,dy
//сделать turn возвращать Cell, в который походили и юзать на него winCheck
public class Main {
    public static void main(String[] args){
        Board board = new Board();
        board.initField();
        Human human = new Human();
        AI ai = new AI();
        board.printField();

        while (true) {
            human.turn(board);
            board.printField();
            board.winCheck()
            ai.turn(board);
            board.printField();

        }
    }
}