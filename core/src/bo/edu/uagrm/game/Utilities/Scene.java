package bo.edu.uagrm.game.Utilities;

import com.badlogic.gdx.scenes.scene2d.Stage;

import bo.edu.uagrm.game.Entities.Helicopter;
import bo.edu.uagrm.game.Entities.Player;

public class Scene extends Stage {
    private Player player;

    private boolean addEnemy;

    private float position_x, position_y, speed;

    @Override
    public  void draw(){
        super.draw();
        if(addEnemy){
            Helicopter helicopter = new Helicopter(position_x, position_y );
            helicopter.setSpeed(speed);
            addActor(helicopter);
            addEnemy = false;
        }
    }

    public void setPlayer(Player player){
        this.player = player;
    }

    public Player getPlayer(){
        return player;
    }

    public void check(){
        System.out.println("GOOD CHECK");
    }

    public void addEnemyActor(float position_x, float position_y, float speed){
        setAddEnemy(true);
        this.position_x = position_x;
        this.position_y = position_y;
        this.speed = speed;

    }

    public boolean isAddEnemy() {
        return addEnemy;
    }

    public void setAddEnemy(boolean addAct) {
        this.addEnemy = addAct;
    }

}
