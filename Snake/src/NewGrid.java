import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class NewGrid extends Rectangle {

	
	
	Color blue = new Color (20, 20, 255);
	Rectangle thegrid[][];
	boolean filledInGrid[][];
	int rowNum, columnNum;
	
	public NewGrid(int row, int column) {
		
		
		
		rowNum = row;
		columnNum = column;
		thegrid = new Rectangle[row][column];	
		filledInGrid = new boolean[row][column];
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < column; j++) {
				
				thegrid[i][j] = new Rectangle(i*20, j*20, 20, 20);	
				
				filledInGrid[i][j] = false;
				if(j == 0) {
					filledInGrid[i][j] = true;
				}
				if(i == 0) {
					filledInGrid[i][j] = true;
				}
				if(i == rowNum - 1) {
					filledInGrid[i][j] = true;
				}
				if(j == columnNum - 1) {
					filledInGrid[i][j] = true;
				}
				
				
				
				
				
				}
		}
		
	}
	
	
	public void moveAndDraw(Graphics2D win) {
		
		
		for(int i = 0; i < thegrid.length;i++) {
			for(int j = 0; j < thegrid[i].length;j++) {
			
				
				if(filledInGrid[i][j]) {
					win.setColor(blue);
					win.fill(thegrid[i][j]);
				}
				else {
					win.setColor(Color.white);
					win.fill(thegrid[i][j]);
				}
				win.setColor(Color.BLACK);
				win.draw(thegrid[i][j]);
			}
			
		}
		
		win.draw(this);
		
		
	}
	
	
	
	
	
	
}
