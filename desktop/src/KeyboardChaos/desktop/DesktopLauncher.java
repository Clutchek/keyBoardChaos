package KeyboardChaos.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import controller.KeyboardChaosRun;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		
		config.title = "Keyboard Chaos";
		config.width = controller.KCConstants.GAME_WIDTH;
		config.height = controller.KCConstants.GAME_HEIGHT;
		config.resizable = false;
		
		new LwjglApplication(new KeyboardChaosRun(), config);
	}
}