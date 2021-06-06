package pieces;

import java.awt.Point;

import javax.imageio.ImageIO;

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
		// TODO Auto-generated method stub
		
	}

	@Override
	Color getColor() {
		return this.color;
	}

}
