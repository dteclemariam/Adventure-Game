import java.util.Scanner;

public class Interface {

    Controller controller = new Controller();
    Scanner scanner = new Scanner(System.in);
    boolean running = true;

    void start() {
        //Initial start-menu
        System.out.println("Welcome to the dungoen!");
        System.out.println("Whats your name young hero?");
        String name = scanner.next();
        System.out.println("\n" + "Welcome to the game, " + name + "!");
        controller.createPlayer(name);

        System.out.println("Type yes and press enter if you are ready yo enter your first dungeon");
        System.out.println("Type no and enter if you are to scared and want to exit the game");
        String ready = scanner.next();
        running = controller.yesOrNo(ready);
        if (!running) {
            invalidInput();
            start();
        }

        if (running & ready.toLowerCase().equals("yes")) {
            System.out.println("You enter your first dungeon!");
            separator();
            startGame();
            } else if (running & ready.toLowerCase().equals("no")) {
                exit();
            }
    }//end start

    //method for printing invalid input
    private void invalidInput() {
        System.out.println("Invalid command, try again");
    }

    //method for closing game
    void exit() {
        System.out.println("The game is exiting");
        System.exit(0);
    }

    //method for printing separator
    void separator(){
        System.out.println("---------------------------------------------------------------------------------------");
    }

    void startGame(){
        controller.createEnemyList();
        Characters enemy = controller.getNextEnemy();

        Game:
        while (running){
            separator();

        }
    }
}



