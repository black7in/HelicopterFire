package bo.edu.uagrm.game.Entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Helicopter extends Actor {
    private TextureAtlas textureAtlas;
    private Animation animation;
    private float delta;

    private float position_x;
    private float position_y;
    private float speed;
    private boolean moveUp;
    private boolean moveDown;
    private boolean shootingBullet;
    private  boolean shootingRocket;

    public Helicopter(float position_x, float position_y){
        textureAtlas = new TextureAtlas(Gdx.files.internal("Helicopter/HelicoperEnemy-Fly/HelycopterEnemy-Fly.atlas"));
        animation = new Animation(1/15f, textureAtlas.getRegions());
        setSize(200, 120);
        //setPosition(0,(Gdx.graphics.getHeight() / 2) - 60);

        this.position_x = position_x;
        this.position_y = position_y;
        speed = 3;
    }

    @Override
    public void draw(Batch batch, float parentAlpha){
        delta += Gdx.graphics.getDeltaTime();
        batch.draw((TextureRegion) animation.getKeyFrame(delta, true), position_x, position_y, getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
    }

    @Override
    public void act(float delta){
        float deltaTime = Math.min(Gdx.graphics.getDeltaTime(), 1 / 60f);
        position_x -=  speed - deltaTime;

        if(position_x <= 0)
            remove();
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }
}
