package main;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import javax.imageio.ImageIO;


public class SpriteHelper{
	
	//sprite helper runs like shit on the red laptop but as does everything
	//the class works beautifully if you can get a functional filepath
	//these are tricky cos they change per device, i havent found out why
	//pperil doesnt do ts
	
	//might need to tweak activation threshold per animation
	
	static int spriteNum=1;
	static int spriteThreshold=0;
	ArrayList<BufferedImage> images=new ArrayList<BufferedImage>();
	BufferedImage image2draw;
	int x,y,width,height;

	
	public SpriteHelper(int x, int y, int width, int height) {
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
	}
	public SpriteHelper() {
		
	}
	
	//this "gets" all the images for a sprites animation and puts em in a list
	//use this in the setup of anything with an image
	
	public void spriteLoad(File[] imageList) {
		for (File png: imageList) {
			try {
				BufferedImage image=ImageIO.read(png);
				images.add(image);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	

	public static void countUp() {
		if(spriteThreshold<5) {
			spriteThreshold++;
		}
		else {
			if(spriteNum<24) {
				spriteNum++;
			}
			else {
				spriteNum=1;
			}
			spriteThreshold=0;
		}
			
	}
	
	public void update() {
		for(int frameSelect=0;frameSelect<images.size();frameSelect++) {
			if(spriteNum%images.size()==frameSelect) {
				image2draw=images.get(frameSelect);
			}	
		}
		
	}
	
	public void draw(Graphics2D g2) {
		g2.drawImage(image2draw, x,y,width,height,null);
	}
	
}
