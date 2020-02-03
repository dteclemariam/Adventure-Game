public class GameVariables {

    //Game variables
    private int cavesCompleted = 0;
    private int healthPotionDropChance = 50; //Percent
    private int healthPotionHealingAmount = 40;
    //Enemy variables
    private int enemyMinHP = 50;
    private int enemyMaxHP = 75;
    private int enemyMinAttackDamage = 25;
    private int enemyMaxAttackDamage = 50;
    //Player variables
    private int startingAmmountOfHealtPotions = 3;
    private int minAttackDamage = 50;
    private int maxAttackDamage = 100;
    private int hp = 100;

    //Creates to arrays, one with enemietypes and one with complimenting text to their attack
    private String[] enemyTypes = {"Skelleton", "Mage", "Assassin", "Warrior", "Zoombie", "Werewolf"};
    private String[] complimentingText = {"with a club", "while whispering a spell", "with a poisoned arrow",
            "with a mighty war cry", "with a hunger for braaaains", "with a loud howl"};

    public GameVariables() {
    }

    public int getCavesCompleted() {
        return cavesCompleted;
    }

    public int getHealthPotionDropChance() {
        return healthPotionDropChance;
    }

    public int getEnemyMinHP() {
        return enemyMinHP;
    }

    public int getEnemyMaxHP() {
        return enemyMaxHP;
    }

    public int getEnemyMinAttackDamage() {
        return enemyMinAttackDamage;
    }

    public int getEnemyMaxAttackDamage() {
        return enemyMaxAttackDamage;
    }

    public int getStartingAmmountOfHealtPotions() {
        return startingAmmountOfHealtPotions;
    }

    public int getMinAttackDamage() {
        return minAttackDamage;
    }

    public int getMaxAttackDamage() {
        return maxAttackDamage;
    }

    public String[] getEnemyTypes() {
        return enemyTypes;
    }

    public String[] getComplimentingText() {
        return complimentingText;
    }

    public int getHp() {
        return hp;
    }

    public int getHealthPotionHealingAmount() {
        return healthPotionHealingAmount;
    }


}
