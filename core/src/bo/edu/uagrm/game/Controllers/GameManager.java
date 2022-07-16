package bo.edu.uagrm.game.Controllers;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.TimeUtils;

import java.sql.Time;
import java.util.Random;

import bo.edu.uagrm.game.Entities.Bullet;
import bo.edu.uagrm.game.Entities.Helicopter;
import bo.edu.uagrm.game.Utilities.Scene;

public class GameManager extends Thread{
    private Scene stage;

    private boolean gameStart;
    private long shotBulletTimeStart;
    private long shotRocketBulletTimeStart;
    private long timeNextSpawn;
    private long timeSpawn;

    private final float[] pos = { 0, 130, 390, 520, 650};

    Random random;
    public GameManager(){
        gameStart = false;
        timeNextSpawn = 2000;
        timeSpawn = TimeUtils.millis() + timeNextSpawn;
        random = new Random();
    }

    @Override
    public void run(){
        while(true) {
            if(gameStart){
                if(stage.getPlayer().getY() == (Gdx.graphics.getHeight() / 2) - 60){
                    //System.out.println("Pos inicial");
                    //stage.getPlayer().remove();
                }

                if(stage.getPlayer().isShootingBullet()){
                    long elapsedTime = TimeUtils.timeSinceMillis(shotBulletTimeStart);
                    if(elapsedTime >= 1200){
                        getStage().getPlayer().setShootingBullet(false);
                    }
                }

                if(stage.getPlayer().isShootingRocket()){
                    long elapsedTime = TimeUtils.timeSinceMillis(shotRocketBulletTimeStart);
                    if(elapsedTime >= 6000){
                        getStage().getPlayer().setShootingRocket(false);
                    }
                }

                long elapsedTimeSpawn = TimeUtils.timeSinceMillis(timeSpawn);
                if(elapsedTimeSpawn >= timeNextSpawn){
                    int ran = random.nextInt(5);
                    getStage().addEnemyActor(Gdx.graphics.getWidth() - 200, pos[ran], random.nextInt(5 - 2 + 1) + 2);
                    timeNextSpawn = random.nextInt(2000 - 1000 + 1000) + 1000;
                    timeSpawn = TimeUtils.millis() + timeNextSpawn;
                }

            }
        }
    }
    public Scene getStage(){
        return stage;
    }

    public void setStage(Scene stage){
        this.stage = stage;
    }

    public boolean isGameStart(){
        return gameStart;
    }

    public void setGameStart(boolean gameStart){
        this.gameStart = gameStart;
    }

    public void check(){
        System.out.println("GOOD check");
    }

    public void setShotBulletTimeStart(long shotBulletTimeStart) {
        this.shotBulletTimeStart = shotBulletTimeStart;
    }

    public void setShotRocketBulletTimeStart(long shotRocketBulletTimeStart) {
        this.shotRocketBulletTimeStart = shotRocketBulletTimeStart;
    }
}
