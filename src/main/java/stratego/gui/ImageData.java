/**
 * 
 */
package stratego.gui;

/**
 * Contains data on images. Used in order to meet metric requirements
 */
public class ImageData {

	public String name;
	public int x;
	public int y;
	public int width;
	public int height;

	public ImageData(String fileName, int x, int y, int width, int height) {
		this.name = fileName;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

}
