package pieces;

import java.awt.Point;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import game.GameScene;

public class Bishop extends Piece {
	
	public Bishop(Color color) {
		try {
			if (color == Color.WHITE) {
				img = ImageIO.read(Pawn.class.getResource("/pieces/images/Alfilb.png"));
				this.color = Color.WHITE;
			} else {
				img = ImageIO.read(Pawn.class.getResource("/pieces/images/Alfiln.png"));
				this.color = Color.BLACK;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void validMoves(int xi, int yi) {
		valid_moves = new ArrayList<>();
		
		//Abajo derecha
		int i = xi; int j = yi;
		while (i < 8 && j < 8 && GameScene.tablero[i][j] == null) {
			valid_moves.add(new Point(i, j));
			i++; j++;
		}
		//Abajo izquierda
		i = xi; j = yi;
		while (i >= 0 && j < 8 && GameScene.tablero[i][j] == null) {
			valid_moves.add(new Point(i, j));
			i--; j++;
		}
		//Arriba derecha
		i = xi; j = yi;
		while (i < 8 && j >= 0 && GameScene.tablero[i][j] == null) {
			valid_moves.add(new Point(i, j));
			i++; j--;
		}
		//Arriba izquierda
		i = xi; j = yi;
		while (i >= 0 && j >= 0 && GameScene.tablero[i][j] == null) {
			valid_moves.add(new Point(i, j));
			i--; j--;
		}
	}

	@Override
	Color getColor() {
		return this.color;
	}

}
