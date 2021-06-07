package pieces;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import game.GameScene;

public class Knight extends Piece {
	
	public Knight(Color color) {
		try {
			if (color == Color.WHITE) {
				img = ImageIO.read(Pawn.class.getResource("/pieces/images/Caballob.png"));
				this.color = Color.WHITE;
			} else {
				img = ImageIO.read(Pawn.class.getResource("/pieces/images/Caballon.png"));
				this.color = Color.BLACK;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void validMoves(int xi, int yi) {
		valid_moves = new ArrayList<>();
		
		//Arriba izquierda
		if (xi - 1 >= 0 && yi - 2 >= 0)
			valid_moves.add(new Point(xi - 1, yi - 2));
		if (xi - 2 >= 0 && yi - 1 >= 0)
			valid_moves.add(new Point(xi - 2, yi - 1));
		//Arriba derecha
		if (xi + 1 < 8 && yi - 2 >= 0)
			valid_moves.add(new Point(xi + 1, yi - 2));
		if (xi + 2 < 8 && yi - 1 >= 0)
			valid_moves.add(new Point(xi + 2, yi - 1));
		//Abajo izquierda
		if (xi - 1 >= 0 && yi + 2 < 8)
			valid_moves.add(new Point(xi - 1, yi + 2));
		if (xi - 2 >= 0 && yi + 1 < 8)
			valid_moves.add(new Point(xi - 2, yi + 1));
		//Abajo derecha
		if (xi + 1 < 8 && yi + 2 < 8)
			valid_moves.add(new Point(xi + 1, yi + 2));
		if (xi + 2 < 8 && yi + 1 < 8)
			valid_moves.add(new Point(xi + 2, yi + 1));
		
		List<Point> valid_moves_copy = List.copyOf(valid_moves);
		for (Point pt: valid_moves_copy) {
			Piece p = GameScene.tablero[pt.x][pt.y];
			if (p != null && p.getColor() == this.color) {
				valid_moves.remove(pt);
			}
		}
	}
}
