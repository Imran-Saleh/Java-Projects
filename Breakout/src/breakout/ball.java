package breakout;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class ball extends Rectangle{
	double dx = 4;
	double dy = -4;
	int fastcap = 0, slowcap = 0;
	
	public ball(int x, int y, int size) {
		super(x, y, size, size);
		this.setLocation(x, y);
		
	}
	
	
	public void makeFaster() {
		//Gray
		if(fastcap < 1) {
		dx *= 1.2;
		dy *= 1.2;
		fastcap++;
		}
		
	}
	
	
	public void makeSlower() {
		//Green
		if(slowcap < 1) {
		dx /= 1.2;
		dy /= 1.2;
		slowcap++;
		}
		
	}	
	
	public void increasedy() {
		dy *= 1.5;
	}
	
	
	
	public void moveAndDraw(Graphics2D win) {
		
		
		if(this.getX() + dx > 1070) {
			dx = -dx;
		}
		if(this.getX() + dx < 0) {
			dx = -dx;
		}
		if(this.getY() + dy > 550) {
			dy = -dy;
		}
		if(this.getY() + dy < 0) {
			dy = -dy;
		}
		
		this.translate((int) dx, (int) dy);
		
		win.setColor(Color.WHITE);
		win.fill(this);
		
		
		
	}
	
}