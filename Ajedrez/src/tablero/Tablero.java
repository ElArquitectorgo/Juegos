package tablero;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class Tablero extends JFrame implements ActionListener {
	private final JPanel gui = new JPanel();
	private JPanel chessBoard;
	public static JButton[][] tablero = new JButton[8][8];
	public static String moves = "00";
	public static ImageIcon Rey_b, Dama_b, Alfil_b, Caballo_b, Torre_b, Peon_b, Rey_n, Dama_n, Alfil_n, Caballo_n, Torre_n, Peon_n;
	public static ImageIcon[] piezas_b, piezas_n;
	public static int cnt;

	public Tablero() {
		JFrame f = new JFrame("Ajedrez Mortal");
		gui.setBorder(new EmptyBorder(5, 5, 5, 5));
		chessBoard = new JPanel(new GridLayout(0, 8));
		chessBoard.setBorder(new LineBorder(Color.BLACK));
		gui.add(chessBoard);
		
		Rey_b = new ImageIcon("Reyb.png");
		Dama_b = new ImageIcon("Damab.png");
		Alfil_b = new ImageIcon("Alfilb.png");
		Caballo_b = new ImageIcon("Caballob.png");
		Torre_b = new ImageIcon("Torreb.png");
		Peon_b = new ImageIcon("Peonb.png");
		Rey_n = new ImageIcon("Reyn.png");
		Dama_n = new ImageIcon("Daman.png");
		Alfil_n = new ImageIcon("Alfiln.png");
		Caballo_n = new ImageIcon("Caballon.png");
		Torre_n = new ImageIcon("Torren.png");
		Peon_n = new ImageIcon("Peonn.png");

		Insets buttonMargin = new Insets(0,0,0,0);
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				JButton b = new JButton();
				b.setMargin(buttonMargin);
				ImageIcon icon = new ImageIcon(new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB));
                b.setIcon(icon);
                b.setIcon(null);
				if (i % 2 == 0 && j % 2 != 0 || i % 2 != 0 && j % 2 == 0) {
					b.setBackground(Color.getHSBColor(40, 47, 92));
				}
				else {
					b.setBackground(Color.white);
				}
				tablero[i][j] = b;
				chessBoard.add(tablero[i][j]);
				tablero[i][j].addActionListener(this);
				

				switch (i) {
				case 1: tablero[1][j].setIcon(Peon_n); break;
				case 6: tablero[6][j].setIcon(Peon_b);
				}
			}
		}	
		
		tablero[7][0].setIcon(Torre_b);
		tablero[7][1].setIcon(Caballo_b);
		tablero[7][2].setIcon(Alfil_b);
		tablero[7][3].setIcon(Dama_b);
		tablero[7][4].setIcon(Rey_b);
		tablero[7][5].setIcon(Alfil_b);
		tablero[7][6].setIcon(Caballo_b);
		tablero[7][7].setIcon(Torre_b);
		tablero[0][0].setIcon(Torre_n);
		tablero[0][1].setIcon(Caballo_n);
		tablero[0][2].setIcon(Alfil_n);
		tablero[0][3].setIcon(Dama_n);
		tablero[0][4].setIcon(Rey_n);
		tablero[0][5].setIcon(Alfil_n);
		tablero[0][6].setIcon(Caballo_n);
		tablero[0][7].setIcon(Torre_n);
		f.add(gui);
		f.pack();
		
	    f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (source == tablero[i][j]) {
					moves += String.valueOf(i) + String.valueOf(j);
					new Mover();
				}
			}
		}
	}
	public static ImageIcon[] getBlancas() {
		ImageIcon[] piezas_b = {Rey_b, Dama_b, Alfil_b, Caballo_b, Torre_b, Peon_b};
		return piezas_b;
	}
	public static ImageIcon[] getNegras() {
		ImageIcon[] piezas_n = {Rey_n, Dama_n, Alfil_n, Caballo_n, Torre_n, Peon_n};
		return piezas_n;
	}
}
