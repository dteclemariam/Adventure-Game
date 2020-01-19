import java.util.ArrayList;
import java.util.Random;

public class Controller {

    GameVariables gameVariables = new GameVariables();
    Random random = new Random();
    ArrayList<Character> enemiesList = new ArrayList<>();
    Player player;


    //returns a random number between 0 and parameter(exclusive)
    private int getRandomNumber(int maxValue){
        return random.nextInt(maxValue);
    }

    //return a random number between parameters minvalue(inclusive and maxvalue(inclusive)
    private int getRandomNumber(int maxValue, int minValue){
        return random.nextInt((maxValue - minValue) + 1) + minValue;
    }

    //creates enemies and fills array with enemies
    public void createEnemyList() {
        String[] enemyTypes = gameVariables.getEnemyTypes();
        String[] complimentingText = gameVariables.getComplimentingText();
        for (int i = 0; i < enemyTypes.length; i++) {
            int enemyHP = getRandomNumber(gameVariables.getEnemyMaxHP(), gameVariables.getEnemyMinHP());
            Enemy enemy = new Enemy(enemyTypes[i], complimentingText[i], gameVariables.getMinAttackDamage(),
                    gameVariables.getMaxAttackDamage(), enemyHP) ;
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
        }else{
            return false;
        }
    }

    //handles input from user during combat and returns a boolean
    /*public boolean handleCombatInput(int input){
        if(input = 1){
            return true;
        }
    }*/

    //method for closing game
    public void exit() {
        System.out.println("The game is exiting");
        System.exit(0);
    }

    //returns a random enemy form the array and removes the enemy from the array
    public Character getNextEnemy() {
        int index = getRandomNumber(enemiesList.size());
        Character enemy = enemiesList.get(index);
        enemiesList.remove(index);
        return enemy;
    }

    //return a player object
    public Character getPlayer(){
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
}



