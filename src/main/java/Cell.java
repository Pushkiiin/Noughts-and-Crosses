public enum Cell {
    EMPTY('-'), CROSS('X'), NOUGHT('O');
    private char val;

    Cell(char val) {
        this.val = val;
    }

    public char getVal() {
        return val;
    }
}
