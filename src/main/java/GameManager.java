import java.util.Scanner;

public class GameManager {
    public void chooseMode(Player[] opponents) {
        System.out.println("1) Human vs Human");
        System.out.println("2) Human vs AI");
        System.out.println("3) AI vs Human");
        System.out.println("4) AI vs AI");
        System.out.println("First player's symbol is always X. Just take it as it is.");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                opponents[0] = new Human(1);
                opponents[1] = new Human(2);
                break;
            case 2:
                opponents[0] = new Human(1);
                opponents[1] = new AI(2);
                break;
            case 3:
                opponents[0] = new AI(1);
                opponents[1] = new Human(2);
                break;
            case 4:
                opponents[0] = new AI(1);
                opponents[1] = new AI(2);
                break;
        }
    }
}
