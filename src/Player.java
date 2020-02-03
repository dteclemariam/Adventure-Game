public class Player extends Character {

    private int numHealthPotions = 0;

    public Player(String characterName, String battleCry, int minAttackDamage, int maxAttackDamage, int hp,
                  int startingNumbHealthPotions) {
        super(characterName, battleCry, minAttackDamage, maxAttackDamage, hp);
        this.numHealthPotions = startingNumbHealthPotions;
    }

    public int getNumHealthPotions() {
        return numHealthPotions;
    }

    public void increaseNumbHealthPotions() {
        this.numHealthPotions++;
    }

    public void decreaseNumHealthPotions() {
        this.numHealthPotions--;
    }

}

