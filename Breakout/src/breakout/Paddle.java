package breakout;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Paddle extends Rectangle implements KeyListener {
	
	int dx, speed = 10;
	int size = 0;
	int sizeSlow = 0;
	int yellowP = 0;
	boolean leftP = false, rightP = false;
	int keyLeft, keyRight;
	
	public Paddle(int x, int y, int width, int height) {
		
		super(x, y, 100, 15);
		
		keyLeft = width;
		keyRight = height;
	
		
	}

	public void makeBigger() {
		if(size < 1) {
		this.width += 25;
		size++;
		sizeSlow--;
		}
	}
	
	public void fasterMove() {
		//yellow 
		if(yellowP < 1) {
			speed += 2;
		}
		yellowP++;
	}
	
	
public void makeSmaller() {
		if(sizeSlow < 1) {
		this.width -= 25;
		sizeSlow++;
		size--;
		}
	}
	
	
	public void moveAndDraw(Graphics2D win) {
		
		int dx = 0;
		if(this.leftP) {
			dx = -speed;	
		}
		if(this.rightP) {
			dx = speed;
		}
		
		if(size == 0) {
		if (this.getX() + dx > 985) {
			dx = 0;
		}
		if(this.getX() + dx < 0) {
			dx = 0;
		}
		}
		if(size == 1) {
			if (this.getX() + dx > 960) {
				dx = 0;
			}
			if(this.getX() + dx < 0) {
				dx = 0;
			}
			
		}
		
		if(size == 2) {
			if (this.getX() + dx > 935) {
				dx = 0;
			}
			if(this.getX() + dx < 0) {
				dx = 0;
			}
			
		}
		if(size == -1) {
			if (this.getX() + dx > 1010) {
				dx = 0;
			}
			if(this.getX() + dx < 0) {
				dx = 0;
			}
			
		}
		if(size == -2) {
			if (this.getX() + dx > 1035) {
				dx = 0;
			}
			if(this.getX() + dx < 0) {
				dx = 0;
			}
			
		}
		
		
		
		
		
		this.translate((int) dx, 0);
		
		win.setColor(Color.RED);
		win.fill(this);
		
		
	}
	
	
	

	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == this.keyLeft) {
			leftP = true;
		}
		if(e.getKeyCode() == this.keyRight) {
			rightP = true;
		}
		
		
	}

	public void keyReleased(KeyEvent e) {
		
		if(e.getKeyCode() == this.keyLeft) {
			leftP = false;
		}
		if(e.getKeyCode() == this.keyRight) {
			rightP = false;
		}
		
	}

	public void keyTyped(KeyEvent arg0) {
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}