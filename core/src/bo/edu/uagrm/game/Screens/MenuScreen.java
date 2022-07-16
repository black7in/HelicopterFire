package bo.edu.uagrm.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import bo.edu.uagrm.game.Entities.Helicopter;
import bo.edu.uagrm.game.HelicopterShotGame;
import bo.edu.uagrm.game.Utilities.AbstractScreen;

public class MenuScreen extends AbstractScreen {
    private Stage stage;
    private TextureAtlas textureAtlas;
    private TextureRegion textureRegion;
    private Image bg;
    private Image buttonStart;
    private Image buttonExit;
    private Image logo;

    private Helicopter helicopter;
    private Helicopter helicopter2;
    private Helicopter helicopter3;

    public MenuScreen(HelicopterShotGame game) {
        super(game);
    }

    @Override
    public void show() {
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        textureAtlas = new TextureAtlas(Gdx.files.internal("Menu/buttons-menu.atlas"));
        bg = new Image(new Texture("Backgrounds/Bg2.png"));
        buttonStart = new Image((textureAtlas.findRegion("button-start")));
        buttonExit = new Image((textureAtlas.findRegion("button-exit")));
        logo = new Image(textureAtlas.findRegion("logo"));

        helicopter = new Helicopter(Gdx.graphics.getWidth() - 200, (Gdx.graphics.getHeight()/ 2) + 130);
        helicopter2 = new Helicopter(Gdx.graphics.getWidth() - 200, (Gdx.graphics.getHeight()/ 2) + 240);
        helicopter3 = new Helicopter(Gdx.graphics.getWidth() - 200, (Gdx.graphics.getHeight()/ 2) - 20);
        helicopter2.setSpeed(1);
        helicopter3.setSpeed(2);

        stage.addActor(bg);
        stage.addActor(logo);
        stage.addActor(buttonExit);
        stage.addActor(buttonStart);
        stage.addActor(helicopter);
        stage.addActor(helicopter2);
        stage.addActor(helicopter3);

        buttonStart.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new GameScreen(game));
            }
        });

        buttonExit.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.exit();
            }
        });

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        //logo.setSize(400, 120);
        logo.setPosition(400, 290);
        bg.setSize(stage.getWidth(), stage.getHeight());
        buttonStart.setSize(300, 100);
        buttonExit.setSize(300, 100);

        buttonStart.setPosition(450, 150);
        buttonExit.setPosition(450, 30);
    }

    @Override
    public void hide() {
        stage.dispose();
    }
}
