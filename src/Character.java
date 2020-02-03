public abstract class Character {
    String characterName;
    String battleCry;
    int minAttackDamage;
    int maxAttackDamage;
    int hp;

    public Character(String characterName, String battleCry, int minAttackDamage, int maxAttackDamage, int hp) {
        this.characterName = characterName;
        this.battleCry = battleCry;
        this.minAttackDamage = minAttackDamage;
        this.maxAttackDamage = maxAttackDamage;
        this.hp = hp;
    }

    public String getCharacterName() {
        return characterName;
    }

    public int getHp() {
        return hp;
    }

    public void setHP(int hp) {
        this.hp = hp;
    }

    public String getBattleCry() {
        return battleCry;
    }

    public int getMinAttackDamage() {
        return minAttackDamage;
    }

    public int getMaxAttackDamage() {
        return maxAttackDamage;
    }

    public void damageTaken(int damage) {
        if (hp - damage < 0) {
            hp = 0;
        } else hp = hp - damage;
    }

    public void heal(int healingAmount) {
        this.hp += healingAmount;
    }
}
