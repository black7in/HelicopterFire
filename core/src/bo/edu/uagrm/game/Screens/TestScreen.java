package bo.edu.uagrm.game.Screens;

import com.badlogic.gdx.Gdx;

import bo.edu.uagrm.game.Controllers.InputManager;
import bo.edu.uagrm.game.HelicopterShotGame;
import bo.edu.uagrm.game.Utilities.AbstractScreen;

public class TestScreen extends AbstractScreen {

    public TestScreen(HelicopterShotGame game) {
        super(game);
    }

    InputManager inputProcessor;
    @Override
    public void show() {
        inputProcessor = new InputManager();

        Gdx.input.setInputProcessor(inputProcessor);
    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void hide() {

    }
}
