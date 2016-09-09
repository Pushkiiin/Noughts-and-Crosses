public enum Cell {
    EMPTY('*'), XMARK('X'), OMARK('O');
    private char val;

    Cell(){
        this.val = '*';
    }
    Cell(char symbol){
        this.val = symbol;
    }

    public char getVal(){
        return val;
    }

    public void setVal(char val){
        this.val = val;
    }
}
