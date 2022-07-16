package bo.edu.uagrm.game.Controllers;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.utils.TimeUtils;

import bo.edu.uagrm.game.Entities.Bullet;
import bo.edu.uagrm.game.Entities.Rocket;


public class InputManager extends InputAdapter {
    private GameManager gameManager;


    public void setGameManager(GameManager gameManager){
        this.gameManager = gameManager;
    }

    @Override
    public boolean keyDown (int keycode) {
        switch (keycode){
            case Input.Keys.W:
                if(!gameManager.getStage().getPlayer().isMoveDown()) {
                    gameManager.getStage().getPlayer().setMoveUp(true);
                }
                break;
            case Input.Keys.S:
                if(!gameManager.getStage().getPlayer().isMoveUp()) {
                    gameManager.getStage().getPlayer().setMoveDown(true);
                }
                break;
            case Input.Keys.SPACE:
                // aqui dispara
                if(!gameManager.getStage().getPlayer().isShootingBullet()) {
                    gameManager.getStage().getPlayer().setShootingBullet(true);
                    gameManager.getStage().addActor(new Bullet(gameManager.getStage().getPlayer().getX() + 120, gameManager.getStage().getPlayer().getY() + 20));
                    gameManager.setShotBulletTimeStart(TimeUtils.millis());
                }
                break;
            case Input.Keys.F:
                if(!gameManager.getStage().getPlayer().isShootingRocket()) {
                    gameManager.getStage().getPlayer().setShootingRocket(true);
                    gameManager.getStage().addActor(new Rocket(gameManager.getStage().getPlayer().getX() + 120, gameManager.getStage().getPlayer().getY() + 20));
                    gameManager.setShotRocketBulletTimeStart(TimeUtils.millis());
                }
                break;
            default:
                break;
        }
        return true;
    }

    @Override
    public boolean keyUp(int keycode){
        switch (keycode){
            case Input.Keys.W:
                gameManager.getStage().getPlayer().setMoveUp(false);
                break;
            case Input.Keys.S:
                gameManager.getStage().getPlayer().setMoveDown(false);
                break;
            default:
                break;
        }
        return true;
    }
}
