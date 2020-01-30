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
        String choice = yesOrNoChoice();
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
    public String yesOrNoChoice() {
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
    public int combatOptionsChoice() {
        /*System.out.println("\n\tWhat would you like to do?");
        System.out.println("\t1. Attack");
        System.out.println("\t2. Drink health potion");
        System.out.println("\t3. RUN!");
        */
        int input = 0;
        boolean validInput = false;
        //checks if the input is a int, if not calls the print
        while (!validInput) {
            try {
                System.out.println("\n\tWhat would you like to do?");
                System.out.println("\t1. Attack");
                System.out.println("\t2. Drink health potion");
                System.out.println("\t3. RUN!");
                input = scanner.nextInt();
                validInput = controller.handleCombatInput(input);
            } catch (InputMismatchException e) {
                printInvalidInput();
                combatOptionsChoice();
            }
        }
        return input;
    }

    //prints player attack on enemy
    public void printPlayerAttack() {
        System.out.println("You attack the " + controller.currentEnemy.getCharacterName() + " while yelling " +
                controller.player.getBattleCry() + "\n\tYou do " + controller.playerAttack() + " damage to "
                + controller.currentEnemy.getCharacterName() + "\n");
        if (controller.currentEnemy.getHp() > 0) {
            printEnemyAttack();
        }
    }

    //print enemy attack on player
    public void printEnemyAttack() {
        System.out.println(controller.currentEnemy.getCharacterName() + " attacks you for " + controller.enemyAttack()
                + " damage " + controller.currentEnemy.getBattleCry());
    }

    private void startGame() {
        boolean running = true;
        controller.createEnemyList();
        printSeparator();
        System.out.println("You enter your first dungeon");


        //While player hp > 0 and there are more enemies left in the enemiesList
        while (running) {
            printSeparator();
            controller.getNextEnemy();
            System.out.println("\t# Enemy " + controller.currentEnemy.getCharacterName() + " with "
                    + controller.currentEnemy.getHp() + " HP" + " has appeared! #\n");
            combat();
            running = controller.gameRunning();
        }

        //The while loop has ended and the if checks if you won or were defeated
        if(controller.enemiesList.isEmpty()){
            printSeparator();
            System.out.println("\t#There are no enemies left, YOU WIN!");
            printSeparator();
        }else {
            printSeparator();
            System.out.println("\t#You have no HP left!\n\t#You have been defeated - GAME OVER!");
            printSeparator();
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

    public void combat() {
        do {
            System.out.println("\tYour HP: " + controller.player.getHp());
            System.out.println("\tEnemy HP: " + controller.currentEnemy.getHp());
            int input = combatOptionsChoice();
            if (input == 1) {
                printSeparator();
                printPlayerAttack();
                printSeparator();
            }
        } while (controller.currentEnemy.getHp() > 0 && controller.player.getHp() > 0);
        if (controller.currentEnemy.getHp() == 0) {
            System.out.println("The " + controller.currentEnemy.getCharacterName() + " have been defeated!" +
                    "\nYou continue to the next dungeon!");
        }
    }
}



