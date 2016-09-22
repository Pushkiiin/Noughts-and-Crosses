import org.junit.Assert;
import org.junit.Test;

public class BoardTest {

    int[][][] positions =
            {{{0, 4}, {0, 3}, {0, 2}, {0, 1}, {0, 0}},  //outer braces - different tests kinda
            {{1, 1}, {1, 5}, {1, 2}, {1, 4}, {1, 3}}};

    private Board createTestBoard(int[][] points, int[] lastPoint){
        Board board = new Board();
        int i;
        for(i = 0; i < points.length; i++){
            board.placeXO(points[i][0], points[i][1], Cell.CROSS);
        }
        lastPoint[0] = points[i - 1][0];
        lastPoint[1] = points[i - 1][1];
        return board;
    }

    @Test
    public void testWinCheck() {
        for (int i = 0; i < positions.length; i++){
            int[] lastPoint = new  int[2];
            Board board = createTestBoard(positions[i], lastPoint);
            Assert.assertEquals(true, board.winCheck(lastPoint[0], lastPoint[1]));
        }
    }
}