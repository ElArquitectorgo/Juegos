package pieces;

import java.awt.Point;
import java.util.ArrayList;

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
		
		if (color == Color.WHITE) {
			if (yi - 1 >= 0 && GameScene.tablero[xi][yi - 1] == null) {
				if (yi - 1 >= 0)
					valid_moves.add(new Point(xi, yi - 1));
				if (yi == 6)
					valid_moves.add(new Point(xi, yi - 2));
			}
			if (yi - 1 >= 0 && xi - 1 >= 0 && GameScene.tablero[xi - 1][yi - 1] != null && GameScene.tablero[xi - 1][yi - 1].getColor() == Color.BLACK) {
					valid_moves.add(new Point(xi - 1, yi - 1));
			}
			if (yi - 1 >= 0 && xi + 1 < 8 && GameScene.tablero[xi + 1][yi - 1] != null && GameScene.tablero[xi + 1][yi - 1].getColor() == Color.BLACK) {
					valid_moves.add(new Point(xi + 1, yi - 1));
			}
		} else {
			if (yi + 1 < 8 && GameScene.tablero[xi][yi + 1] == null) {
				if (yi + 1 < 8)
					valid_moves.add(new Point(xi, yi + 1));
				if (yi == 1)
					valid_moves.add(new Point(xi, yi + 2));
			}
			if (yi + 1 < 8 && xi - 1 >= 0 && GameScene.tablero[xi - 1][yi + 1] != null && GameScene.tablero[xi - 1][yi + 1].getColor() == Color.WHITE) {
					valid_moves.add(new Point(xi - 1, yi + 1));
			}
			if (yi + 1 < 8 && xi + 1 < 8 && GameScene.tablero[xi + 1][yi + 1] != null && GameScene.tablero[xi + 1][yi + 1].getColor() == Color.WHITE) {
					valid_moves.add(new Point(xi + 1, yi + 1));
			}
		}
	}
}
