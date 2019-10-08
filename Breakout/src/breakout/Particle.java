package breakout;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Particle extends Rectangle {

	int dx, dy;
	
	public Particle(int x, int y, int dx, int dy) {
		
		super(x,y,3,3);
		this.dx = dx;
		this.dy = dy;
		
		
		
	}
	
	public void moveAndDraw(Graphics2D win) {
		
		
		this.translate(dx, dy);
		win.setColor(Color.GREEN);
		win.fill(this);
	}
	
	
	
	
	
}
