package pieces;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.List;

import game.Window;

public abstract class Piece {
	protected BufferedImage img;
	public List<Point> valid_moves;
	protected Color color;

	abstract public void validMoves(int xi, int yi);

	public boolean isValid(int xf, int yf) {
		return valid_moves.contains(new Point(xf, yf));
	}
	public void draw(Graphics2D g2, int x, int y) {
		g2.drawImage(img, x, y, Window.getTileSize(), Window.getTileSize(), null);
	}
	public Color getColor() {
		return this.color;
	}
}
