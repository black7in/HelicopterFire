package bo.edu.uagrm.game.Entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

import java.util.Random;

public class Rocket extends Actor {
    TextureAtlas textureAtlas;
    Animation animation;
    float delta;
    private float position_x;
    private float position_y;

    private float tiempoDesvio;
    private boolean direccionDesvio;

    public Rocket(float position_x, float position_y){
        textureAtlas = new TextureAtlas(Gdx.files.internal("Rocket/Rocket.atlas"));
        animation = new Animation(1/15f, textureAtlas.getRegions());
        this.position_x = position_x;
        this.position_y = position_y;
        tiempoDesvio = 3;
        Random r = new Random();
        direccionDesvio = r.nextBoolean();
    }

    @Override
    public void draw(Batch batch, float parentAlpha){
        delta += Gdx.graphics.getDeltaTime();
        batch.draw((TextureRegion) animation.getKeyFrame(delta, true), position_x, position_y, 90, 45);
    }

    @Override
    public void act(float delta){
        float deltaTime = Math.min(Gdx.graphics.getDeltaTime(), 1 / 60f);
        tiempoDesvio -= deltaTime;
        position_x +=  2 + deltaTime;
        if(tiempoDesvio > 0){
            if(direccionDesvio)
                position_y += 1 + deltaTime;
            else
                position_y -= 1 - deltaTime;
        }

        if(position_x >= Gdx.graphics.getWidth())
            remove();
    }

    public float getPosition_x() {
        return position_x;
    }

    public void setPosition_x(float position_x) {
        this.position_x = position_x;
    }

    public float getPosition_y() {
        return position_y;
    }

    public void setPosition_y(float position_y) {
        this.position_y = position_y;
    }
}
