import java.util.ArrayList;

public class Controller {
    //Creating enemies
    //TODO cl
    private String [][] enemyTypes = {{"Skelleton", "Mage", "Assassin", "Warrior", "Zoombie", "Werewolf" },
    {"with a club", "while whispering a spell", "with a poisoned arrow", "with a mighty war cry",
            "with a hunger for braaaains", "with a loud howl"}};

    public void test(){
        for (int i = 0; i < enemyTypes.length; i++) {
            System.out.println(enemyTypes[i][i]);
        }
    }

    public void createEnemyList(){
        ArrayList<Characters> enemies = new ArrayList<>();
    }

    public void createPlayer(String name){

    }

}
