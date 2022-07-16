package bo.edu.uagrm.game.Entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Player extends Actor {
    private TextureAtlas textureAtlas;
    private Animation animation;
    private float delta;

    private boolean moveUp;
    private boolean moveDown;
    private boolean shootingBullet;
    private  boolean shootingRocket;

    public Player(){
        textureAtlas = new TextureAtlas(Gdx.files.internal("Helicopter/Helicopter-Fly/Helicopter-Fly.atlas"));
        animation = new Animation(1/15f, textureAtlas.getRegions());
        setSize(200, 120);
        setPosition(0,(Gdx.graphics.getHeight() / 2) - 60);
        shootingBullet = false;
    }

    @Override
    public void draw(Batch batch, float parentAlpha){
        delta += Gdx.graphics.getDeltaTime();

            if (moveUp && getY() <= 680) {
                float deltaTime = Math.min(Gdx.graphics.getDeltaTime(), 1 / 60f);
                setPosition(getX(), getY() + 2 + deltaTime);
            } else if (moveDown && getY() >= 0) {
                float deltaTime = Math.min(Gdx.graphics.getDeltaTime(), 1 / 60f);
                setPosition(getX(), getY() - 2 - deltaTime);
            }


        batch.draw((TextureRegion) animation.getKeyFrame(delta, true), getX(), getY(), getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
    }

    public boolean isMoveUp(){
        return moveUp;
    }

    public void setMoveUp(boolean moveUp){
        this.moveUp  = moveUp;
    }

    public boolean isMoveDown(){
        return moveDown;
    }

    public void setMoveDown(boolean moveDown){
        this.moveDown = moveDown;
    }

    public  boolean isShootingBullet(){
        return shootingBullet;
    }

    public void setShootingBullet(boolean shootingBullet) {
        this.shootingBullet = shootingBullet;
    }

    public boolean isShootingRocket(){
        return shootingRocket;
    }

    public void setShootingRocket(boolean shootingRocket){
        this.shootingRocket = shootingRocket;
    }
}
