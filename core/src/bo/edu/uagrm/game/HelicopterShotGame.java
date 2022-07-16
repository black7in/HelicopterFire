package bo.edu.uagrm.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import bo.edu.uagrm.game.Screens.GameScreen;
import bo.edu.uagrm.game.Screens.LoadScreen;
import bo.edu.uagrm.game.Screens.MenuScreen;
import bo.edu.uagrm.game.Screens.TestScreen;
import bo.edu.uagrm.game.Utilities.Render;

public class HelicopterShotGame extends Game {

	public AssetManager manager = new AssetManager();

	@Override
	public void create () {
		Render.batch = new SpriteBatch();
		this.setScreen(new LoadScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		Render.batch.dispose();
	}
}
