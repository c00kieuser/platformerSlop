package main;

import java.awt.MouseInfo;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;


public class MouseHandler implements MouseListener,MouseWheelListener,MouseMotionListener {

	GamePanel gp;
	private boolean clicked;
	MouseEvent l;
	int mouseX;
	int mouseY;
	
	public boolean isClicked() {
		return clicked;
	}

	

	public MouseHandler(GamePanel gp) {
		this.gp=gp;
		clicked=false;
		
	}
	public void setClicked(boolean crap) {
		clicked=crap;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {

		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		l=e;
		clicked=true;
		
		e.consume();
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		
		l=e;
		clicked=false;
		e.consume();
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}
	public MouseEvent getMouseEvent() {
		return l;
	}
	public void setMouseEvent(MouseEvent uhm) {
		
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		
	}
	
	public int getMouseX() {
		return mouseX;
	}

	public int getMouseY() {
		return mouseY;
	}

	@Override
	public void mouseMoved(MouseEvent e) {
			
	}
	
}