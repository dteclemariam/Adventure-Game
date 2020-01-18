import java.util.Scanner;

public class Interface {

    Controller controller = new Controller();
    Scanner scanner = new Scanner(System.in);
    boolean running = true;
    String ready;

    //method for printing separator
    private void separator() {
        System.out.println("---------------------------------------------------------------------------------------");
    }

    //method for printing invalid input
    private void invalidInput() {
        System.out.println("Invalid command, try again");
    }

    //Initial start-menu
    void start() {
        System.out.println("Welcome to the dungoen!");
        System.out.println("Whats your name young hero?");
        String name = scanner.next();
        System.out.println("\n" + "Welcome to the game, " + name + "!");
        System.out.println("How does your battlecry sound like?");
        String battleCry = scanner.next();
        controller.createPlayer(name, battleCry);
        printYesNoChoices();
        while(!running){
            invalidInput();
            printYesNoChoices();
        }
        startGame();
    }//end start

    /*
    method to print yes and no choices -> sends the input to a method in controller that checks if the input
    is valid and returns a boolean
     */
    public void printYesNoChoices() {
        System.out.println("Type yes and press enter to continue\n" +
                "Type no and enter if you are to scared and want to exit the game");
        ready = scanner.next();
        running = controller.handleYesOrNo(ready);
    }


    private void startGame() {
        controller.createEnemyList();
        separator();
        System.out.println("You enter your first dungeon");

        //label for while loop to tell the program to iterate back to start
        /*Game:
        while (running) {
            separator();
            Character enemy = controller.getNextEnemy();
            System.out.println("\t# Enemy " + enemy.getCharacterName() + " has appeared! #\n");
            System.out.println(enemy.getHp());
            int enemyCurrentHp = enemy.getHp();

            while (enemyCurrentHp > 0) {
                //printYesNoChoices();
                //ready = scanner.next();
                //running = controller.yesOrNo()


            }

            //Checking if healthpotion dropped
            boolean newHealthpotion = controller.luckyDrop();
            if (newHealthpotion) {
                System.out.println("The enemy dropped a healthpotion and you pick it up!");
                System.out.println("You now have " + controller.getNumbHealthPotions() + " healthpotion(s)");
            } else {
                System.out.println("No loot");

                break;

                //TODO Continue here
            }
        }*/
    }
}



