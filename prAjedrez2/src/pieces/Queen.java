package pieces;

import java.awt.Point;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import game.GameScene;

public class Queen extends Piece {
	
	public Queen(Color color) {
		try {
			if (color == Color.WHITE) {
				img = ImageIO.read(Pawn.class.getResource("/pieces/images/Damab.png"));
				this.color = Color.WHITE;
			} else {
				img = ImageIO.read(Pawn.class.getResource("/pieces/images/Daman.png"));
				this.color = Color.BLACK;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void validMoves(int xi, int yi) {
		valid_moves = new ArrayList<>();
		
		//Copia y pega de alfil y torre
		//Abajo derecha
		int i = xi + 1; int j = yi + 1;
		while (i < 8 && j < 8 && GameScene.tablero[i][j] == null) {
			valid_moves.add(new Point(i, j));
			i++; j++;
		}
		if (i < 8 && j < 8 && GameScene.tablero[i][j].getColor() != this.color)
			valid_moves.add(new Point(i, j));
		//Abajo izquierda
		i = xi - 1; j = yi + 1;
		while (i >= 0 && j < 8 && GameScene.tablero[i][j] == null) {
			valid_moves.add(new Point(i, j));
			i--; j++;
		}
		if (i >= 0 && j < 8 && GameScene.tablero[i][j].getColor() != this.color)
			valid_moves.add(new Point(i, j));
		//Arriba derecha
		i = xi + 1; j = yi - 1;
		while (i < 8 && j >= 0 && GameScene.tablero[i][j] == null) {
			valid_moves.add(new Point(i, j));
			i++; j--;
		}
		if (i < 8 && j >= 0 && GameScene.tablero[i][j].getColor() != this.color)
			valid_moves.add(new Point(i, j));
		//Arriba izquierda
		i = xi - 1; j = yi - 1;
		while (i >= 0 && j > 0 && GameScene.tablero[i][j] == null) {
			valid_moves.add(new Point(i, j));
			i--; j--;
		}
		if (i >= 0 && j > 0 && GameScene.tablero[i][j].getColor() != this.color)
			valid_moves.add(new Point(i, j));	
		//Horizontal derecha
		i = xi + 1;
		while (i < 8 && GameScene.tablero[i][yi] == null) {
			valid_moves.add(new Point(i, yi));
			i++;
		}
		if (i < 8 && GameScene.tablero[i][yi].getColor() != this.color)
			valid_moves.add(new Point(i, yi));
		//Horizontal izquierda
		i = xi - 1;
		while (i >= 0 && GameScene.tablero[i][yi] == null) {
			valid_moves.add(new Point(i, yi));
			i--;
		}
		if (i >= 0 && GameScene.tablero[i][yi].getColor() != this.color)
			valid_moves.add(new Point(i, yi));
		//Vertical arriba
		j = yi + 1;
		while (j < 8 && GameScene.tablero[xi][j] == null) {
			valid_moves.add(new Point(xi, j));
			j++;
		}
		if (j < 8 && GameScene.tablero[xi][j].getColor() != this.color)
			valid_moves.add(new Point(xi, j));
		//Vertical abajo
		j = yi - 1;
		while (j >= 0 && GameScene.tablero[xi][j] == null) {
			valid_moves.add(new Point(xi, j));
			j--;
		}
		if (j >= 0 && GameScene.tablero[xi][j].getColor() != this.color)
			valid_moves.add(new Point(xi, j));		
	}
}
