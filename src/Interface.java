import java.util.Scanner;

public class Interface {


    Controller controller = new Controller();
    Scanner scanner = new Scanner(System.in);
    String separator = "---------------------------------------";
    boolean running = true;

    void start(){
        System.out.println("Welcome to the dungoen!");
        System.out.println("Whats your name young hero?");
        String name = scanner.next();
        //TODO call on a create player method in controller where you pass name as parameter
        System.out.println("\n" +"Welcome to the game, " + name + "!");
        System.out.println(separator);
        controller.test();
        startGame();
    }

    void startGame(){

    }



}
