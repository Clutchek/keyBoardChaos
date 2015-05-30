package KeyboardChaos.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import edu.chl.KeyboardChaos.Main;
import edu.chl.KeyboardChaos.util.KCConstants;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		
		config.title = "Keyboard Chaos";
		config.width = KCConstants.GAME_WIDTH;
		config.height = KCConstants.GAME_HEIGHT;
		config.resizable = false;
		
		new LwjglApplication(new Main(), config);
	}
}