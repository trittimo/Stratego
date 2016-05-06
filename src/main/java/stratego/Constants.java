package stratego;

import java.io.File;

public class Constants {
	public static final File IMAGES = new File("images");
	public static final File MAP_FILE = new File(IMAGES, "map.png");
	public static final File INVISIBLE_FILE = new File(IMAGES, "invisible.png");
	public static final File STEFAN_S_FACE_FILE = new File(IMAGES, "stefan's face.png");

	public static class Dimensions {
		public static final int WINDOW_WIDTH = 900;
		public static final int WINDOW_HEIGHT = 900;
		public static final int BOARD_WIDTH = WINDOW_WIDTH * 2 / 3;
		public static final int BOARD_HEIGHT = WINDOW_HEIGHT * 2 / 3;
		public static final int SELECTOR_WIDTH = WINDOW_WIDTH;
		public static final int SELECTOR_HEIGHT = WINDOW_HEIGHT - BOARD_HEIGHT;
		public static final int MESSAGES_HEIGHT = BOARD_HEIGHT;
		public static final int MESSAGES_WIDTH = WINDOW_WIDTH - BOARD_WIDTH;
	}
}
