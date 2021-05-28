package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import Pieces.Pawn;
import Pieces.Piece;

public class GameScene extends Scene {
	private ML mouseListener;
	private Piece [][] tablero;
	private Piece moving;
	
	public GameScene(ML mouseListener) {
		this.mouseListener = mouseListener;
		tablero = new Piece[8][8];
		tablero[0][0] = new Pawn("white");
		tablero[1][0] = new Pawn("black");
		tablero[2][0] = new Pawn("black");
		tablero[5][4] = new Pawn("black");
	}
	
	public int getPos(int n) {
		return n * Window.getTileSize();
	}
	
	public int getIndex(int n) {
		return n / Window.getTileSize();
	}
	
	@Override
	public void update(double dt) {
		if (mouseListener.isPressed() && moving == null) {
			moving = tablero[getIndex(mouseListener.getX())][getIndex(mouseListener.getY())];
			tablero[getIndex(mouseListener.getX())][getIndex(mouseListener.getY())] = null;
		} else if (!mouseListener.isPressed() && moving != null) {
			tablero[getIndex(mouseListener.getX())][getIndex(mouseListener.getY())] = moving;
			moving = null;
		} else if (mouseListener.isPressed() && moving != null) {
			
		}
	}

	@Override
	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (i % 2 == 0 && j % 2 != 0 || i % 2 != 0 && j % 2 == 0) {
					g2.setColor(Color.getHSBColor(40, 47, 92));
					g2.fill(new Rectangle2D.Double(getPos(i), getPos(j), Window.getTileSize(), Window.getTileSize()));
				}
				else {
					g2.setColor(Color.white);
					g2.fill(new Rectangle2D.Double(getPos(i), getPos(j), Window.getTileSize(), Window.getTileSize()));
				}
			}
		}
		
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (tablero[i][j] != null) {
					tablero[i][j].draw(g2, getPos(i), getPos(j));
				}
			}
		}
	}

}
