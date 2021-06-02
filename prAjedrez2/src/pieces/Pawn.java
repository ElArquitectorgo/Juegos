package pieces;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class Pawn extends Piece {
	private Color color;
	public Pawn(String color) {
		try {
			if (color == "WHITE") {
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

	public List<Point> validMoves(int xi, int yi, int xf, int yf) {
		List<Point> valid_moves = new ArrayList<>();
		if (color == Color.WHITE) {
			if (yi - 1 >= 0)
				valid_moves.add(new Point(xi, yi - 1));
			if (yi == 6)
				valid_moves.add(new Point(xi, yi - 2));
		} else {
			if (yi + 1 < 8)
				valid_moves.add(new Point(xi, yi + 1));
			if (yi == 1)
				valid_moves.add(new Point(xi, yi + 2));
		}
		return valid_moves;
	}
	
	public boolean isValid(int xi, int yi, int xf, int yf) {
		List<Point> valid_moves = validMoves(xi, yi, xf, yf);
		return valid_moves.contains(new Point(xf, yf));
	}
}
