import java.util.InputMismatchException;
import java.util.Scanner;

public class Interface {

    Controller controller = new Controller();
    Scanner scanner = new Scanner(System.in);

    //method for printing separator
    private void printSeparator() {
        System.out.println("---------------------------------------------------------------------------------------");
    }

    //method for printing invalid input
    private void printInvalidInput() {
        System.out.println("Invalid command, try again");
    }

    //Initial start-menu
    void start() {
        System.out.println("Welcome to the dungoen!");
        System.out.println("Whats your name young hero?");
        String name = scanner.next();
        System.out.println("\n" + "Welcome to the game, " + name + "!");
        System.out.println("How does your battle cry sound like?");
        String battleCry = scanner.next();
        controller.createPlayer(name, battleCry);
        String choice = printYesNoChoices();
        if (choice.equalsIgnoreCase("yes")) {
            startGame();
        } else {
            controller.exit();
        }
    }//end start

    /*
    method to print yes and no choices -> sends the input to a method in controller that checks if the input
    is valid and returns a boolean
     */
    public String printYesNoChoices() {
        System.out.println("Type yes and press enter to continue\n" +
                "Type no and enter if you are to scared and want to exit the game");
        String yesOrNo = scanner.next();
        boolean validInput = controller.handleYesOrNo(yesOrNo);
        while (!validInput) {
            printInvalidInput();
            System.out.println("Type yes and press enter to continue\n" +
                    "Type no and enter if you are to scared and want to exit the game");
            yesOrNo = scanner.next();
            //printYesNoChoices(); commented out as this just got the while-loop infinite
            validInput = controller.handleYesOrNo(yesOrNo); //inserted isntead of printYesNoChoices();

        }
        return yesOrNo;
    }

    //prints combat options
    public void printCombatOptions() {
        System.out.println("\n\tWhat would you like to do?");
        System.out.println("\t1. Attack");
        System.out.println("\t2. Drink health potion");
        System.out.println("\t3. RUN!");
    }


    private void startGame() {
        controller.createEnemyList();
        printSeparator();
        System.out.println("You enter your first dungeon");
        boolean running = true;


        //label for while loop to tell the program to iterate back to start
        Game:
        while (running) {
            printSeparator();
            Character enemy = controller.getNextEnemy();
            Character player = controller.getPlayer();
            int enemyCurrentHp = enemy.getHp();
            int playerCurrentHp = player.getHp();
            System.out.println("\t# Enemy " + enemy.getCharacterName() + " with " + enemyCurrentHp + " HP" +
                    " has appeared! #\n");

            while (enemyCurrentHp > 0) {
                System.out.println("\tYour HP: " + playerCurrentHp);
                System.out.println("\tEnemy HP: " + enemyCurrentHp);
                printCombatOptions();
                int input;

                //checks if the input is a int, if not calls the print
                boolean validInput = false;
                while (!validInput) {
                    try {
                        input = scanner.nextInt();
                    } catch (InputMismatchException e) {
                        printInvalidInput();
                        printCombatOptions();
                    }
                    validInput = true;
                }

            /*
            //Checking if healthpotion dropped
            boolean newHealthpotion = controller.luckyDrop();
            if (newHealthpotion) {
                System.out.println("The enemy dropped a healthpotion and you pick it up!");
                System.out.println("You now have " + " healthpotion(s)");
            } else {
                System.out.println("No loot");

                break;

                //TODO Continue here
            }*/
            }
        }
    }
}



