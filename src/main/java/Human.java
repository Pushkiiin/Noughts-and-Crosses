import java.awt.*;
import java.util.Scanner;

public class Human implements Player {
    public Point turn(Board board){
        Scanner sc = new Scanner(System.in);
        System.out.print("Input x: ");
        int x = sc.nextInt();
        System.out.print("Input y: ");
        int y = sc.nextInt();
        return board.placeXO(x, y, Cell.XMARK);
    }
}
