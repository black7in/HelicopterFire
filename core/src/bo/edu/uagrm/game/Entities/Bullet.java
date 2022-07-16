package bo.edu.uagrm.game.Entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Bullet extends Actor {
    Texture texture;

    private float position_x;
    private float position_y;

    public Bullet(float position_x, float position_y){
        texture = new Texture("Bullets/BULLET-1.png");
        this.position_x = position_x;
        this.position_y = position_y;
    }

    @Override
    public void draw(Batch batch, float parentAlpha){
        batch.draw(texture, position_x, position_y, 50, 25);
    }

    @Override
    public void act(float delta){
        float deltaTime = Math.min(Gdx.graphics.getDeltaTime(), 1 / 60f);
        position_x +=  2 + deltaTime;

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
