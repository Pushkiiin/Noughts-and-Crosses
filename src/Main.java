// -Zapili wincheck, suka!
// -No ia hz, kak..
// -Da mne pohui!
public class Main {
    public static Board board = new Board();

    public static void main(String[] args){
        board.initField();
        HumanPlayer human = new HumanPlayer();
        AIPlayer ai = new AIPlayer();
        board.printField();
        while(board.emptyCellsLeft != 0){
            human.turn(board);
            ai.turn(board);
            board.printField();
        }
    }
}