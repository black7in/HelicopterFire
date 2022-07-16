package bo.edu.uagrm.game.Utilities;

import com.badlogic.gdx.Screen;

import bo.edu.uagrm.game.HelicopterShotGame;

public abstract class AbstractScreen implements Screen {
    protected HelicopterShotGame game;

    public AbstractScreen(HelicopterShotGame game) {
        this.game = game;
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
    }
}
