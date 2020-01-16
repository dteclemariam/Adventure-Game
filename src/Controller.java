import java.util.ArrayList;
import java.util.Random;

public class Controller {
    //Creating array with enemietypes and their text complimenting attack
    private String[] enemyTypes = {"Skelleton", "Mage", "Assassin", "Warrior", "Zoombie", "Werewolf"};
    private String[] complimentingText = {"with a club", "while whispering a spell", "with a poisoned arrow",
            "with a mighty war cry", "with a hunger for braaaains", "with a loud howl"};
    ArrayList<Characters> enemies = new ArrayList<>();
    Random random = new Random();

    //stats
    private int cavesCompleted = 0;


    //player stats
    private int hp = 100;
    private int attackDamage = 100;
    private int numbHealthPotions = 3;
    private String battleCry = "Rooooar";

    //Enemy variables
    private int enemyHP = 75;
    private int enemyAttackDamage = 75;
    private int healthPotionDropChance = 50;

    public int getNumbHealthPotions() {
        return numbHealthPotions;
    }

    //creates enemies and fills array with enemies
    public void createEnemyList() {
        for (int i = 0; i < enemyTypes.length; i++) {
            Enemy enemy = new Enemy(enemyTypes[i], enemyHP, enemyAttackDamage, complimentingText[i]);
            enemies.add(enemy);
        }
    }

    public void createPlayer(String name) {
        Player player = new Player(name, hp, attackDamage, battleCry);
    }

    public Boolean handleYesOrNo(String input) {
        if (input.equalsIgnoreCase("yes")) {
            return true;
        } else if (input.equalsIgnoreCase("no")) {
            exit();
            return null;
        }else{
            return false;
        }
    }

    //method for closing game
    public void exit() {
        System.out.println("The game is exiting");
        System.exit(0);
    }

    //returns a random enemy form the array and removes the enemy from the array
    public Characters getNextEnemy() {
        int index = random.nextInt(enemies.size());
        Characters enemy = enemies.get(index);
        enemies.remove(index);
        return enemy;
    }

    public boolean luckyDrop() {
        if (random.nextInt(100) > healthPotionDropChance) {
            numbHealthPotions++;
            return true;
        } else {
            return false;
        }
    }
}



