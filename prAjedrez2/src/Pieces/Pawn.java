package Pieces;

import javax.imageio.ImageIO;



public class Pawn extends Piece {
	
	public Pawn(String color) {		
		try {
			if (color == "white")
				img = ImageIO.read(Pawn.class.getResource("/Pieces/images/Peonb.png"));
			else
				img = ImageIO.read(Pawn.class.getResource("/Pieces/images/Peonn.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		this.color = color;
	}
	
	public boolean isValid(int x, int y) {
		boolean valid = false;			
		return valid;
	}
	public void Move(int x, int y) {
		if (isValid(x, y)) {

		}
	}
}
