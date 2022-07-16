package bo.edu.uagrm.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

import bo.edu.uagrm.game.Controllers.GameManager;
import bo.edu.uagrm.game.Controllers.InputManager;
import bo.edu.uagrm.game.Entities.Background;
import bo.edu.uagrm.game.Entities.Player;
import bo.edu.uagrm.game.HelicopterShotGame;
import bo.edu.uagrm.game.Utilities.AbstractScreen;
import bo.edu.uagrm.game.Utilities.Render;
import bo.edu.uagrm.game.Utilities.Scene;

public class GameScreen extends AbstractScreen {
    private Player player;
    private Background bg;
    Scene stage;

    BitmapFont bitmapFont;

    GameManager gameManager;
    InputManager inputProcessor;
    public GameScreen(HelicopterShotGame game) {
        super(game);
        inputProcessor = new InputManager();
        Gdx.input.setInputProcessor(inputProcessor);
    }

    @Override
    public void show() {
        stage = new Scene();
        player = new Player();
        bg = new Background();

        bitmapFont = new BitmapFont();
        gameManager = new GameManager();
        gameManager.setStage(stage);
        gameManager.getStage().setPlayer(player);

        inputProcessor.setGameManager(gameManager);
        gameManager.start();
        gameManager.setGameStart(true);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Render.batch.begin();
        bg.draw(Render.batch, Gdx.graphics.getDeltaTime());
        player.draw(Render.batch, Gdx.graphics.getDeltaTime());
        /*bitmapFont.setColor(0.0f, 0.0f, 0.0f, 1.0f);
        bitmapFont.draw(Render.batch, "score: 0", 0, 0);*/
        Render.batch.end();

        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void hide() {
        stage.dispose();
    }
}
