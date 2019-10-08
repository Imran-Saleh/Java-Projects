package breakout;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class movingBrick extends Rectangle {

	private static final long serialVersionUID = 1L;
	Color c1 = new Color(244, 66, 170);
	Color c2 = new Color(200, 0, 0);
	Color c3 = new Color(100, 0, 0);
	
	Rectangle redge = new Rectangle(1098, 0, 1, 600);
	Rectangle lowedge = new Rectangle(0, 400, 1100, 1);
	Rectangle topedge = new Rectangle(0, 1, 1100, 1);
	int brickhealth = 1;
	int dx = 3;
	int dy = 0;
	Effect effect;
	
	//boolean for destroyed
	boolean isDestroyed = false;
	
		
	public movingBrick(int x, int y) {
		super(x, y, 100, 25);
	}
	
	
	public void hit() {
		brickhealth--;
		effect = new Effect((int) this.getCenterX(), (int) this.getCenterY());
	}
	//new GradientPaint(0,0,some color,0, 0, some color)
	//The first pair of coordinates = 
	
	public void bricklivesLVL1(int decidehealth) {
		
		if(decidehealth < 10) {
			brickhealth = 3;
		}
		if(decidehealth >= 10 && decidehealth < 20) {
			brickhealth = 2;
		}
		
	}
	
	public void lastsection() {
		dy = 2;
		
	}
	
	public void switchDY() {
		dy = -dy;
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
		
		if(this.intersects(topedge)) {
			dy = -dy;
		}
		
		if(this.intersects(redge)) {
			dx = -dx;
		}
		if(this.getX() < 0) {
			
			dx = -dx;
		}
		
		
		if(brickhealth == 0) {
			isDestroyed = true;
			effect.moveAndDraw(win);
		}

		
		if(!isDestroyed) {

			win.fill(this);
			win.setColor(Color.WHITE);
			win.draw(this);
		}
		
		this.translate(dx, dy);
		
		
			
	}
		
		
		
		
		
	
	
	
}
