package pieces;

import java.awt.Point;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import game.GameScene;

public class Rook extends Piece {
	
	public Rook(Color color) {
		try {
			if (color == Color.WHITE) {
				img = ImageIO.read(Pawn.class.getResource("/pieces/images/Torreb.png"));
				this.color = Color.WHITE;
			} else {
				img = ImageIO.read(Pawn.class.getResource("/pieces/images/Torren.png"));
				this.color = Color.BLACK;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void validMoves(int xi, int yi) {
		valid_moves = new ArrayList<>();
		//Horizontal derecha
		int i = xi;
		while (i < 8 && GameScene.tablero[i][yi] == null) {
			valid_moves.add(new Point(i, yi));
			i++;
		}
		if (i < 8 && GameScene.tablero[i][yi].getColor() != this.color)
			valid_moves.add(new Point(i, yi));
		//Horizontal izquierda
		i = xi;
		while (i >= 0 && GameScene.tablero[i][yi] == null) {
			valid_moves.add(new Point(i, yi));
			i--;
		}
		if (i >= 0 && GameScene.tablero[i][yi].getColor() != this.color)
			valid_moves.add(new Point(i, yi));
		//Vertical arriba
		int j = yi;
		while (j < 8 && GameScene.tablero[xi][j] == null) {
			valid_moves.add(new Point(xi, j));
			j++;
		}
		if (j < 8 && GameScene.tablero[xi][j].getColor() != this.color)
			valid_moves.add(new Point(xi, j));
		//Vertical abajo
		j = yi;
		while (j >= 0 && GameScene.tablero[xi][j] == null) {
			valid_moves.add(new Point(xi, j));
			j--;
		}
		if (j >= 0 && GameScene.tablero[xi][j].getColor() != this.color)
			valid_moves.add(new Point(xi, j));
		
	}

	Color getColor() {
		return this.color;
	}

}
