import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

public class snakeComp extends GameDriverV3 implements KeyListener {
	
	Rectangle grid[][] = new Rectangle[25][18];
	
	SoundDriver sounds;
	int gameState = 0;
	int x, y, timesEaten = 0;
	int touchedAnEdge = 0;
	int spriteH, spriteW, spriteCount = 0, framePos, spriteTimer = 0, spriteDelay = 2;
	BufferedImage firstback, thesnake, bomb;
	BufferedImage snakeSprite[];
	BufferedImage bombSprite[];
	NewGrid specialGrid;
	//Make it 780 by 600, 26 x 20
	Rectangle wall = new Rectangle(0, 539, 767, 1);
	Rectangle background = new Rectangle(0,0,780,600);
	Rectangle scoreboard = new Rectangle(0, 540, 767, 41);

	ArrayList<Rectangle> tempFilled = new ArrayList<Rectangle>();
	Piece hitThis, dontTouch;
	Piece food[];
	ActualSnake snake;
	PacMan pacman;
	Enemy ghost, ghost2, ghost3;
	Random r1= new Random();
	Font f1 = new Font("Terminal", Font.PLAIN, 20);
	Font f2 = new Font("Terminal", Font.BOLD, 20);
	Font f3 = new Font("Terminal", Font.PLAIN, 30);
	Font wORl = new Font("Constantia", Font.PLAIN, 40);
	Font titles = new Font("Snap ITC", Font.BOLD, 60);
	Color black = new Color (0,0,0);
	Color white = new Color (255,255,255);
	Color blue = new Color (20, 20, 255);
	
	public snakeComp() {
		
		String tsou[] = new String[2];
		this.addKeyListener(this);
		
		tsou[0] = "LoungeMusic.wav";
		tsou[1] = "EatingSound.wav";
		sounds = new SoundDriver(tsou);
		
		firstback = this.addImage("snake.jpg");
		thesnake = this.addImage("newsnakesprite_burned.png");
		bomb = this.addImage("explosionSprite.png");
		snakeSprite = new BufferedImage[24];	
		bombSprite = new BufferedImage[15];
	}
	
	
	private void addKeyListener(snakeComp snakeComp) {
		// TODO Auto-generated method stub
		
	}


	public void reset() {
		
		timesEaten = 0;
		x = (r1.nextInt(24) * 30) + 1;
		y = (r1.nextInt(17) * 30) + 1;
		
		snake = new ActualSnake(1,1, KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_RIGHT, KeyEvent.VK_LEFT);
		this.addKeyListener(snake);
		hitThis = new Piece(x, y);
		x = (r1.nextInt(24) * 30) + 1;
		y = (r1.nextInt(17) * 30) + 1;
		dontTouch = new Piece(x, y);
		if(hitThis.x == dontTouch.x && hitThis.y== dontTouch.y) {
			x = (r1.nextInt(24) * 30) + 1;
			y = (r1.nextInt(17) * 30) + 1;
			dontTouch = new Piece(x, y);
		}
		dontTouch.changeColor = true;
		for(int i = 0; i < 25; i++) {
			for(int j = 0; j < 18; j++) {
				grid[i][j] = new Rectangle(i*30, j*30, 30, 30);		
			}
		}
		
		
	}
	
	public void reset2() {
		
		timesEaten = 0;
		x = (r1.nextInt(24) * 30) + 1;
		y = (r1.nextInt(17) * 30) + 1;
		ghost2 = new Enemy(x, y, 15);
		x = (r1.nextInt(24) * 30) + 1;
		y = (r1.nextInt(17) * 30) + 1;
		ghost3 = new Enemy(x, y, 15);
		x = (r1.nextInt(24) * 30) + 1;
		y = (r1.nextInt(17) * 30) + 1;
		food = new Piece[30];
		
		for(int i = 0; i < food.length; i++ ) {
			x = (r1.nextInt(24) * 30) + 1;
			y = (r1.nextInt(17) * 30) + 1;
			food[i] = new Piece(x, y);
			
		}
		
		
		snake = new ActualSnake(1,1, KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_RIGHT, KeyEvent.VK_LEFT);
		this.addKeyListener(snake);
		for(int i = 0; i < 25; i++) {
			for(int j = 0; j < 18; j++) {
				grid[i][j] = new Rectangle(i*30, j*30, 30, 30);		
			}
		}
		
		
	}
	
	public void specialReset() {
		
		Random r1 = new Random();
		int randx = r1.nextInt(740);
		int randy = r1.nextInt(550);
		
		ghost = new Enemy(randx, randy, 15);
		pacman = new PacMan(1,1, KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_RIGHT, KeyEvent.VK_LEFT);
		this.addKeyListener(pacman);
		specialGrid = new NewGrid(35, 29);
		
	
	}
		
	public void draw(Graphics2D win) {
		
		if(gameState == 0) {
			
			while(!sounds.isPlaying(0)) {
			sounds.loop(0);
			}
			
			win.setColor(black);
			win.fill(background);
			
			//Snake Images 
			win.drawImage(firstback, null, 0, 0);
			win.setColor(white);
			RoundRectangle2D r2 = new RoundRectangle2D.Double(520, 530, 80, 40, 15, 15);
			RoundRectangle2D tilde = new RoundRectangle2D.Double(80, 530, 40, 40, 15, 15);
			win.draw(r2);
			win.draw(tilde);
			
			win.setFont(f1);
			win.drawString("Press", 532, 520); 	//r2
			win.drawString("Press", 75, 520);
			win.drawString("to begin", 615, 560);  //r2
			win.drawString("for instructions", 130, 560);
			win.setFont(f2);
			win.drawString("ENTER", 527, 558);
			win.drawString("1", 95 , 558);
			win.setFont(titles);
			win.drawString("S", 20, 140);
			win.drawString("N", 20, 210);
			win.drawString("A", 20, 280);
			win.drawString("K", 20, 350);
			win.drawString("E", 20, 420);
			
		}
		
		if(gameState == 1) {

			win.setColor(white);
			win.fill(background);
			win.fill(scoreboard);
			win.setColor(black); 
			win.drawString("Size: " + snake.bodysize + " pieces added", 20, 565);
			win.drawString("Number of Good Pieces Eaten: " + timesEaten, 550, 565);
			
			//The grid is actually 25 * 18
			for(int i = 0; i < grid.length;i++) {
				for(int j = 0; j < grid[i].length;j++) {
					win.setColor(white);
					win.fill(grid[i][j]);
					win.setColor(Color.BLACK);
					win.draw(grid[i][j]);
				}
			}
			
			snake.moveAndDraw(win);
			hitThis.moveAndDraw(win);
			dontTouch.moveAndDraw(win);
			
			if(hitThis.x == dontTouch.x && hitThis.y== dontTouch.y) {
				x = (r1.nextInt(24) * 30) + 1;
				y = (r1.nextInt(17) * 30) + 1;
				dontTouch = new Piece(x, y);
			}
			
			
			if(snake.intersects(dontTouch)) {
				snake.removePieces();
				if(snake.gameOver) {
					gameState = 2;
				}
				x = (r1.nextInt(24) * 30) + 1;
				y = (r1.nextInt(18) * 30) + 1;
				dontTouch = new Piece(x,y);
				dontTouch.changeColor = true;
			}
			
			if(snake.intersects(hitThis)){
				sounds.play(1);
				timesEaten++;
				x = (r1.nextInt(24) * 30) + 1;
				y = (r1.nextInt(18) * 30) + 1;
				hitThis = new Piece(x, y);
				snake.addPieces();

			}
				//If the piece spawns on the body move it
				if(snake.body.size() > 0) {
				
					for(int i = 0; i < snake.body.size(); i++) {
					if(hitThis.intersects(snake.body.get(i)) || snake.body.get(i).intersects(dontTouch)) {
						
						System.out.print("intersect");
						x = (r1.nextInt(24) * 30) + 1;
						y = (r1.nextInt(18) * 30) + 1;
						hitThis = new Piece(x, y);
					}
				}
				}
			
			
			//If the head hits the body
			for(int i = 0; i < snake.body.size() - 1; i++) {
				if(snake.intersects(snake.body.get(i + 1))) {
					gameState = 2;
				}
			}
			
			//If the snake goes out of bounds
			if(snake.x < 0) {
				gameState = 2;
			}
			if(snake.x > 737) {
				gameState = 2;
			}
			if(snake.y < 0) {
				gameState = 2;
			}
			if(snake.y > 520) {
				gameState = 2;
			}
			if(snake.bodysize >= 450) {
				gameState = 3;
			}
			
			
			
		}
		
		if(gameState == 2) {
			win.setColor(black);
			win.fill(background);
			win.setColor(white);
			win.setFont(wORl);
			win.drawString("You LOST!", 250, 200);
			win.setFont(f3);
			win.drawString("Enter or 2 to restart.", 100, 450);
			win.drawString("Backspace to return to home page.", 100, 500);
			
			spriteW = bomb.getWidth() / 5;
			spriteH = bomb.getHeight() / 3;
			
			for(int i = 0; i < 3; i++) {
				for(int j = 0; j < 5; j++) {
					
					if(spriteCount < 15) {
					bombSprite[spriteCount] = bomb.getSubimage(j * spriteW, i * spriteH , spriteW, spriteH);
					spriteCount++;
					}
				}
			}
			
				win.drawImage(bombSprite[framePos], null, 350, 285);
						
						if(spriteTimer > spriteDelay) {
							framePos++;
							framePos %= 15;
							spriteTimer = 0;
							
						}
						
						else {
							spriteTimer++;
						}
			
			
			
			
		}
		
	if(gameState == 3) {
		
		win.setColor(black);
		win.fill(background);
		win.setColor(white);
		win.setFont(wORl);
		win.drawString("You actually won!", 200, 200);
		win.setFont(f3);
		win.drawString("I never thought u would actually win whoops", 50, 500);
	
	}
	
	if(gameState == 4) {
		
		win.setColor(white);
		win.fill(background);
		
		win.fill(scoreboard);
		win.setColor(black);
		specialGrid.moveAndDraw(win);
		ghost.addAnEnemy();
		ghost.moveAndDraw(win);
		
		
		
		for(int i = 0; i < specialGrid.thegrid.length; i++) {
			
			for(int j = 0; j < specialGrid.thegrid[i].length; j++) {
				//If the head intersects any part of the grid
				if(pacman.intersects(specialGrid.thegrid[i][j])) {
					//If the grid is not filled in, fill it in
					if(specialGrid.filledInGrid[i][j] == false) {
						specialGrid.filledInGrid[i][j] = true;
						tempFilled.add(new Rectangle(specialGrid.thegrid[i][j].x,specialGrid.thegrid[i][j].y, 20,20));
					}
				}
					//If the grid is filled
					if(specialGrid.filledInGrid[i][j]) {
					
						//If the enemy intersects a wall- bounce 
						if(ghost.intersects(specialGrid.thegrid[i][j])) {
							
						if(j == 0) {
							ghost.dy *= -1;
						}
						if(j == specialGrid.thegrid[i].length - 1) {
							ghost.dy *= -1;
						}
						if(i == 0) {
							ghost.dx *= -1;
							}
						if(i == specialGrid.thegrid.length - 1) {
							ghost.dx *= -1;
						}
						
					}
				}
					
		//From the filled in part, 			
					//tempFilled is an arraylist that keeps track of where the head fills in/goes
					while(touchedAnEdge > 0) {
						
						//Rectangle bodyApprox = new Rectangle()
						
					}
				
				
			
			}
		}
		pacman.moveAndDraw(win);
		
	
		}
	
		if(gameState == 5) {
			
			win.setColor(black);
			win.fill(background);
			win.setColor(white);
			win.setFont(f3);
			win.drawString("Use UP, DOWN, RIGHT, LEFT to move the snake.", 50, 200);
			win.drawString("Try to eat the red food in order to get bigger", 50, 250);
			win.drawString("Avoid the black food, it will shrink you", 50, 300);
			win.drawString("Press 2 for another level, and shift for an unfinished", 25, 450);
			win.drawString("version that I wasted all my time on", 25, 500);
		}
		
		if(gameState == 6) {

			win.setColor(white);
			win.fill(background);
			win.fill(scoreboard);
			win.setColor(black); 
			win.drawString("Size: " + snake.bodysize + " pieces added", 20, 565);
			win.drawString("Number of Good Pieces Eaten: " + timesEaten, 550, 565);
			
			//The grid is actually 25 * 18
			for(int i = 0; i < grid.length;i++) {
				for(int j = 0; j < grid[i].length;j++) {
					win.setColor(white);
					win.fill(grid[i][j]);
					win.setColor(Color.BLACK);
					win.draw(grid[i][j]);
				}
			}
			
			win.fill(wall);
			snake.moveAndDraw(win);
			for(int i = 0; i < food.length; i++) {
				food[i].moveAndDraw(win);
			}
			ghost2.addAnEnemy();
			ghost2.moveAndDraw(win);
			
			ghost3.addAnEnemy();
			ghost3.moveAndDraw(win);
				
				//If the enemy intersects a wall- bounce 
			for(int i  = 0; i < grid.length; i++) {
				for(int j = 0; j < grid[i].length; j++) {
			
				if(ghost2.intersects(grid[i][j])) {	
					
				if(ghost2.x < 0) {
					ghost2.dx = 3;
				}
				if(ghost2.x > 738) {
					ghost2.dx = -3;
				}
				if(ghost2.y < 0) {
					ghost2.dy = 3;
				}
				if(ghost2.intersects(wall)) {
					ghost2.dy = -3;

				}
				
				}
				}
			}
			
			for(int i  = 0; i < grid.length; i++) {
				for(int j = 0; j < grid[i].length; j++) {
					if(ghost3.intersects(grid[i][j])) {
						if(ghost3.x < 0) {
							ghost3.dx = 3;
						}
						if(ghost3.x > 738) {
							ghost3.dx = -3;
						}
						if(ghost3.y < 0) {
							ghost3.dy = 3;
						}
						if(ghost3.intersects(wall)) {
							ghost3.dy = -3;

						}
					}
				}
			}
			
			if(ghost2.intersects(ghost3)) {
				int r = r1.nextInt(1);
				if(r == 0) {
					ghost3.dy = -3;
				}
				else {
					ghost3.dx = -3;
				}
				
			}
			
			for(int i = 0; i < food.length; i++) {
				
			
			if(snake.intersects(food[i])){
				sounds.play(1);
				timesEaten++;
				x = (r1.nextInt(24) * 30) + 1;
				y = (r1.nextInt(17) * 30) + 1;
				snake.addPieces();
				food[i].x = 800;
				food[i].y = 800;

			}
			}
				//If the piece spawns on the body move it
			
			if(snake.intersects(ghost2)) {
				gameState = 2;
			}
			
			if(timesEaten == 30) {
				gameState = 3;
			}
			//If the head hits the body
			for(int i = 0; i < snake.body.size() - 1; i++) {
				if(snake.intersects(snake.body.get(i + 1))) {
					gameState = 2;
				}
			}
			
			//If the snake goes out of bounds
			if(snake.x < 0) {
				gameState = 2;
			}
			if(snake.x > 737) {
				gameState = 2;
			}
			if(snake.y < 0) {
				gameState = 2;
			}
			if(snake.y > 520) {
				gameState = 2;
			}
			if(snake.bodysize >= 450) {
				gameState = 3;
			}
			
			
			
			
		}
		
		
	}
	
	
	
		
	


	public void keyPressed(KeyEvent e) {
		
		if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			gameState = 0;
		}
		if(e.getKeyCode() == KeyEvent.VK_1) {
			if(gameState == 0 || gameState == 2 || gameState == 3 || gameState == 5) {
			gameState = 5;
			}
		}
		
		if(e.getKeyCode() == KeyEvent.VK_2) {
			if(gameState == 0 || gameState == 2 || gameState == 3 || gameState == 5) {
			reset2();
			gameState = 6;
			}
		}
		
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			if(gameState == 0) {
				reset();
				gameState = 1;
			}
			if(gameState == 2) {
				reset();
				gameState = 1;
			}
			
			
		}
		if(e.getKeyCode() == KeyEvent.VK_4) {
			snake.bodysize = 449;
			if(gameState == 6) {
				timesEaten = 29;
			}
		}
		
		if(e.getKeyCode() == KeyEvent.VK_SHIFT) {
			if(gameState == 0) {
			specialReset();	
			gameState = 4;
		}
		}
		
		
	}


	
	public void keyReleased(KeyEvent arg0) {
		
	}

	public void keyTyped(KeyEvent arg0) {
		
	}
	
}