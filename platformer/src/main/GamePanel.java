package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import testingTails.Tails;

public class GamePanel extends JPanel implements Runnable{
	
	public final static int tileSize=32;
	final static int maxScreenCol=20;
	final static int maxScreenRow=12;
	public static int screenWidth = tileSize * maxScreenCol;
	public static int screenHeight = tileSize * maxScreenRow;
	
	Thread gameThread;
	KeyHandler keyH = new KeyHandler(this);
	private MouseHandler mouseH = new MouseHandler(this);
	Graphics2D g2;
	
	
	Tails t=new Tails();
	
	int FPS=60;
	
	
	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.BLACK);
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
		SpriteHelper.countUp();
		t.update();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2=(Graphics2D)g;
		t.draw(g2);
		
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
