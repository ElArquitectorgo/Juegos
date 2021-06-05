package pieces;

import java.awt.Point;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import game.GameScene;

public class Pawn extends Piece {
	private Color color;

	public Pawn(Color color) {
		try {
			if (color == Color.WHITE) {
				img = ImageIO.read(Pawn.class.getResource("/pieces/images/Peonb.png"));
				this.color = Color.WHITE;
			} else {
				img = ImageIO.read(Pawn.class.getResource("/pieces/images/Peonn.png"));
				this.color = Color.BLACK;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Color getColor() {
		return this.color;
	}
	
	public void validMoves(int xi, int yi, Piece p) {
		valid_moves = new ArrayList<>();;
		if (color == Color.WHITE) {
			if (p == null) {
				if (yi - 1 >= 0)
					valid_moves.add(new Point(xi, yi - 1));
				if (yi == 6)
					valid_moves.add(new Point(xi, yi - 2));
			}
			else if (p.getColor() == Color.BLACK && yi - 1 >= 0) {
				if (xi - 1 >= 0)
					valid_moves.add(new Point(xi - 1, yi - 1));
				if (xi + 1 < 8)
					valid_moves.add(new Point(xi + 1, yi - 1));
			}
		} else {
			if (p == null) {
				if (yi + 1 < 8)
					valid_moves.add(new Point(xi, yi + 1));
				if (yi == 1)
					valid_moves.add(new Point(xi, yi + 2));
			}
			else if (p.getColor() == Color.WHITE && yi + 1 < 8) {
				if (xi - 1 >= 0)
					valid_moves.add(new Point(xi - 1, yi + 1));
				if (xi + 1 < 8)
					valid_moves.add(new Point(xi + 1, yi + 1));
			}
		}
	}

	public boolean isValid(int xi, int yi, int xf, int yf, Piece p) {
		validMoves(xi, yi, p);
		return valid_moves.contains(new Point(xf, yf));
	}
}
