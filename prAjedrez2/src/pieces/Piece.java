package pieces;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.List;

import game.Window;

public abstract class Piece {
	protected BufferedImage img;
	protected enum Color {WHITE, BLACK};

	abstract public List<Point> validMoves(int xi, int yi, int xf, int yf);
	abstract public boolean isValid(int xi, int yi, int xf, int yf);

	public void draw(Graphics2D g2, int x, int y) {
		g2.drawImage(img, x, y, Window.getTileSize(), Window.getTileSize(), null);
	}
}
