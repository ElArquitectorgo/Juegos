package pieces;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import game.Window;

public abstract class Piece {
	protected BufferedImage img;
	protected String color;

	abstract public boolean isValid(int xi, int yi, int xf, int yf);

	public void draw(Graphics2D g2, int x, int y) {
		g2.drawImage(img, x, y, Window.getTileSize(), Window.getTileSize(), null);
	}
}
