package Game;

import java.awt.Graphics;

public abstract class Scene {
	abstract void update(double dt);
	abstract void draw(Graphics g);
}
