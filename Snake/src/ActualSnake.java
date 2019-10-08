import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class ActualSnake extends Rectangle implements KeyListener {

	ArrayList<Rectangle> body = new ArrayList<Rectangle>();
	
	int up, down, left, right, delay = 6, timer = 0, bodysize = 0;
	boolean isUp = false, isDown = false, isRight = false, isLeft = false;
	boolean gameOver = false;
	
	public ActualSnake(int x, int y, int isUp, int isDown, int isRight, int isLeft) {
		super(x, y, 29, 29);
		up = isUp;
		down = isDown;
		right = isRight;
		left = isLeft;
	}
	
	public void removePieces() {
		if(body.size() >= 2) {
		body.remove(body.size() - 1);
		body.remove(body.size() - 1);
		bodysize -= 2;
		}
		else {
			gameOver = true;
		}
		
	}
	
	public void addPieces() {
		
		for(int i = 1; i < 3; i++) {
			//check the last piece. if above it is filled then add down. left is filled add to right e
			int a = body.size() - 1;
			if(a >= 1) {
					if(body.get(a).y - 30 == body.get(a - 1).y) {
						body.add(new Rectangle(body.get(a).x, body.get(a).y + 30, 29, 29));
						bodysize++;
					}
					
					if(body.get(a).y + 30 == body.get(a - 1).y) {
						body.add(new Rectangle(body.get(a).x, body.get(a).y - 30, 29, 29));
						bodysize++;
					}
					
					if(body.get(a).x - 30 == body.get(a - 1).x) {
						body.add(new Rectangle(body.get(a).x + 30, body.get(a).y, 29, 29));
						bodysize++;
					}
					
					if(body.get(a).x + 30 == body.get(a - 1).x) {
						body.add(new Rectangle(body.get(a).x - 30, body.get(a).y, 29, 29));
						bodysize++;
					}	
				}
				else {
					if(this.isUp) {
						body.add(new Rectangle(this.x, this.y + 30*(body.size()), 29, 29));
						body.add(new Rectangle(this.x, this.y + 30*(body.size()), 29, 29));
						bodysize++;
						bodysize++;
					}
					
					if(this.isDown) {
						body.add(new Rectangle(this.x, this.y - 30*(body.size() ), 29, 29));
						body.add(new Rectangle(this.x, this.y - 30*(body.size()), 29, 29));
						bodysize++;
						bodysize++;
					}
					
					if(this.isRight) {
						body.add(new Rectangle(this.x - 30*(body.size()) , this.y, 29, 29));
						body.add(new Rectangle(this.x - 30*(body.size()) , this.y, 29, 29));
						bodysize++;
						bodysize++;
					}
					
					if(this.isLeft) {
						body.add(new Rectangle(this.x + 30*(body.size()) , this.y, 29, 29));
						body.add(new Rectangle(this.x + 30*(body.size()) , this.y, 29, 29));
						bodysize++;
						bodysize++;
					}
				
				
			}
		}
		
	}
	
	
	
	public void moveAndDraw(Graphics2D win) {
		
		if(timer ==  delay) {
			
			for(int i = 0; i < body.size(); i++) {
			
				int a  = body.size() - 1 - i;		//This will be the very last piece
				
				if(a > 0) {
					int newx = body.get(a - 1).x;		//Second to last piece coords
					int newy = body.get(a - 1).y;
					body.get(a).x = newx;			//make last piece coords second to last pieces
					body.get(a).y = newy;
				}

				if(a == 0) {
					body.get(a).x = this.x;
					body.get(a).y = this.y;
				}
			
			}
				
				
				
			if(this.isUp) {
				this.y -= 30;	
			}
			
			if(this.isDown) {
				this.y += 30;
			}
			
			if(this.isRight) {
				this.x += 30;
			}
			
			if(this.isLeft) {
				this.x -= 30;
			}
			
			timer = 0;
		
		}
		else {
			timer++;
		}
		
		
		win.setColor(Color.YELLOW);
		win.fill(this);
		win.setColor(Color.BLUE);
		
		for(int i = 0; i < body.size(); i++) {
			win.fill(body.get(i));
		}
		
		
		
	}

	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_0) {
			isDown = false;	
			isUp = false; 	
			isRight = false;
			isLeft = false;
		}
		
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
		
		
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
	
}
