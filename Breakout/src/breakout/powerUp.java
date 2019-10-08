package breakout;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class powerUp extends Rectangle {

	
		
		private static final long serialVersionUID = 1L;
		Color c1 = new Color(255, 0, 0); //Red. Melt thru bricks
		Color c2 = new Color(255, 255, 255); //White. Life Up
		Color c3 = new Color(0, 255, 0); //Green. Slower ball.
		Color c4 = new Color(0,0,255); //Blue. Bigger paddle
		Color c5 = new Color(255,0,255); //Purple. Smaller Paddle.
		Color c6 = new Color(100,100,100); //Gray. Faster ball.
		Color c7 = new Color(255,255,50); //Yellow. Faster paddle.
		
		int dy = 0;
		int powerhealth = 1;
		int typeofP;
		
		//boolean for destroyed
		boolean showing = false;
		boolean translateit= true;
		boolean cc1, cc2, cc3, cc4, cc5, cc6, cc7;
			
		public powerUp(int x, int y) {
			super(x, y, 10, 10);
			if(x == 3000) {
				showing = false;
			}
		}
		
		public void fall() {
			dy = 3;
		}
		
		
		public void hit() {
			powerhealth--;
		}
		
		public void collided() {
			showing = true;
		}
		//new GradientPaint(0,0,some color,0, 0, some color)
		//The first pair of coordinates = 
		
		public void typeOfPowerup(int rand1) {
			typeofP = rand1;
		}
		
		public void getridofP() {
			showing = false;
		}
		
		
		
		public void moveAndDraw(Graphics2D win) {
			
			if(typeofP < 1) {
			win.setColor(c1);
			cc1 = true;
			cc2 = false;
			cc3 = false;
			cc4 = false;
			cc5 = false;
			cc6 = false; 
			cc7 = false;
			}
			if(typeofP == 1) {
				win.setColor(c2);
				cc2 = true;
				cc1 = false;
				cc3 = false;
				cc4 = false;
				cc5 = false;
				cc6 = false; 
				cc7 = false;
			}
			if(typeofP == 2) {
				win.setColor(c3);
				cc3 = true;
				cc1 = false;
				cc2 = false;
				
				cc4 = false;
				cc5 = false;
				cc6 = false; 
				cc7 = false;
			}
			if(typeofP == 3) {
				win.setColor(c4);
				cc4 = true;
				cc1 = false;
				cc2 = false;
				cc3 = false;
				cc5 = false;
				cc6 = false; 
				cc7 = false;
			}
			if(typeofP == 4) {
				win.setColor(c5);
				cc5 = true;
				cc1 = false;
				cc2 = false;
				cc3 = false;
				cc4 = false;
				cc6 = false; 
				cc7 = false;
			}
			if(typeofP == 5) {
				win.setColor(c6);
				cc6 = true;
				cc1 = false;
				cc2 = false;
				cc3 = false;
				cc4 = false;
				cc5 = false; 
				cc7 = false;
			}
			if(typeofP == 6) {
				win.setColor(c7);
				cc7 = true;
				cc1 = false;
				cc2 = false;
				cc3 = false;
				cc4 = false;
				cc5 = false;
				cc6 = false; 
			}
		
			
			this.translate(0, dy);
			
			if(showing) {
				win.fill(this);
				
			}
		
		}
}
		
		
	