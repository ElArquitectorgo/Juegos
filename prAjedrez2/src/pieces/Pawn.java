package pieces;

import javax.imageio.ImageIO;

public class Pawn extends Piece {
	private String color;
	public Pawn(String color) {
		try {
			if (color == "white")
				img = ImageIO.read(Pawn.class.getResource("/pieces/images/Peonb.png"));
			else
				img = ImageIO.read(Pawn.class.getResource("/pieces/images/Peonn.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.color = color;
	}

	public boolean isValid(int xi, int yi, int xf, int yf) {
		boolean valid = false;
		if (color == "white") {
			if (xi == xf && yi == yf + 1 || xi == xf && yi == 6 && yi == yf + 2)
				valid = true;
		} else {
			if (xi == xf && yi == yf - 1 || xi == xf && yi == 1 && yi == yf - 2)
				valid = true;
		}
		return valid;
	}
}
