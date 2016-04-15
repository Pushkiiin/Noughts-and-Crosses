public enum Cell {
    EMPTY('*'), HUMANMARK('X'), AIMARK('O');
    char val;

    Cell(char symbol){
        this.val = symbol;
    }

    public char getVal(){
        return val;
    }
}
