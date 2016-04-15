import java.awt.Point;
import java.util.Scanner;

public class Human implements Player {
    public void turn(Board board){
        Scanner sc = new Scanner(System.in);
        System.out.print("Input x: ");
        int x = sc.nextInt();
        System.out.print("Input y: ");
        int y = sc.nextInt();
        board.placeXO(x, y, Cell.HUMANMARK);
    }
}
