package game;

import java.awt.Graphics;
import java.awt.Image;
import java.time.Duration;
import java.time.Instant;

import javax.swing.JFrame;

public class Window extends JFrame implements Runnable {
	private static final String TITLE = "Ajedrez Mortal";
	private static Window window = null;
	private boolean isRunning;
	private int currentState;
	private Scene currentScene;
	//private KL keyListener = new KL();
	private ML mouseListener = new ML();
	
	public Window(int width, int height, String title) {
		setSize(width, height);
		setTitle(title);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addMouseListener(mouseListener);
		isRunning = true;
		changeState(1);
	}
	
	public static Window getWindow() {
        if (Window.window == null) 
            Window.window = new Window(800, 830, TITLE);
        return Window.window;
    }
	
	public static int getTileSize() {
		return window.getWidth() / 8;
	}
	
    public void changeState(int newState) {
        currentState = newState;
        switch(currentState) {
            case 0:
                //currentScene = new MenuScene(keyListener, mouseListener); break;
            case 1:
                currentScene = new GameScene(mouseListener); 
                break;
            default:
                // System.out.println("Unknown scene.");
                currentScene = null;
                break;
        }
    }
    
    public void update(double dt) {
        Image dbImage = createImage(getWidth(), getHeight());
        Graphics dbg = dbImage.getGraphics();
        this.draw(dbg);
        getGraphics().drawImage(dbImage, 0, 0, this);
        //currentScene.update(dt);
    }

    public void draw(Graphics g) {
        //Graphics2D g2 = (Graphics2D)g;
        //g.setColor(Color.black);
        //g.fillRect(0, 0, 50, 50);
        currentScene.draw(g);
    }
    
	@Override
	public void run() {
		Instant lastFrameTime = Instant.now();
        try {
            while (isRunning) {
                Instant time = Instant.now();
                double deltaTime = Duration.between(lastFrameTime, time).toNanos() * 10E-10;
                lastFrameTime = Instant.now();

                double deltaWanted = 0.0167;
                update(deltaWanted);
                long msToSleep = (long)((deltaWanted - deltaTime) * 500); //Crear variable para eso
                if (msToSleep > 0) {
                    Thread.sleep(msToSleep);
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        this.dispose();
	}
	
	public void close() {
        isRunning = false;
    }

}
