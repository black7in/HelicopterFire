package bo.edu.uagrm.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import bo.edu.uagrm.game.HelicopterShotGame;
import bo.edu.uagrm.game.Utilities.AbstractScreen;
import bo.edu.uagrm.game.Entities.LoadingBar;

public class LoadScreen extends AbstractScreen {

    Stage stage;
    private TextureAtlas textureAtlas;
    private Image logo;
    private Image loadingFrame;
    private Image loadingBarHidden;
    private Image screenBg;
    private Image loadingBg;

    private Actor loadingBar;

    private float startX, endX;
    private float percent;

    public LoadScreen(HelicopterShotGame game) {
        super(game);
    }

    @Override
    public void show() {
        stage = new Stage();
        textureAtlas = new TextureAtlas(Gdx.files.internal("Loader/loader.atlas"));
        logo = new Image(textureAtlas.findRegion("logo"));
        loadingFrame = new Image(textureAtlas.findRegion("loading-frame"));
        loadingBarHidden = new Image(textureAtlas.findRegion("loading-bar-hidden"));
        screenBg = new Image(textureAtlas.findRegion("screen-bg"));
        loadingBg = new Image(textureAtlas.findRegion("loading-frame-bg"));

        Animation anim = new Animation(0.05f, textureAtlas.findRegions("loading-bar-anim") );
        anim.setPlayMode(Animation.PlayMode.LOOP);
        loadingBar = new LoadingBar(anim);

        stage.addActor(screenBg);
        stage.addActor(loadingBar);
        stage.addActor(loadingBg);
        stage.addActor(loadingBarHidden);
        stage.addActor(loadingFrame);
        stage.addActor(logo);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if( percent >= 0.99) {
            //if (Gdx.input.isTouched() || Gdx.input.isKeyJustPressed(0)) {
                // cambio de pantalla
                game.setScreen(new MenuScreen(game));
            //}
        }

        percent = Interpolation.linear.apply(percent, game.manager.getProgress(), 0.01f);

        loadingBarHidden.setX(startX + endX * percent);
        loadingBg.setX(loadingBarHidden.getX() + 30);
        loadingBg.setWidth(450 - 450 * percent);
        loadingBg.invalidate();

        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        width = 480 * width / height;
        height = 480;

        screenBg.setSize(1200, 800);

        logo.setX((width - logo.getWidth()) / 2 + 240);
        logo.setY((height - logo.getHeight()) / 2 + 240);

        loadingFrame.setX((stage.getWidth() - loadingFrame.getWidth()) / 2);
        loadingFrame.setY((stage.getHeight() - loadingFrame.getHeight()) / 2);

        loadingBar.setX(loadingFrame.getX() + 15);
        loadingBar.setY(loadingFrame.getY() + 5);

        loadingBarHidden.setX(loadingBar.getX() + 35);
        loadingBarHidden.setY(loadingBar.getY() - 3);

        startX = loadingBarHidden.getX();
        endX = 440;

        loadingBg.setSize(450, 50);
        loadingBg.setX(loadingBarHidden.getX() + 30);
        loadingBg.setY(loadingBarHidden.getY() + 3);
    }

    @Override
    public void hide() {
        stage.dispose();
    }


}
