package Pieces;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import Game.Window;

public abstract class Piece {
	protected BufferedImage img;
	protected String color;
	
	abstract public boolean isValid(int x, int y);
	abstract public void Move(int x, int y);
	
	public void draw(Graphics2D g2, int x, int y) {
		g2.drawImage(img, x, y, Window.getTileSize(), Window.getTileSize(), null);
	}
}
