package bo.edu.uagrm.game.Entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Background extends Actor {
    private Texture bg1;
    private  Texture bg2;

    private final float MOVE_SPEED = 2;
    private float positionX;
    private float width;
    private float height;

    float delta;

    public Background(){
        bg1 = new Texture("Backgrounds/Background.jpg");
        bg2 = new Texture("Backgrounds/Background.jpg");

        width = Gdx.graphics.getWidth();
        height = Gdx.graphics.getHeight();

        setSize(width, height);
        setName("BG");
    }

    @Override
    public void draw (Batch batch, float parentAlpha) {
        delta += Gdx.graphics.getDeltaTime();
        batch.draw(bg1, positionX, 0, width, height);
        batch.draw(bg2, positionX + width, 0, width, height);

        positionX -= MOVE_SPEED;

        if(positionX + width == 0){
            positionX = 0;
        }
    }
}
