import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Controller {

    GameVariables gameVariables = new GameVariables();
    Random random = new Random();
    ArrayList<Character> enemiesList = new ArrayList<>();
    Player player;
    Character currentEnemy;


    //returns a random number between 0 and parameter(exclusive)
    private int getRandomNumber(int maxValue) {
        return random.nextInt(maxValue);
    }

    //return a random number between parameters minvalue(inclusive and maxvalue(inclusive)
    private int getRandomNumber(int maxValue, int minValue) {
        return random.nextInt((maxValue - minValue) + 1) + minValue;
    }

    //creates enemies and fills array with enemies
    public void createEnemyList() {
        String[] enemyTypes = gameVariables.getEnemyTypes();
        String[] complimentingText = gameVariables.getComplimentingText();
        for (int i = 0; i < enemyTypes.length; i++) {
            int enemyHP = getRandomNumber(gameVariables.getEnemyMaxHP(), gameVariables.getEnemyMinHP());
            Enemy enemy = new Enemy(enemyTypes[i], complimentingText[i], gameVariables.getEnemyMinAttackDamage(),
                    gameVariables.getEnemyMaxAttackDamage(), enemyHP);
            enemiesList.add(enemy);
        }
    }

    //Creates player
    public void createPlayer(String name, String battleCry) {
        player = new Player(name, battleCry, gameVariables.getMinAttackDamage(), gameVariables.getMaxAttackDamage(),
                gameVariables.getHp(), gameVariables.getStartingAmmountOfHealtPotions());
    }

    //handles input from user and returns a boolean
    public Boolean handleYesOrNo(String input) {
        if (input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("no")) {
            return true;
        } else {
            return false;
        }
    }

    //handles input from user during combat and returns a boolean
    public boolean handleCombatInput(int input) {
        if (input == 1 || input == 2 || input == 3) {
            //Attack
            return true;
        /*}else if (input == 2){
            //Drink health potion
            return true;
        }else if (input == 3){
            //Run
            return true;*/
        } else return false;
    }

    //method for closing game
    public void exit() {
        System.out.print("The game is exiting..");
        //10 sec delay on close
        int seconds = 10;
        try {
            for (int i = 0; i < seconds; i++) {
                TimeUnit.SECONDS.sleep(1);
                System.out.print(".");
            }
        }catch (InterruptedException ie){
            Thread.currentThread().interrupt();
        }
            System.exit(0);
    }


    //picks a random enemy from the arraylist
    public void getNextEnemy() {
        int index = getRandomNumber(enemiesList.size());
        currentEnemy = enemiesList.get(index);
        enemiesList.remove(index);
    }

    //return a player object
    public Character getPlayer() {
        return player;
    }

    //uses random 0-100, if its above 50 the enemy drops a health potion
    public boolean luckyDrop() {
        if (random.nextInt(100) > gameVariables.getHealthPotionDropChance()) {
            player.increaseNumbHealthPotions();
            return true;
        } else {
            return false;
        }
    }

    //Method to see if check if there are more enemies left or the player has more than 0hp.
    public boolean gameRunning() {
        if (player.getHp() > 0 && !enemiesList.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public int playerAttack() {
        int playerAttackaDamage = random.nextInt((player.getMaxAttackDamage() - player.getMinAttackDamage()) + 1)
                + player.getMinAttackDamage();
        currentEnemy.damageTaken(playerAttackaDamage);
        return playerAttackaDamage;
    }

    public int enemyAttack() {
        int enemyAttackDamage = random.nextInt((currentEnemy.getMaxAttackDamage()
                - currentEnemy.getMinAttackDamage()) + 1) + currentEnemy.getMinAttackDamage();
        player.damageTaken(enemyAttackDamage);
        return enemyAttackDamage;
    }

    public boolean drinkHealthPotion() {
        if (player.getNumHealthPotions() > 0) {
            player.heal(gameVariables.getHealthPotionHealingAmount());
            player.decreaseNumHealthPotions();
            return true;
        } else {
            return false;
        }
    }
}



