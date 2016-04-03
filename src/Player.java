public abstract class Player {
    protected char xo;
    protected abstract void turn(Board board);
    protected boolean reachedWinCond = false;
}
