package breakout;

import java.awt.Color;
import java.awt.Graphics2D;


public class Effect {
	
	Particle[] cluster = new Particle[30];
	
	
	public Effect(int x, int y) {
		
		for(int i = 0; i < cluster.length; i++) {
			
			double dx = (Math.random() * 50 ) * (int)(Math.pow(-1, (int)(Math.random() * 2)));
			double dy = (Math.random() * 50) * (int)(Math.pow(-1, (int)(Math.random() * 2)));
			int xPos = x + (int)(Math.random() * 25)* (int)(Math.pow(-1, (int)(Math.random() * 2)));
			int yPos = y + (int)(Math.random() * 25)* (int)(Math.pow(-1, (int)(Math.random() * 2)));
			
			
			cluster[i] = new Particle(xPos, yPos, (int) dx, (int) dy);
		}
		
	}
	
	
	public void fall(Particle r1) {
		r1.dy += 1;
	}
	
	
	public void moveAndDraw(Graphics2D win) {
		
		
		win.setColor(Color.GREEN);
		
		for(int i = 0; i < cluster.length; i++) {
			
			
			Particle b1 = cluster[i];
			
			b1.moveAndDraw(win);
			
			fall(b1);
			
			
			
			
			
		}
	
		
		
	}
	
	
}

