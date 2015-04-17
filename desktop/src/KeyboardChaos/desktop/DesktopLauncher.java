package KeyboardChaos.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import control.KeyboardChaosControl;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		
		config.title = "Keyboard Chaos";
		config.width = models.KCVars.GAME_WIDTH;
		config.height = models.KCVars.GAME_HEIGHT;
		config.resizable = false;
		
		new LwjglApplication(new KeyboardChaosControl(), config);
	}
}