import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Enemy extends Rectangle {

	double dx = 0, dy = 0;
	boolean enemy1 = false;
	
	
	
	
	public Enemy(int x, int y, int size) {
		
		super(x,y,size,size);
		dx = 3;
		dy = -3;
		
	}
	
	//Once a certain threshold of score has been hit, add an enemy
	public void addAnEnemy() {
		enemy1 = true;
	}
	
	//When the enemy hits the filled portion of a grid, give the direction of the wall it hit and change depending on that 
	public void collided(int direction) {
		
		//up
		if(direction == 1) {
			this.dy *= -1;
		}
		//down
		if(direction == 2) {
			this.dy *= -1;
		}
		//right
		if(direction == 3) {
			this.dx *= -1;
		}
		//left
		if(direction == 4) {
			this.dx *= -1;
		}
		
	}
	
	
	
	public void moveAndDraw(Graphics2D win) {
	
		//Once the enemy has spawned fill and translate
		if(enemy1) {
			
			win.setColor(Color.black);
			win.fill(this);
		
			this.translate((int)dx, (int)dy);
		}
		
		
	}
	
	
}
