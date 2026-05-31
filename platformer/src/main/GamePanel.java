package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{
	
	public final int tileSize=32;
	final int maxScreenCol=20;
	final int maxScreenRow=12;
	public int screenWidth = tileSize * maxScreenCol;
	public int screenHeight = tileSize * maxScreenRow;
	
	Thread gameThread;
	KeyHandler keyH = new KeyHandler(this);
	private MouseHandler mouseH = new MouseHandler(this);
	Graphics2D g2;
	
	int FPS=60;
	
	
	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.RED);
		this.setDoubleBuffered(true);
		this.setFocusable(true);
	}
	
	public void setupGame() {
		
	}
	
	public void startGameThread() {
		gameThread=new Thread(this);
		gameThread.start();
	}

	public void update() {
		
	}
	
	@Override
	public void run() {
		// time
		double drawInterval = 1000000000 / FPS;
		double nextDrawTime = System.nanoTime() + drawInterval;

		while (gameThread != null) {
			update();
			repaint();
			
			try {
				double remainingTime = nextDrawTime - System.nanoTime();
				remainingTime = remainingTime / 1000000;
				if (remainingTime < 0) {
					remainingTime = 0;
				}
				Thread.sleep((long) remainingTime);
				nextDrawTime += drawInterval;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
