package move;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the name of the hero");
        String name = sc.nextLine();
        Hero hero = new Hero();
        hero.setName(name);
        a:
        while (true) {
            System.out.println("Please select a moving method");
            System.out.println("Enter 1 to fly");
            System.out.println("Enter 2 walk");
            System.out.println("Enter 3 to ride");
            System.out.println("Enter 0 to exit");
            try {
                int i = sc.nextInt();
                switch (i) {
                    case 1:
                        hero.setMoveStrategy(new MovingByFlight());
                        hero.move();
                        break;
                    case 2:
                        hero.setMoveStrategy(new MovingByRiding());
                        hero.move();
                        break;
                    case 3:
                        hero.setMoveStrategy(new MovingByFoot());
                        hero.move();
                        break;
                    case 0:
                        break a;
                    default:
                        System.out.println("Your instruction is incorrect");
                        break;
                }
            }catch(InputMismatchException e){
                System.err.println("Incorrect input command");
                System.exit(1);
            }

        }
        hero.move();
    }
}
