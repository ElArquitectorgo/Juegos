package tablero;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;

public class Posibles {
	public static int cnt = 0;
	/**
	 * Método que calcula las casillas donde puedes mover la pieza seleccionada
	 * @param iii = fila de la pieza
	 * @param jjj = columna de la pieza
	 * @param icon = icono de la pieza
	 */
	public static List<Integer> Posibles(int iii, int jjj, Icon icon) {
		List<Integer> posibles = new ArrayList<Integer>();
		// Movimientos Peon_b
		if (icon == Tablero.Peon_b) {
			if (iii - 1 >= 0 && Tablero.tablero[iii - 1][jjj].getIcon() == null) {
				posibles.add(iii - 1);posibles.add(jjj);
				if (iii == 6 && Tablero.tablero[iii - 2][jjj].getIcon() == null) {
					posibles.add(iii - 2);posibles.add(jjj);
				}
			}
			// Diagonal
			if (iii - 1 >= 0 && jjj - 1 >= 0 && Mover.isPiezaNegra(Tablero.tablero[iii - 1][jjj - 1].getIcon())) {
				posibles.add(iii - 1);posibles.add(jjj - 1);
			}
			if (iii - 1 >= 0 && jjj + 1 <= 7 && Mover.isPiezaNegra(Tablero.tablero[iii - 1][jjj + 1].getIcon())) {
				posibles.add(iii - 1);posibles.add(jjj + 1);
			}
		}
		// Movimientos Torre
		else if (icon == Tablero.Torre_b || icon == Tablero.Torre_n) {
			int j = jjj + 1;
			// A la derecha
			while (j <= 7 && Tablero.tablero[iii][j].getIcon() == null) {
				posibles.add(iii);posibles.add(j);
				j += 1;
			}
			// A la izquierda
			int jj = jjj - 1;
			while (jj >= 0 && Tablero.tablero[iii][jj].getIcon() == null) {
				posibles.add(iii);posibles.add(jj);
				jj -= 1;
			}			
			// Hacia arriba
			int i = iii - 1;
			while (i >= 0 && Tablero.tablero[i][jjj].getIcon() == null) {
				posibles.add(i);posibles.add(jjj);
				i -= 1;
			}		
			// Hacia abajo
			int ii = iii + 1;
			while (ii <= 7 && Tablero.tablero[ii][jjj].getIcon() == null) {
				posibles.add(ii);posibles.add(jjj);
				ii += 1;
			}
			if (icon == Tablero.Torre_b) {
				if (j <= 7 && Mover.isPiezaNegra(Tablero.tablero[iii][j].getIcon())) {
					posibles.add(iii);posibles.add(j);
				}
				if (jj >= 0 && Mover.isPiezaNegra(Tablero.tablero[iii][jj].getIcon())) {
					posibles.add(iii);posibles.add(jj);
				}
				if (i >= 0 && Mover.isPiezaNegra(Tablero.tablero[i][jjj].getIcon())) {
					posibles.add(i);posibles.add(jjj);
				}
				if (ii <= 7 && Mover.isPiezaNegra(Tablero.tablero[ii][jjj].getIcon())) {
					posibles.add(ii);posibles.add(jjj);
				}
			}
			else {
				if (j <= 7 && Mover.isPiezaBlanca(Tablero.tablero[iii][j].getIcon())) {
					posibles.add(iii);posibles.add(j);
				}
				if (jj >= 0 && Mover.isPiezaBlanca(Tablero.tablero[iii][jj].getIcon())) {
					posibles.add(iii);posibles.add(jj);
				}
				if (i >= 0 && Mover.isPiezaBlanca(Tablero.tablero[i][jjj].getIcon())) {
					posibles.add(i);posibles.add(jjj);
				}
				if (ii <= 7 && Mover.isPiezaBlanca(Tablero.tablero[ii][jjj].getIcon())) {
					posibles.add(ii);posibles.add(jjj);
				}
			}
			
		}
		// Movimientos Alfil
		else if (icon == Tablero.Alfil_b || icon == Tablero.Alfil_n) {
			int i = iii + 1; int j = jjj + 1;
			// Abajo derecha
			while (i <= 7 && j <= 7 && Tablero.tablero[i][j].getIcon() == null) {
				posibles.add(i);posibles.add(j);
				i += 1; j += 1;
			}
			int ii = iii + 1; int jj = jjj - 1;
			// Abajo izquierda
			while (ii <= 7 && jj >= 0 && Tablero.tablero[ii][jj].getIcon() == null) {
				posibles.add(ii);posibles.add(jj);
				ii += 1; jj -= 1;
			}			
			// Arriba derecha
			int iiv = iii - 1; int jiv = jjj + 1;
			while (iiv >= 0 && jiv <= 7 && Tablero.tablero[iiv][jiv].getIcon() == null) {
				posibles.add(iiv);posibles.add(jiv);
				iiv -= 1; jiv += 1;
			}			
			// Arriba izquierda
			int iv = iii - 1; int jv = jjj - 1;
			while (iv >= 0 && jv >= 0 && Tablero.tablero[iv][jv].getIcon() == null) {
				posibles.add(iv);posibles.add(jv);
				iv -= 1; jv -= 1;
			}
			if (icon == Tablero.Alfil_b) {
				if (i <= 7 && j <= 7 && Mover.isPiezaNegra(Tablero.tablero[i][j].getIcon())) {
					posibles.add(i);posibles.add(j);
				}
				if (ii <= 7 && jj >= 0 && Mover.isPiezaNegra(Tablero.tablero[ii][jj].getIcon())) {
					posibles.add(ii);posibles.add(jj);
				}
				if (iiv >= 0 && jiv <= 7 && Mover.isPiezaNegra(Tablero.tablero[iiv][jiv].getIcon())) {
					posibles.add(iiv);posibles.add(jiv);
				}
				if (iv >= 0 && jv >= 0 && Mover.isPiezaNegra(Tablero.tablero[iv][jv].getIcon())) {
					posibles.add(iv);posibles.add(jv);
				}
			}
			else {
				if (i <= 7 && j <= 7 && Mover.isPiezaBlanca(Tablero.tablero[i][j].getIcon())) {
					posibles.add(i);posibles.add(j);
				}
				if (ii <= 7 && jj >= 0 && Mover.isPiezaBlanca(Tablero.tablero[ii][jj].getIcon())) {
					posibles.add(ii);posibles.add(jj);
				}
				if (iiv >= 0 && jiv <= 7 && Mover.isPiezaBlanca(Tablero.tablero[iiv][jiv].getIcon())) {
					posibles.add(iiv);posibles.add(jiv);
				}
				if (iv >= 0 && jv >= 0 && Mover.isPiezaBlanca(Tablero.tablero[iv][jv].getIcon())) {
					posibles.add(iv);posibles.add(jv);
				}
			}
		}
		// Movimientos Caballo_b
		else if (icon == Tablero.Caballo_b) {
			// Arriba
			if (iii - 2 >= 0 && jjj - 1 >= 0 && !Mover.isPiezaBlanca(Tablero.tablero[iii - 2][jjj - 1].getIcon())) {
				posibles.add(iii - 2);posibles.add(jjj - 1);
			}
			if (iii - 2 >= 0 && jjj + 1 <= 7 && !Mover.isPiezaBlanca(Tablero.tablero[iii - 2][jjj + 1].getIcon())) {
				posibles.add(iii - 2);posibles.add(jjj + 1);
			}
			if (iii - 1 >= 0 && jjj - 2 >= 0 && !Mover.isPiezaBlanca(Tablero.tablero[iii - 1][jjj - 2].getIcon())) {
				posibles.add(iii - 1);posibles.add(jjj - 2);
			}
			if (iii - 1 >= 0 && jjj + 2 <= 7 && !Mover.isPiezaBlanca(Tablero.tablero[iii - 1][jjj + 2].getIcon())) {
				posibles.add(iii - 1);posibles.add(jjj + 2);
			}
			// Abajo
			if (iii + 2 <= 7 && jjj - 1 >= 0 && !Mover.isPiezaBlanca(Tablero.tablero[iii + 2][jjj - 1].getIcon())) {
				posibles.add(iii + 2);posibles.add(jjj - 1);
			}
			if (iii + 2 <= 7 && jjj + 1 <= 7 && !Mover.isPiezaBlanca(Tablero.tablero[iii + 2][jjj + 1].getIcon())) {
				posibles.add(iii + 2);posibles.add(jjj + 1);
			}
			if (iii + 1 <= 7 && jjj - 2 >= 0 && !Mover.isPiezaBlanca(Tablero.tablero[iii + 1][jjj - 2].getIcon())) {
				posibles.add(iii + 1);posibles.add(jjj - 2);
			}
			if (iii + 1 <= 7 && jjj + 2 <= 7 && !Mover.isPiezaBlanca(Tablero.tablero[iii + 1][jjj + 2].getIcon())) {
				posibles.add(iii + 1);posibles.add(jjj + 2);
			}
		}
		// Movimientos Dama
		else if (icon == Tablero.Dama_b || icon == Tablero.Dama_n) {
			int j = jjj + 1;
			// A la derecha
			while (j <= 7 && Tablero.tablero[iii][j].getIcon() == null) {
				posibles.add(iii);posibles.add(j);
				j += 1;
			}
			// A la izquierda
			int jj = jjj - 1;
			while (jj >= 0 && Tablero.tablero[iii][jj].getIcon() == null) {
				posibles.add(iii);posibles.add(jj);
				jj -= 1;
			}			
			// Hacia arriba
			int i = iii - 1;
			while (i >= 0 && Tablero.tablero[i][jjj].getIcon() == null) {
				posibles.add(i);posibles.add(jjj);
				i -= 1;
			}			
			// Hacia abajo
			int ii = iii + 1;
			while (ii <= 7 && Tablero.tablero[ii][jjj].getIcon() == null) {
				posibles.add(ii);posibles.add(jjj);
				ii += 1;
			}			
			int ai = iii + 1; int aj = jjj + 1;
			// Abajo derecha
			while (ai <= 7 && aj <= 7 && Tablero.tablero[ai][aj].getIcon() == null) {
				posibles.add(ai);posibles.add(aj);
				ai += 1; aj += 1;
			}			
			int aii = iii + 1; int ajj = jjj - 1;
			// Abajo izquierda
			while (aii <= 7 && ajj >= 0 && Tablero.tablero[aii][ajj].getIcon() == null) {
				posibles.add(aii);posibles.add(ajj);
				aii += 1; ajj -= 1;
			}			
			// Arriba derecha
			int iiv = iii - 1; int jiv = jjj + 1;
			while (iiv >= 0 && jiv <= 7 && Tablero.tablero[iiv][jiv].getIcon() == null) {
				posibles.add(iiv);posibles.add(jiv);
				iiv -= 1; jiv += 1;
			}			
			// Arriba izquierda
			int iv = iii - 1; int jv = jjj - 1;
			while (iv >= 0 && jv >= 0 && Tablero.tablero[iv][jv].getIcon() == null) {
				posibles.add(iv);posibles.add(jv);
				iv -= 1; jv -= 1;
			}
			if (icon == Tablero.Dama_b) {
				if (j <= 7 && Mover.isPiezaNegra(Tablero.tablero[iii][j].getIcon())) {
					posibles.add(iii);posibles.add(j);
				}
				if (jj >= 0 && Mover.isPiezaNegra(Tablero.tablero[iii][jj].getIcon())) {
					posibles.add(iii);posibles.add(jj);
				}
				if (i >= 0 && Mover.isPiezaNegra(Tablero.tablero[i][jjj].getIcon())) {
					posibles.add(i);posibles.add(jjj);
				}
				if (ii <= 7 && Mover.isPiezaNegra(Tablero.tablero[ii][jjj].getIcon())) {
					posibles.add(ii);posibles.add(jjj);
				}
				if (ai <= 7 && aj <= 7 && Mover.isPiezaNegra(Tablero.tablero[ai][aj].getIcon())) {
					posibles.add(ai);posibles.add(aj);
				}
				if (aii <= 7 && ajj >= 0 && Mover.isPiezaNegra(Tablero.tablero[aii][ajj].getIcon())) {
					posibles.add(aii);posibles.add(ajj);
				}
				if (iiv >= 0 && jiv <= 7 && Mover.isPiezaNegra(Tablero.tablero[iiv][jiv].getIcon())) {
					posibles.add(iiv);posibles.add(jiv);
				}
				if (iv >= 0 && jv >= 0 && Mover.isPiezaNegra(Tablero.tablero[iv][jv].getIcon())) {
					posibles.add(iv);posibles.add(jv);
				}
			}
			else {
				if (j <= 7 && Mover.isPiezaBlanca(Tablero.tablero[iii][j].getIcon())) {
					posibles.add(iii);posibles.add(j);
				}
				if (jj >= 0 && Mover.isPiezaBlanca(Tablero.tablero[iii][jj].getIcon())) {
					posibles.add(iii);posibles.add(jj);
				}
				if (i >= 0 && Mover.isPiezaBlanca(Tablero.tablero[i][jjj].getIcon())) {
					posibles.add(i);posibles.add(jjj);
				}
				if (ii <= 7 && Mover.isPiezaBlanca(Tablero.tablero[ii][jjj].getIcon())) {
					posibles.add(ii);posibles.add(jjj);
				}
				if (ai <= 7 && aj <= 7 && Mover.isPiezaBlanca(Tablero.tablero[ai][aj].getIcon())) {
					posibles.add(ai);posibles.add(aj);
				}
				if (aii <= 7 && ajj >= 0 && Mover.isPiezaBlanca(Tablero.tablero[aii][ajj].getIcon())) {
					posibles.add(aii);posibles.add(ajj);
				}
				if (iiv >= 0 && jiv <= 7 && Mover.isPiezaBlanca(Tablero.tablero[iiv][jiv].getIcon())) {
					posibles.add(iiv);posibles.add(jiv);
				}
				if (iv >= 0 && jv >= 0 && Mover.isPiezaBlanca(Tablero.tablero[iv][jv].getIcon())) {
					posibles.add(iv);posibles.add(jv);
				}
			}
		}		
		// Movimientos Rey_b
		else if (icon == Tablero.Rey_b) {
			// Abajos
			if (iii + 1 <= 7 && !Mover.isPiezaBlanca(Tablero.tablero[iii + 1][jjj].getIcon())) {
				posibles.add(iii + 1);posibles.add(jjj);
			}
			if (iii + 1 <= 7 && jjj + 1 <= 7 && !Mover.isPiezaBlanca(Tablero.tablero[iii + 1][jjj + 1].getIcon())) {
				posibles.add(iii + 1);posibles.add(jjj + 1);
			}
			if (iii + 1 <= 7 && jjj - 1 >= 0 && !Mover.isPiezaBlanca(Tablero.tablero[iii + 1][jjj - 1].getIcon())) {
				posibles.add(iii + 1);posibles.add(jjj - 1);
			}
			// Arribas
			if (iii - 1 >= 0 && !Mover.isPiezaBlanca(Tablero.tablero[iii - 1][jjj].getIcon())) {
				posibles.add(iii - 1);posibles.add(jjj);
			}
			if (iii - 1 >= 0 && jjj + 1 <= 7 && !Mover.isPiezaBlanca(Tablero.tablero[iii - 1][jjj + 1].getIcon())) {
				posibles.add(iii - 1);posibles.add(jjj + 1);
			}
			if (iii - 1 >= 0 && jjj - 1 >= 0 && !Mover.isPiezaBlanca(Tablero.tablero[iii - 1][jjj - 1].getIcon())) {
				posibles.add(iii - 1);posibles.add(jjj - 1);
			}
			// Izquierda y derecha
			if (jjj - 1 >= 0 && !Mover.isPiezaBlanca(Tablero.tablero[iii][jjj - 1].getIcon())) {
				posibles.add(iii);posibles.add(jjj - 1);
			}
			if (jjj + 1 <= 7 && !Mover.isPiezaBlanca(Tablero.tablero[iii][jjj + 1].getIcon())) {
				posibles.add(iii);posibles.add(jjj + 1);
			}
		}		
		// Movimientos Peon_n
		else if (icon == Tablero.Peon_n) {
			if (iii + 1 <= 7 && Tablero.tablero[iii + 1][jjj].getIcon() == null) {
				posibles.add(iii + 1);posibles.add(jjj);
				if (iii == 1 && Tablero.tablero[iii + 2][jjj].getIcon() == null) {
					posibles.add(iii + 2);posibles.add(jjj);
				}
			}
			// Diagonal
			if (iii + 1 <= 7 && jjj - 1 >= 0 && Mover.isPiezaBlanca(Tablero.tablero[iii + 1][jjj - 1].getIcon())) {
				posibles.add(iii + 1);posibles.add(jjj - 1);
			}
			if (iii + 1 <= 7 && jjj + 1 <= 7 && Mover.isPiezaBlanca(Tablero.tablero[iii + 1][jjj + 1].getIcon())) {
				posibles.add(iii + 1);posibles.add(jjj + 1);
			}
		}
		// Movimientos Caballo_n
		else if (icon == Tablero.Caballo_n) {
			// Arriba
			if (iii - 2 >= 0 && jjj - 1 >= 0 && !Mover.isPiezaNegra(Tablero.tablero[iii - 2][jjj - 1].getIcon())) {
				posibles.add(iii - 2);posibles.add(jjj - 1);
			}
			if (iii - 2 >= 0 && jjj + 1 <= 7 && !Mover.isPiezaNegra(Tablero.tablero[iii - 2][jjj + 1].getIcon())) {
				posibles.add(iii - 2);posibles.add(jjj + 1);
			}
			if (iii - 1 >= 0 && jjj - 2 >= 0 && !Mover.isPiezaNegra(Tablero.tablero[iii - 1][jjj - 2].getIcon())) {
				posibles.add(iii - 1);posibles.add(jjj - 2);
			}
			if (iii - 1 >= 0 && jjj + 2 <= 7 && !Mover.isPiezaNegra(Tablero.tablero[iii - 1][jjj + 2].getIcon())) {
				posibles.add(iii - 1);posibles.add(jjj + 2);
			}
			// Abajo
			if (iii + 2 <= 7 && jjj - 1 >= 0 && !Mover.isPiezaNegra(Tablero.tablero[iii + 2][jjj - 1].getIcon())) {
				posibles.add(iii + 2);posibles.add(jjj - 1);
			}
			if (iii + 2 <= 7 && jjj + 1 <= 7 && !Mover.isPiezaNegra(Tablero.tablero[iii + 2][jjj + 1].getIcon())) {
				posibles.add(iii + 2);posibles.add(jjj + 1);
			}
			if (iii + 1 <= 7 && jjj - 2 >= 0 && !Mover.isPiezaNegra(Tablero.tablero[iii + 1][jjj - 2].getIcon())) {
				posibles.add(iii + 1);posibles.add(jjj - 2);
			}
			if (iii + 1 <= 7 && jjj + 2 <= 7 && !Mover.isPiezaNegra(Tablero.tablero[iii + 1][jjj + 2].getIcon())) {
				posibles.add(iii + 1);posibles.add(jjj + 2);
			}
		}
		// Movimientos Rey_n
		else if (icon == Tablero.Rey_n) {
			// Abajos
			if (iii + 1 <= 7 && !Mover.isPiezaNegra(Tablero.tablero[iii + 1][jjj].getIcon())) {
				posibles.add(iii + 1);posibles.add(jjj);
			}
			if (iii + 1 <= 7 && jjj + 1 <= 7 && !Mover.isPiezaNegra(Tablero.tablero[iii + 1][jjj + 1].getIcon())) {
				posibles.add(iii + 1);posibles.add(jjj + 1);
			}
			if (iii + 1 <= 7 && jjj - 1 >= 0 && !Mover.isPiezaNegra(Tablero.tablero[iii + 1][jjj - 1].getIcon())) {
				posibles.add(iii + 1);posibles.add(jjj - 1);
			}
			// Arribas
			if (iii - 1 >= 0 && !Mover.isPiezaNegra(Tablero.tablero[iii - 1][jjj].getIcon())) {
				posibles.add(iii - 1);posibles.add(jjj);
			}
			if (iii - 1 >= 0 && jjj + 1 <= 7 && !Mover.isPiezaNegra(Tablero.tablero[iii - 1][jjj + 1].getIcon())) {
				posibles.add(iii - 1);posibles.add(jjj + 1);
			}
			if (iii - 1 >= 0 && jjj - 1 >= 0 && !Mover.isPiezaNegra(Tablero.tablero[iii - 1][jjj - 1].getIcon())) {
				posibles.add(iii - 1);posibles.add(jjj - 1);
			}
			// Izquierda y derecha
			if (jjj - 1 >= 0 && !Mover.isPiezaNegra(Tablero.tablero[iii][jjj - 1].getIcon())) {
				posibles.add(iii);posibles.add(jjj - 1);
			}
			if (jjj + 1 <= 7 && !Mover.isPiezaNegra(Tablero.tablero[iii][jjj + 1].getIcon())) {
				posibles.add(iii);posibles.add(jjj + 1);
			}
		}
		return posibles;
	}
	
	public static void pinta(int iii, int jjj, Icon icon) {
		List<Integer> posibles = Posibles(iii, jjj, icon);
		for (int eles = 0; eles < posibles.size() - 1; eles += 2) {
			Icon iconf = Tablero.tablero[posibles.get(eles)][posibles.get(eles + 1)].getIcon();
			Tablero.tablero[iii][jjj].setIcon(null);
			Tablero.tablero[posibles.get(eles)][posibles.get(eles + 1)].setIcon(icon);
			if (!Mover.isClavada(posibles.get(eles), posibles.get(eles + 1))) {
				Tablero.tablero[posibles.get(eles)][posibles.get(eles + 1)].setBackground(Color.getHSBColor(90, 90, 50));
				cnt += 1;
			}
			Tablero.tablero[posibles.get(eles)][posibles.get(eles + 1)].setIcon(iconf);
			Tablero.tablero[iii][jjj].setIcon(icon);
		}
	}
	
	public static void repinta() {
		// Repinta el tablero
		for (int ii = 0; ii < 8; ii++) {
			for (int jj = 0; jj < 8; jj++) {
				if (ii % 2 == 0 && jj % 2 != 0 || ii % 2 != 0 && jj % 2 == 0) {
					Tablero.tablero[ii][jj].setBackground(Color.getHSBColor(40, 47, 92));
				}
				else {
					Tablero.tablero[ii][jj].setBackground(Color.white);
				}
			}
		}
	}
	
	public static boolean isJaqueMate() {
		boolean isJaqueMate = false;
		cnt = 0;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (Tablero.cnt % 2 != 0) {
					if (Mover.isPiezaNegra(Tablero.tablero[i][j].getIcon())) {
						pinta(i, j, Tablero.tablero[i][j].getIcon());
						if (cnt == 0) {
							isJaqueMate = true;
						}
						else {
							return false;
						}
					}
				}
				else {
					if (Mover.isPiezaBlanca(Tablero.tablero[i][j].getIcon())) {
						pinta(i, j, Tablero.tablero[i][j].getIcon());
						if (cnt == 0) {
							isJaqueMate = true;
						}
						else {
							return false;
						}
					}
				}
			}
		}
		return isJaqueMate;
	}
}
