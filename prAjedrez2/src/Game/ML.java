package Game;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class ML extends MouseAdapter implements MouseMotionListener {
    private boolean isPressed = false;
    private int x = 0, y = 0;
    
    @Override
    public void mousePressed(MouseEvent e) {
        isPressed = true;
        this.x = e.getX();
        this.y = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        isPressed = false;
        this.x = e.getX();
        this.y = e.getY();
    }

    public int getX() { 
    	return this.x; 
    }
    public int getY() { 
    	return this.y; 
    }

    public boolean isPressed() {
    	return this.isPressed;
    }
    
}
