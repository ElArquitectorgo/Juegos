package tablero;

import javax.swing.Icon;

public class Old_Mover {
	public Icon icon;
	public Icon iconf;
	
	public Old_Mover() {
		int posxf = Character.getNumericValue(Tablero.moves.charAt(Tablero.moves.length() - 2));
		int posyf = Character.getNumericValue(Tablero.moves.charAt(Tablero.moves.length() - 1));
		int posx = Character.getNumericValue(Tablero.moves.charAt(Tablero.moves.length() - 4));
		int posy = Character.getNumericValue(Tablero.moves.charAt(Tablero.moves.length() - 3));
		icon = Tablero.tablero[posx][posy].getIcon();
		iconf = Tablero.tablero[posxf][posyf].getIcon();
		if (icon != null) {
			if (isValid(posx, posy, posxf, posyf)) {
			Tablero.tablero[posxf][posyf].setIcon(Tablero.tablero[posx][posy].getIcon());
			Tablero.tablero[posx][posy].setIcon(null);
			}
			/**
			if (isClavada(posxf, posyf)) {
				System.out.println("NO");
				Tablero.tablero[posx][posy].setIcon(Tablero.tablero[posxf][posyf].getIcon());
				Tablero.tablero[posxf][posyf].setIcon(iconf);
			}
			**/
			else if (isJaque(posxf, posyf)) {
				System.out.println("Jaque");
			}
		}
	}
	public boolean isValid(int posx, int posy, int posxf, int posyf) {
		boolean valid_move = false;
		if (icon == Tablero.Peon_b && !isBlanca()) {
			if (posyf == posy && posxf == posx - 1 && iconf == null) {
				valid_move = true;
			}
			else if (posyf == posy && posxf == posx - 2 && posx == 6 && iconf == null) {
				valid_move = true;
			}
			else if (posyf == posy - 1 && posxf == posx - 1 && iconf != null || posyf == posy + 1 && posxf == posx - 1 && iconf != null) {
				valid_move = true;
			}
		}
		
		else if (icon == Tablero.Torre_b && !isBlanca()) {
			if (posyf == posy || posxf == posx) {
				// Derecha
				if (posxf == posx && posyf > posy) {
					for (int j = posy + 1; j < posyf + 1; j++) {
						if (Tablero.tablero[posx][j].getIcon() == null) {
							valid_move = true;
						}
						else if (j == posyf && Tablero.tablero[posxf][posyf].getIcon() != null) {
							valid_move = true;
						}
						else {
							return false;
						}
					}
				}
				// Izquierda
				else if (posxf == posx && posyf < posy) {
					for (int j = posy - 1; j > posyf - 1; j--) {
						if (Tablero.tablero[posx][j].getIcon() == null) {
							valid_move = true;
						}
						else if (j == posyf && Tablero.tablero[posxf][posyf].getIcon() != null) {
							valid_move = true;
						}
						else {
							return false;
						}
					}
				}
				// Abajo
				else if (posyf == posy && posxf > posx) {
					for (int i = posx + 1; i < posxf + 1; i++) {
						if (Tablero.tablero[i][posy].getIcon() == null) {
							valid_move = true;
						}
						else if (i == posxf && Tablero.tablero[posxf][posyf].getIcon() != null) {
							valid_move = true;
						}
						else {
							return false;
						}
					}
				}
				// Arriba
				else if (posyf == posy && posxf < posx) {
					for (int i = posx - 1; i > posxf - 1; i--) {						
						if (Tablero.tablero[i][posy].getIcon() == null) {
							valid_move = true;
						}
						else if (i == posxf && Tablero.tablero[posxf][posyf].getIcon() != null) {
							valid_move = true;
						}
						else {
							return false;
						}
					}
				}
			}
		}
		
		else if (icon == Tablero.Alfil_b && !isBlanca()) {
			if (Math.abs((posxf - posx)) == Math.abs((posyf - posy))) {
				// Abajo derecha
				if (posxf > posx && posyf > posy) {
					int j = posy;
					for (int i = posx + 1; i < posxf + 1; i++) {
						j += 1;
						if (Tablero.tablero[i][j].getIcon() == null) {
							valid_move = true;
						}
						else if (i == posxf && Tablero.tablero[posxf][posyf].getIcon() != null) {
							valid_move = true;
						}
						else {
							return false;
						}
						
					}
				}
				// Abajo izquierda
				else if (posxf > posx && posyf < posy) {
					int j = posy;
					for (int i = posx + 1; i < posxf + 1; i++) {
						j -= 1;
						if (Tablero.tablero[i][j].getIcon() == null) {
							valid_move = true;
						}
						else if (i == posxf && Tablero.tablero[posxf][posyf].getIcon() != null) {
							valid_move = true;
						}
						else {
							return false;
						}
					}
				}
				// Arriba derecha
				else if (posxf < posx && posyf > posy) {
					int j = posy;
					for (int i = posx - 1; i > posxf - 1; i--) {
						j += 1;
						if (Tablero.tablero[i][j].getIcon() == null) {
							valid_move = true;
						}
						else if (i == posxf && Tablero.tablero[posxf][posyf].getIcon() != null) {
							valid_move = true;
						}
						else {
							return false;
						}
					}
				}
				// Arriba izquierda
				else if (posxf < posx && posyf < posy) {
					int j = posy;
					for (int i = posx - 1; i > posxf - 1; i--) {
						j -= 1;
						if (Tablero.tablero[i][j].getIcon() == null) {
							valid_move = true;
						}
						else if (i == posxf && Tablero.tablero[posxf][posyf].getIcon() != null) {
							valid_move = true;
						}
						else {
							return false;
						}
					}
				}
			}
		}
		
		else if (icon == Tablero.Caballo_b && !isBlanca()) {
			if (posxf == posx - 2 && posyf == posy - 1 || posxf == posx - 2 && posyf == posy + 1 || posxf == posx + 2 && posyf == posy - 1 || posxf == posx + 2 && posyf == posy + 1 ||
				posxf == posx - 1 && posyf == posy - 2 || posxf == posx - 1 && posyf == posy + 2 || posxf == posx + 1 && posyf == posy - 2 || posxf == posx + 1 && posyf == posy + 2) {
				valid_move = true;
			}
		}
		
		else if (icon == Tablero.Dama_b && !isBlanca()) {
			// Movimiento Torre
			if (posyf == posy || posxf == posx) {
				// Derecha
				if (posxf == posx && posyf > posy) {
					for (int j = posy + 1; j < posyf + 1; j++) {
						if (Tablero.tablero[posx][j].getIcon() == null) {
							valid_move = true;
						}
						else if (j == posyf && Tablero.tablero[posxf][posyf].getIcon() != null) {
							valid_move = true;
						}
						else {
							return false;
						}
					}
				}
				// Izquierda
				else if (posxf == posx && posyf < posy) {
					for (int j = posy - 1; j > posyf - 1; j--) {
						if (Tablero.tablero[posx][j].getIcon() == null) {
							valid_move = true;
						}
						else if (j == posyf && Tablero.tablero[posxf][posyf].getIcon() != null) {
							valid_move = true;
						}
						else {
							return false;
						}
					}
				}
				// Abajo
				else if (posyf == posy && posxf > posx) {
					for (int i = posx + 1; i < posxf + 1; i++) {
						if (Tablero.tablero[i][posy].getIcon() == null) {
							valid_move = true;
						}
						else if (i == posxf && Tablero.tablero[posxf][posyf].getIcon() != null) {
							valid_move = true;
						}
						else {
							return false;
						}
					}
				}
				// Arriba
				else if (posyf == posy && posxf < posx) {
					for (int i = posx - 1; i > posxf - 1; i--) {						
						if (Tablero.tablero[i][posy].getIcon() == null) {
							valid_move = true;
						}
						else if (i == posxf && Tablero.tablero[posxf][posyf].getIcon() != null) {
							valid_move = true;
						}
						else {
							return false;
						}
					}
				}
			}
			// Movimiento Alfil
			if (Math.abs((posxf - posx)) == Math.abs((posyf - posy))) {
				// Abajo derecha
				if (posxf > posx && posyf > posy) {
					int j = posy;
					for (int i = posx + 1; i < posxf + 1; i++) {
						j += 1;
						if (Tablero.tablero[i][j].getIcon() == null) {
							valid_move = true;
						}
						else if (i == posxf && Tablero.tablero[posxf][posyf].getIcon() != null) {
							valid_move = true;
						}
						else {
							return false;
						}
						
					}
				}
				// Abajo izquierda
				else if (posxf > posx && posyf < posy) {
					int j = posy;
					for (int i = posx + 1; i < posxf + 1; i++) {
						j -= 1;
						if (Tablero.tablero[i][j].getIcon() == null) {
							valid_move = true;
						}
						else if (i == posxf && Tablero.tablero[posxf][posyf].getIcon() != null) {
							valid_move = true;
						}
						else {
							return false;
						}
					}
				}
				// Arriba derecha
				else if (posxf < posx && posyf > posy) {
					int j = posy;
					for (int i = posx - 1; i > posxf - 1; i--) {
						j += 1;
						if (Tablero.tablero[i][j].getIcon() == null) {
							valid_move = true;
						}
						else if (i == posxf && Tablero.tablero[posxf][posyf].getIcon() != null) {
							valid_move = true;
						}
						else {
							return false;
						}
					}
				}
				// Arriba izquierda
				else if (posxf < posx && posyf < posy) {
					int j = posy;
					for (int i = posx - 1; i > posxf - 1; i--) {
						j -= 1;
						if (Tablero.tablero[i][j].getIcon() == null) {
							valid_move = true;
						}
						else if (i == posxf && Tablero.tablero[posxf][posyf].getIcon() != null) {
							valid_move = true;
						}
						else {
							return false;
						}
					}
				}
			}
		}
		
		else if (icon == Tablero.Rey_b && !isBlanca()) {
			if (Math.abs((posxf-posx)) == 1 && Math.abs((posyf-posy)) == 1 || Math.abs((posxf-posx)) == 1 && Math.abs((posyf-posy)) == 0 ||
				Math.abs((posxf-posx)) == 0 && Math.abs((posyf-posy)) == 1) {
				valid_move = true;
			}
		}
		
		else if (icon == Tablero.Peon_n && !isNegra()) {
			if (posyf == posy && posxf == posx + 1 && iconf == null) {
				valid_move = true;
			}
			else if (posyf == posy && posxf == posx + 2 && posx == 1 && iconf == null) {
				valid_move = true;
			}
			else if (posyf == posy - 1 && posxf == posx + 1 && iconf != null || posyf == posy + 1 && posxf == posx + 1 && iconf != null) {
				valid_move = true;
			}
		}
		
		else if (icon == Tablero.Torre_n && !isNegra()) {
			if (posyf == posy || posxf == posx) {
				// Derecha
				if (posxf == posx && posyf > posy) {
					for (int j = posy + 1; j < posyf + 1; j++) {
						if (Tablero.tablero[posx][j].getIcon() == null) {
							valid_move = true;
						}
						else if (j == posyf && Tablero.tablero[posxf][posyf].getIcon() != null) {
							valid_move = true;
						}
						else {
							return false;
						}
					}
				}
				// Izquierda
				else if (posxf == posx && posyf < posy) {
					for (int j = posy - 1; j > posyf - 1; j--) {
						if (Tablero.tablero[posx][j].getIcon() == null) {
							valid_move = true;
						}
						else if (j == posyf && Tablero.tablero[posxf][posyf].getIcon() != null) {
							valid_move = true;
						}
						else {
							return false;
						}
					}
				}
				// Abajo
				else if (posyf == posy && posxf > posx) {
					for (int i = posx + 1; i < posxf + 1; i++) {
						if (Tablero.tablero[i][posy].getIcon() == null) {
							valid_move = true;
						}
						else if (i == posxf && Tablero.tablero[posxf][posyf].getIcon() != null) {
							valid_move = true;
						}
						else {
							return false;
						}
					}
				}
				// Arriba
				else if (posyf == posy && posxf < posx) {
					for (int i = posx - 1; i > posxf - 1; i--) {						
						if (Tablero.tablero[i][posy].getIcon() == null) {
							valid_move = true;
						}
						else if (i == posxf && Tablero.tablero[posxf][posyf].getIcon() != null) {
							valid_move = true;
						}
						else {
							return false;
						}
					}
				}
			}
		}
		
		else if (icon == Tablero.Alfil_n && !isNegra()) {
			if (Math.abs((posxf - posx)) == Math.abs((posyf - posy))) {
				// Abajo derecha
				if (posxf > posx && posyf > posy) {
					int j = posy;
					for (int i = posx + 1; i < posxf + 1; i++) {
						j += 1;
						if (Tablero.tablero[i][j].getIcon() == null) {
							valid_move = true;
						}
						else if (i == posxf && Tablero.tablero[posxf][posyf].getIcon() != null) {
							valid_move = true;
						}
						else {
							return false;
						}
						
					}
				}
				// Abajo izquierda
				else if (posxf > posx && posyf < posy) {
					int j = posy;
					for (int i = posx + 1; i < posxf + 1; i++) {
						j -= 1;
						if (Tablero.tablero[i][j].getIcon() == null) {
							valid_move = true;
						}
						else if (i == posxf && Tablero.tablero[posxf][posyf].getIcon() != null) {
							valid_move = true;
						}
						else {
							return false;
						}
					}
				}
				// Arriba derecha
				else if (posxf < posx && posyf > posy) {
					int j = posy;
					for (int i = posx - 1; i > posxf - 1; i--) {
						j += 1;
						if (Tablero.tablero[i][j].getIcon() == null) {
							valid_move = true;
						}
						else if (i == posxf && Tablero.tablero[posxf][posyf].getIcon() != null) {
							valid_move = true;
						}
						else {
							return false;
						}
					}
				}
				// Arriba izquierda
				else if (posxf < posx && posyf < posy) {
					int j = posy;
					for (int i = posx - 1; i > posxf - 1; i--) {
						j -= 1;
						if (Tablero.tablero[i][j].getIcon() == null) {
							valid_move = true;
						}
						else if (i == posxf && Tablero.tablero[posxf][posyf].getIcon() != null) {
							valid_move = true;
						}
						else {
							return false;
						}
					}
				}
			}
		}
		
		else if (icon == Tablero.Caballo_n && !isNegra()) {
			if (posxf == posx - 2 && posyf == posy - 1 || posxf == posx - 2 && posyf == posy + 1 || posxf == posx + 2 && posyf == posy - 1 || posxf == posx + 2 && posyf == posy + 1 ||
				posxf == posx - 1 && posyf == posy - 2 || posxf == posx - 1 && posyf == posy + 2 || posxf == posx + 1 && posyf == posy - 2 || posxf == posx + 1 && posyf == posy + 2) {
				valid_move = true;
			}
		}
		
		else if (icon == Tablero.Dama_n && !isNegra()) {
			// Movimiento Torre
			if (posyf == posy || posxf == posx) {
				// Derecha
				if (posxf == posx && posyf > posy) {
					for (int j = posy + 1; j < posyf + 1; j++) {
						if (Tablero.tablero[posx][j].getIcon() == null) {
							valid_move = true;
						}
						else if (j == posyf && Tablero.tablero[posxf][posyf].getIcon() != null) {
							valid_move = true;
						}
						else {
							return false;
						}
					}
				}
				// Izquierda
				else if (posxf == posx && posyf < posy) {
					for (int j = posy - 1; j > posyf - 1; j--) {
						if (Tablero.tablero[posx][j].getIcon() == null) {
							valid_move = true;
						}
						else if (j == posyf && Tablero.tablero[posxf][posyf].getIcon() != null) {
							valid_move = true;
						}
						else {
							return false;
						}
					}
				}
				// Abajo
				else if (posyf == posy && posxf > posx) {
					for (int i = posx + 1; i < posxf + 1; i++) {
						if (Tablero.tablero[i][posy].getIcon() == null) {
							valid_move = true;
						}
						else if (i == posxf && Tablero.tablero[posxf][posyf].getIcon() != null) {
							valid_move = true;
						}
						else {
							return false;
						}
					}
				}
				// Arriba
				else if (posyf == posy && posxf < posx) {
					for (int i = posx - 1; i > posxf - 1; i--) {						
						if (Tablero.tablero[i][posy].getIcon() == null) {
							valid_move = true;
						}
						else if (i == posxf && Tablero.tablero[posxf][posyf].getIcon() != null) {
							valid_move = true;
						}
						else {
							return false;
						}
					}
				}
			}
			// Movimiento Alfil
			if (Math.abs((posxf - posx)) == Math.abs((posyf - posy))) {
				// Abajo derecha
				if (posxf > posx && posyf > posy) {
					int j = posy;
					for (int i = posx + 1; i < posxf + 1; i++) {
						j += 1;
						if (Tablero.tablero[i][j].getIcon() == null) {
							valid_move = true;
						}
						else if (i == posxf && Tablero.tablero[posxf][posyf].getIcon() != null) {
							valid_move = true;
						}
						else {
							return false;
						}
						
					}
				}
				// Abajo izquierda
				else if (posxf > posx && posyf < posy) {
					int j = posy;
					for (int i = posx + 1; i < posxf + 1; i++) {
						j -= 1;
						if (Tablero.tablero[i][j].getIcon() == null) {
							valid_move = true;
						}
						else if (i == posxf && Tablero.tablero[posxf][posyf].getIcon() != null) {
							valid_move = true;
						}
						else {
							return false;
						}
					}
				}
				// Arriba derecha
				else if (posxf < posx && posyf > posy) {
					int j = posy;
					for (int i = posx - 1; i > posxf - 1; i--) {
						j += 1;
						if (Tablero.tablero[i][j].getIcon() == null) {
							valid_move = true;
						}
						else if (i == posxf && Tablero.tablero[posxf][posyf].getIcon() != null) {
							valid_move = true;
						}
						else {
							return false;
						}
					}
				}
				// Arriba izquierda
				else if (posxf < posx && posyf < posy) {
					int j = posy;
					for (int i = posx - 1; i > posxf - 1; i--) {
						j -= 1;
						if (Tablero.tablero[i][j].getIcon() == null) {
							valid_move = true;
						}
						else if (i == posxf && Tablero.tablero[posxf][posyf].getIcon() != null) {
							valid_move = true;
						}
						else {
							return false;
						}
					}
				}
			}
		}
		
		else if (icon == Tablero.Rey_n && !isNegra()) {
			if (Math.abs((posxf-posx)) == 1 && Math.abs((posyf-posy)) == 1 || Math.abs((posxf-posx)) == 1 && Math.abs((posyf-posy)) == 0 ||
				Math.abs((posxf-posx)) == 0 && Math.abs((posyf-posy)) == 1) {
				valid_move = true;
			}
		}
		
		return valid_move;
	}
	public boolean isJaque(int posxf, int posyf) {
		if (icon == Tablero.Peon_b) {
			if (posyf != 0 && Tablero.tablero[posxf - 1][posyf - 1].getIcon() == Tablero.Rey_n || posyf != 7 && Tablero.tablero[posxf - 1][posyf + 1].getIcon() == Tablero.Rey_n) {
				return true;
			}
		}
		
		if (icon == Tablero.Torre_b) {
			// Si estoy horizontal al rey
			for (int j = 0; j < 7; j++) {
				if (Tablero.tablero[posxf][j].getIcon() == Tablero.Rey_n) {
					// Si estoy a la izquierda
					if (j > posyf) {
						if (j - posyf == 1) {
							return true;
						}
						else {
							for (int jj = posyf + 1; jj < j; jj++) {
								if (Tablero.tablero[posxf][jj].getIcon() != null) {
									return false;
								}
								else if (Tablero.tablero[posxf][jj + 1].getIcon() == Tablero.Rey_n) {
									return true;
								}
							}
						}
					}
					// Si estoy a la derecha
					if (j < posyf) {
						if (posyf - j == 1) {
							return true;
						}
						else {
							for (int jj = posyf - 1; jj > j; jj--) {
								if (Tablero.tablero[posxf][jj].getIcon() != null) {
									return false;
								}
								else if (Tablero.tablero[posxf][jj - 1].getIcon() == Tablero.Rey_n) {
									return true;
								}
							}
						}
					}
				}	
			}
			// Si estoy vertical al rey
			for (int i = 0; i < 7; i++) {
				if (Tablero.tablero[i][posyf].getIcon() == Tablero.Rey_n) {
					// Si estoy abajo
					if (i < posxf) {
						if (posxf - i == 1) {
							return true;
						}
						else {
							for (int ii = posxf - 1; ii > i; ii--) {
								if (Tablero.tablero[ii][posyf].getIcon() != null) {
									return false;
								}
								else if (Tablero.tablero[ii - 1][posyf].getIcon() == Tablero.Rey_n) {
									return true;
								}
							}
						}
					}
					// Si estoy encima
					if (i > posxf) {
						if (i - posxf == 1) {
							return true;
						}
						else {
							for (int ii = posxf + 1; ii < i; ii++) {
								if (Tablero.tablero[ii][posyf].getIcon() != null) {
									return false;
								}
								else if (Tablero.tablero[ii + 1][posyf].getIcon() == Tablero.Rey_n) {
									return true;
								}
							}
						}
					}
				}
			}
		}
		return false;
	}
	public boolean isBlanca() {
		for (Icon i: Tablero.getBlancas()) {
			if (i == iconf) {
				return true;
			}
		}
		return false;
	}
	public boolean isNegra() {
		for (Icon i: Tablero.getNegras()) {
			if (i == iconf) {
				return true;
			}
		}
		return false;
	}
	public boolean isPiezaNegra(Icon pieza) {
		for (Icon i: Tablero.getNegras()) {
			if (i == pieza) {
				return true;
			}
		}
		return false;
	}
}
