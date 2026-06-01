package testingTails;

import java.awt.Graphics2D;
import java.io.File;

import main.SpriteHelper;
import main.GamePanel;

public class Tails{

	int x=5*main.GamePanel.screenWidth/20;
	int y=3*main.GamePanel.screenHeight/12;
	int width=5*main.GamePanel.screenWidth/20;
	int height=5*main.GamePanel.screenHeight/12;
	File tailsSprites=new File("/home/c00kieuser/git/platformerGit/platformer/res/testImages/");
	File[] spriteList=tailsSprites.listFiles();
	SpriteHelper tailsPix=new SpriteHelper(x,y,width,height);
	
	
	
	public Tails() {
		tailsPix.spriteLoad(spriteList);
	}
	
	public void update() {
		tailsPix.update();
	}
	
	public void draw(Graphics2D g2) {
		tailsPix.draw(g2);
	}


}
