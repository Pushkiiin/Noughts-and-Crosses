public enum Cell {
    EMPTY('*'), XMARK('X'), OMARK('O');
    private char val;

    Cell(char symbol){
        this.val = symbol;
    }

    public char getVal(){
        return val;
    }
}
