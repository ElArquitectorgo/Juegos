package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.geom.Rectangle2D;

import pieces.Pawn;
import pieces.Piece;

public class GameScene extends Scene {
	private ML mouseListener;
	private Piece[][] tablero;
	private Piece moving;
	private int moving_pos_x, moving_pos_y, pos_xi, pos_yi;

	public GameScene(ML mouseListener) {
		this.mouseListener = mouseListener;
		tablero = new Piece[8][8];
		for (int i = 0; i < 8; i++) {
			tablero[i][1] = new Pawn(pieces.Color.BLACK); // Paco: hay un Color importado de java.awt
			tablero[i][6] = new Pawn(pieces.Color.WHITE);
		}
	}

	public int getPos(int n) {
		return n * Window.getTileSize();
	}

	public int getIndex(int n) {
		return n / Window.getTileSize();
	}

	@Override
	public void update(double dt) {
		Point p = MouseInfo.getPointerInfo().getLocation();
		if (mouseListener.isPressed() && moving == null) {
			moving = tablero[getIndex(p.x)][getIndex(p.y)];
			pos_xi = getIndex(p.x);
			pos_yi = getIndex(p.y);
			moving_pos_x = p.x;
			moving_pos_y = p.y;
			tablero[getIndex(p.x)][getIndex(p.y)] = null;
		} else if (mouseListener.isPressed() && moving != null) {
			moving_pos_x = p.x;
			moving_pos_y = p.y;
		} else if (!mouseListener.isPressed() && moving != null) {
			if (moving.isValid(pos_xi, pos_yi, getIndex(p.x), getIndex(p.y))) {
				tablero[getIndex(p.x)][getIndex(p.y)] = moving;
				moving = null;
			} else {
				tablero[pos_xi][pos_yi] = moving;
				moving = null;
			}
		}
	}

	@Override
	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (i % 2 == 0 && j % 2 != 0 || i % 2 != 0 && j % 2 == 0) {
					g2.setColor(Color.getHSBColor(40, 47, 92));
					g2.fill(new Rectangle2D.Double(getPos(i), getPos(j), Window.getTileSize(), Window.getTileSize()));
				} else {
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
		if (moving != null) {
			moving.draw(g2, moving_pos_x - Window.getTileSize() / 2, moving_pos_y - Window.getTileSize() / 2);
		}
	}

}
