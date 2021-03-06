package pieces;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import game.GameScene;

public class Pawn extends Piece {

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
	
	public void validMoves(int xi, int yi) {
		valid_moves = new ArrayList<>();
		
		if (this.color == Color.WHITE) {
			if (yi - 1 >= 0 && GameScene.tablero[xi][yi - 1] == null) {
				if (yi - 1 >= 0)
					valid_moves.add(new Point(xi, yi - 1));
				if (yi == 6)
					valid_moves.add(new Point(xi, yi - 2));
			}
			if (yi - 1 >= 0 && xi - 1 >= 0 && GameScene.tablero[xi - 1][yi - 1] != null) {
					valid_moves.add(new Point(xi - 1, yi - 1));
			}
			if (yi - 1 >= 0 && xi + 1 < 8 && GameScene.tablero[xi + 1][yi - 1] != null) {
					valid_moves.add(new Point(xi + 1, yi - 1));
			}
		} else {
			if (yi + 1 < 8 && GameScene.tablero[xi][yi + 1] == null) {
				if (yi + 1 < 8)
					valid_moves.add(new Point(xi, yi + 1));
				if (yi == 1)
					valid_moves.add(new Point(xi, yi + 2));
			}
			if (yi + 1 < 8 && xi - 1 >= 0 && GameScene.tablero[xi - 1][yi + 1] != null) {
					valid_moves.add(new Point(xi - 1, yi + 1));
			}
			if (yi + 1 < 8 && xi + 1 < 8 && GameScene.tablero[xi + 1][yi + 1] != null) {
					valid_moves.add(new Point(xi + 1, yi + 1));
			}
		}
		
		List<Point> valid_moves_copy = List.copyOf(valid_moves);
		for (Point pt: valid_moves_copy) {
			Piece p = GameScene.tablero[pt.x][pt.y];
			if (p != null && p.getColor() == this.color) {
				valid_moves.remove(pt);
			}
		}
	}
}
