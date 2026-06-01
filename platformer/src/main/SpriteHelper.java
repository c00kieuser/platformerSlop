package main;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import javax.imageio.ImageIO;

//the mission here is to be smarter than my current status quo
//can we make a class where we can use a res file as a parameter
//make images in such file an array and move through the array to draw sprites?

//primarily trying to cut down lines of code in things we have to draw
//is there a possibility of cutting down how many lines it takes to draw everything?

import main.GamePanel;

public class SpriteHelper{
	
	
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
	
	//whats unique to each object using class? #(frames), file
	
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
	//we'll see how it looks when multiple objects use this, but rn i want spriteNum
	//to be static as to not be running soo many useless counters, optimization yo
	//run this on its own in gp's update
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
