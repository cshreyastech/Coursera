import processing.core.PApplet;
import processing.core.PImage;

public class MyPApplet extends PApplet {
	private String Url = "http://i0.wp.com/beckybendylegs.com/wp-content/uploads/2015/07/blue-sky.jpg";
	private PImage backgroundImg;

	public void setup() {
		size(400, 400);
		backgroundImg = loadImage(Url, "jpg");
	}

	public void draw() {
		backgroundImg.resize(0	, height);
		image(backgroundImg, 0, 0);
		
		int[] color = sunColorSec(second());
		fill(color[0], color[1], color[2]);

//		fill(255, 209, 0);
		ellipse(width / 4, height / 5, width / 4, height / 5);
	}
	
	public int[] sunColorSec(float seconds) {
		int[] rgb = new int[3];
		
		float diffFrom30 = Math.abs(30-seconds);
		
		float ratio = diffFrom30/30;
		rgb[0] = (int)(255 * ratio);
		rgb[1] = (int)(255 * ratio);
		rgb[2] = 0;
		
		return rgb;
	}
}