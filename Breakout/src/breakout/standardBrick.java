package breakout;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class standardBrick extends Rectangle{

	private static final long serialVersionUID = 1L;
	static Color c1 = new Color(244, 66, 170);
	static Color c2 = new Color(200, 0, 0);
	static Color c3 = new Color(100, 0, 0);
	
	int brickhealth = 1;
	Effect effect;
	
	//boolean for destroyed
	boolean isDestroyed = false;
		
	public standardBrick(int x, int y) {
		super(x, y, 108, 25);
		if(x == 3000) {
			isDestroyed = true;
		}
		
	}
	
	
	public void hit() {
		brickhealth--;
		if(brickhealth < 1) {
			effect = new Effect((int) this.getCenterX(), (int) this.getCenterY());
			isDestroyed = true;
		}
		
		
		
	}
	//new GradientPaint(0,0,some color,0, 0, some color)
	//The first pair of coordinates = 
	
	public void bricklivesLVL1(int decidehealth) {
		
		if(decidehealth % 2 == 0) {
			brickhealth = 2;
		}
		
	}
public void bricklivesLVL3(int decidehealth) {
		
		if(decidehealth <= 25) {
			brickhealth = 2;
		}
		if(decidehealth > 25 && decidehealth <=40) {
			brickhealth = 3;
		}
		
	}
	
	
	
	
	public void moveAndDraw(Graphics2D win) {
		
		if(brickhealth < 2) {
		win.setColor(c1);
		}
		if(brickhealth == 2) {
			win.setColor(c2);
		}
		if(brickhealth == 3) {
			win.setColor(c3);
		}
		
		
		if(brickhealth == 0) {
			isDestroyed = true;
			effect.moveAndDraw(win);
		}
		
		
		if(!isDestroyed) {
			win.fill(this);
		}	
			
	}
		
		
		
		
		
	}
	
	
	
	
	
	
	

