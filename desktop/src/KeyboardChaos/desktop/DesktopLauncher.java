package KeyboardChaos.desktop;

import old.control.KeyboardChaosControl;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		
		config.title = "Keyboard Chaos";
		config.width = old.models.KCVars.GAME_WIDTH;
		config.height = old.models.KCVars.GAME_HEIGHT;
		config.resizable = false;
		
		new LwjglApplication(new KeyboardChaosControl(), config);
	}
}