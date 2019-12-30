public abstract class Characters {
    String characterName;
    int hp;
    int attackDamage;
    String battleCry;

    public Characters(String characterName, int hp, int attackDamage, String battleCry) {
        this.characterName = characterName;
        this.hp = hp;
        this.attackDamage = attackDamage;
        this.battleCry = battleCry;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }

    public String getBattleCry() {
        return battleCry;
    }

    public void setBattleCry(String battleCry) {
        this.battleCry = battleCry;
    }

    public void attack(){
    }
}
