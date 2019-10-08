import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Piece extends Rectangle {
	boolean changeColor = false;
	
	
	
	public Piece(int x, int y) {
		super(x, y, 29, 29);
	
		
	}
	
	public void moveAndDraw(Graphics2D win) {
		if(changeColor) {
			win.setColor(Color.BLACK);
		}
		else {
		win.setColor(Color.RED);
		}
		win.fill(this);
		
		
	}
	
	
	
	
}





