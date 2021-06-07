package pieces;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import game.GameScene;

public class King extends Piece {
	
	public King(Color color) {
		try {
			if (color == Color.WHITE) {
				img = ImageIO.read(Pawn.class.getResource("/pieces/images/Reyb.png"));
				this.color = Color.WHITE;
			} else {
				img = ImageIO.read(Pawn.class.getResource("/pieces/images/Reyn.png"));
				this.color = Color.BLACK;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void validMoves(int xi, int yi) {
		valid_moves = new ArrayList<>();
		
		//Arribas
		if (xi - 1 >= 0 && yi - 1 >= 0)
			valid_moves.add(new Point(xi - 1, yi - 1));
		if (yi - 1 >= 0)
			valid_moves.add(new Point(xi, yi - 1));
		if (xi + 1 < 8 && yi - 1 >= 0)
			valid_moves.add(new Point(xi + 1, yi - 1));
		//Abajos
		if (xi - 1 >= 0 && yi + 1 < 8)
			valid_moves.add(new Point(xi - 1, yi + 1));
		if (yi + 1 < 8)
			valid_moves.add(new Point(xi, yi + 1));
		if (xi + 1 < 8 && yi + 1 < 8)
			valid_moves.add(new Point(xi + 1, yi + 1));
		//Horizontal
		if (xi - 1 >= 0)
			valid_moves.add(new Point(xi - 1, yi));
		if (xi + 1 < 8)
			valid_moves.add(new Point(xi + 1, yi));
		
		List<Point> valid_moves_copy = List.copyOf(valid_moves);
		for (Point pt: valid_moves_copy) {
			Piece p = GameScene.tablero[pt.x][pt.y];
			if (p != null && p.getColor() == this.color) {
				valid_moves.remove(pt);
			}
		}
	}

}
