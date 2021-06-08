package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

import pieces.Bishop;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.Piece;
import pieces.Queen;
import pieces.Rook;

public class GameScene extends Scene {
	private ML mouseListener;	
	private Piece moving;
	private int moving_pos_x, moving_pos_y, pos_xi, pos_yi;
	private boolean draw_possibles;
	private int turn;
	private pieces.Color check_color;
	public static Piece[][] tablero;

	public GameScene(ML mouseListener) {
		this.mouseListener = mouseListener;
		turn = 1;
		tablero = new Piece[8][8];
		for (int i = 0; i < 8; i++) {
			//tablero[i][1] = new Pawn(pieces.Color.BLACK);
			//tablero[i][6] = new Pawn(pieces.Color.WHITE);
		}
		tablero[0][7] = new Rook(pieces.Color.WHITE);
		tablero[7][7] = new Rook(pieces.Color.WHITE);
		tablero[0][0] = new Rook(pieces.Color.BLACK);
		tablero[7][0] = new Rook(pieces.Color.BLACK);
		tablero[1][7] = new Knight(pieces.Color.WHITE);
		tablero[6][7] = new Knight(pieces.Color.WHITE);
		tablero[1][0] = new Knight(pieces.Color.BLACK);
		tablero[6][0] = new Knight(pieces.Color.BLACK);
		tablero[2][7] = new Bishop(pieces.Color.WHITE);
		tablero[5][7] = new Bishop(pieces.Color.WHITE);
		tablero[2][0] = new Bishop(pieces.Color.BLACK);
		tablero[5][0] = new Bishop(pieces.Color.BLACK);
		tablero[3][7] = new Queen(pieces.Color.WHITE);
		tablero[3][0] = new Queen(pieces.Color.BLACK);
		tablero[4][7] = new King(pieces.Color.WHITE);
		tablero[4][0] = new King(pieces.Color.BLACK);
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
		int x = getIndex(p.x);
		int y = getIndex(p.y);
		if (mouseListener.isPressed() && moving == null) {
			moving = tablero[x][y];
			if (moving != null && turn % 2 == 1 && moving.getColor() == pieces.Color.WHITE || moving != null && turn % 2 == 0 && moving.getColor() == pieces.Color.BLACK) {
				pos_xi = x;
				pos_yi = y;
				moving_pos_x = p.x;
				moving_pos_y = p.y;
				tablero[x][y] = null;
				if (moving != null) {
					moving.validMoves(pos_xi, pos_yi);
					draw_possibles = true;
				}
			} else {
				moving = null;
			}
		} else if (mouseListener.isPressed() && moving != null) {
			moving_pos_x = p.x;
			moving_pos_y = p.y;
		} else if (!mouseListener.isPressed() && moving != null) {
			//Hay que aplicar una correción de másmenos 30 píxeles porque MouseInfo incluye la taskbar en el eje y
			if (moving.isValid(x, getIndex(p.y - 30))) {
				draw_possibles = false;
				tablero[x][getIndex(p.y - 30)] = moving;
				if (isCheck() && check_color == moving.getColor()) {
					System.out.println("Not valid");
					tablero[pos_xi][pos_yi] = moving;
					tablero[x][getIndex(p.y - 30)] = null;
					turn--;
				}
				moving = null;
				turn++;
			} else {
				tablero[pos_xi][pos_yi] = moving;
				draw_possibles = false;
				moving = null;
			}
		}
	}

	public boolean isCheck() {
		boolean c = false;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (tablero[i][j] != null && tablero[i][j].getClass() != pieces.King.class && tablero[i][j].getColor() == pieces.Color.BLACK) {
					tablero[i][j].validMoves(i, j);
					for (Point pt: tablero[i][j].valid_moves) {
						if (tablero[pt.x][pt.y] != null && tablero[pt.x][pt.y].getClass() == pieces.King.class && tablero[pt.x][pt.y].getColor() == pieces.Color.WHITE) {
							c = true;
							check_color = pieces.Color.WHITE;
						}
					}
				} else if (tablero[i][j] != null && tablero[i][j].getClass() != pieces.King.class && tablero[i][j].getColor() == pieces.Color.WHITE) {
					tablero[i][j].validMoves(i, j);
					for (Point pt: tablero[i][j].valid_moves) {
						if (tablero[pt.x][pt.y] != null && tablero[pt.x][pt.y].getClass() == pieces.King.class && tablero[pt.x][pt.y].getColor() == pieces.Color.BLACK) {
							c = true;	
							check_color = pieces.Color.BLACK;
						}
					}
				}
			}
		}
		return c;
	}

	@Override
	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (i % 2 == 0 && j % 2 != 0 || i % 2 != 0 && j % 2 == 0) {
					g2.setColor(Color.getHSBColor(40, 47, 92));
					g2.fill(new Rectangle2D.Double(getPos(i), getPos(j)+30, Window.getTileSize(), Window.getTileSize()));
				} else {
					g2.setColor(Color.white);
					g2.fill(new Rectangle2D.Double(getPos(i), getPos(j)+30, Window.getTileSize(), Window.getTileSize()));
				}
			}
		}

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (tablero[i][j] != null) {
					tablero[i][j].draw(g2, getPos(i), getPos(j)+30);
				}
			}
		}
		
		if (draw_possibles) {
			g2.setColor(Color.YELLOW);
			List<Point> valid_moves = moving.valid_moves;
			for (Point p: valid_moves) {		
				g2.fill(new Ellipse2D.Double(getPos(p.x) + Window.getTileSize() / 3, getPos(p.y) + 30 + Window.getTileSize() / 3, Window.getTileSize() / 3, Window.getTileSize() / 3));
			}
		}
		
		if (moving != null) {
			moving.draw(g2, moving_pos_x - Window.getTileSize() / 2, moving_pos_y - Window.getTileSize() / 2);
		}
	}

}
