package tablero;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class Mover {
	public Icon icon;
	public Icon iconf;
	
	public Mover() {
		int posxf = Character.getNumericValue(Tablero.moves.charAt(Tablero.moves.length() - 2));
		int posyf = Character.getNumericValue(Tablero.moves.charAt(Tablero.moves.length() - 1));
		int posx = Character.getNumericValue(Tablero.moves.charAt(Tablero.moves.length() - 4));
		int posy = Character.getNumericValue(Tablero.moves.charAt(Tablero.moves.length() - 3));
		icon = Tablero.tablero[posx][posy].getIcon();
		iconf = Tablero.tablero[posxf][posyf].getIcon();
		Posibles.pinta(posxf, posyf, iconf);
		if (Tablero.cnt % 2 == 0 && isPiezaBlanca(icon) || Tablero.cnt % 2 != 0 && isPiezaNegra(icon)) {
			if (isValid(posxf, posyf)) {
				if (icon == Tablero.Peon_b && posxf == 0) {
					Tablero.tablero[posxf][posyf].setIcon(Tablero.Dama_b);
					Tablero.tablero[posx][posy].setIcon(null);
				}
				else if (icon == Tablero.Peon_n && posxf == 7) {
					Tablero.tablero[posxf][posyf].setIcon(Tablero.Dama_n);
					Tablero.tablero[posx][posy].setIcon(null);
				}
				else {
					Tablero.tablero[posxf][posyf].setIcon(Tablero.tablero[posx][posy].getIcon());
					Tablero.tablero[posx][posy].setIcon(null);
				}
				Tablero.cnt += 1;
				
				if (Tablero.cnt % 2 == 0) {
					System.out.println("Turno blancas");
				}
				else {
					System.out.println("Turno negras");
				}
				if (Posibles.isJaqueMate()) {
					System.out.println("Jaque mate");
				}
				Posibles.repinta();
			}		
			else {
				Posibles.repinta();
				Posibles.pinta(posxf, posyf, iconf);
			}
		}
		else {
			Posibles.repinta();
			Posibles.pinta(posxf, posyf, iconf);
		}
	}
	public boolean isValid(int posxf, int posyf) {
		boolean valid_move = false;
		if (Tablero.tablero[posxf][posyf].getBackground().equals(Color.getHSBColor(90, 90, 50))) {
			valid_move = true;
		}
		return valid_move;
	}
	public static boolean isClavada(int posxf, int posyf) {
		List<Integer> posibilidades = new ArrayList<Integer>();
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				List<Integer> posibles = Posibles.Posibles(i, j, Tablero.tablero[i][j].getIcon());
				for (int eles = 0; eles < posibles.size(); eles ++) {
					posibilidades.add(posibles.get(eles));
				}
			}
		}
		for (int eles = 0; eles < posibilidades.size() - 1; eles += 2) {
			if (Tablero.tablero[posibilidades.get(eles)][posibilidades.get(eles + 1)].getIcon() == Tablero.Rey_n && isPiezaNegra(Tablero.tablero[posxf][posyf].getIcon())||
				Tablero.tablero[posibilidades.get(eles)][posibilidades.get(eles + 1)].getIcon() == Tablero.Rey_b && isPiezaBlanca(Tablero.tablero[posxf][posyf].getIcon())) {
				return true;
			}
		}
		return false;
	}
	public static boolean isPiezaNegra(Icon pieza) {
		for (Icon i: Tablero.getNegras()) {
			if (i == pieza) {
				return true;
			}
		}
		return false;
	}
	public static boolean isPiezaBlanca(Icon pieza) {
		for (Icon i: Tablero.getBlancas()) {
			if (i == pieza) {
				return true;
			}
		}
		return false;
	}
}
