import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class PacMan extends Rectangle implements KeyListener {

ArrayList<Rectangle> body = new ArrayList<Rectangle>();
	
	int up, down, left, right, delay = 6, timer = 0, bodysize = 0;
	boolean isUp = false, isDown = false, isRight = false, isLeft = false;
	boolean filledInGrid[] = new boolean[1015];
	
	public PacMan(int x, int y, int isUp, int isDown, int isRight, int isLeft) {
		super(x, y, 19, 19);
		up = isUp;
		down = isDown;
		right = isRight;
		left = isLeft;
		
		for(int i = 0; i < filledInGrid.length; i++) {
			filledInGrid[i] = false;
		}
		
		
	}
	
	
	
	
	public void fillGrid() {
		
		
	}
	
	
	
	public void moveAndDraw(Graphics2D win) {
			
		
		if(timer == delay) {
		
		if(this.isUp) {
			this.y -= 20;	
		}
		
		if(this.isDown) {
			this.y += 20;
		}
		
		if(this.isRight) {
			this.x += 20;
		}
		
		if(this.isLeft) {
			this.x -= 20;
		}
		
		timer = 0;
	
	}
	else {
		timer++;
	}
		
		win.setColor(Color.YELLOW);
		win.fill(this);
		
	}


	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == this.down) {
			if(this.isUp) {
				
			}
			else {
			isDown = true;	
			isUp = false; 	
			isRight = false;
			isLeft = false;
		}
		}
		
		if(e.getKeyCode() == this.up) {
			if(this.isDown) {
				
			}
			else {
			isUp = true; 	
			isDown = false;
			isRight = false;
			isLeft = false;
		}
		}
		
		if(e.getKeyCode() == this.right) {
			if(this.isLeft) {
				
			}
			else {
			isRight = true;	
			isUp = false; 	
			isDown = false;
			isLeft = false;
			}
		}
		
		if(e.getKeyCode() == this.left) {
			if(this.isRight) {
				
			}
			else {
			isLeft = true;
			isUp = false;
			isDown = false;
			isRight = false;
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_0) {
			isDown = false;	
			isUp = false; 	
			isRight = false;
			isLeft = false;
		}
		
		
	}



	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
