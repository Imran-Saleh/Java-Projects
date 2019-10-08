package breakout;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class breakoutComp extends GameDriverV3 implements KeyListener {
	
	
	int gameState = 0;
	int score = 0, lives, hlives;
	standardBrick[] s1 = new standardBrick[100];
	movingBrick m1[] = new movingBrick[100];
	ball b1;
	Paddle human;
	Effect explosion;
	boolean containP[] = new boolean[100];
	powerUp p1[] = new powerUp[100];
	boolean redpower = false;
	Rectangle background = new Rectangle(0, 0, 1100, 600);
	Rectangle deadzone = new Rectangle(0, 525, 1100, 38);
	Rectangle topzone = new Rectangle(0, 0, 1100, 2);
	Rectangle bottomzone = new Rectangle(0, 400, 1100, 1);
	Rectangle c1 = new Rectangle(100, 100, 30, 30);
	Rectangle c2 = new Rectangle(100, 300, 30, 30);
	Rectangle c3 = new Rectangle(100, 500, 30, 30);
	Rectangle c4 = new Rectangle(400, 100, 30, 30);
	Rectangle c5 = new Rectangle(400, 300, 30, 30);
	Rectangle c6 = new Rectangle(400, 500, 30, 30);
	Rectangle c7= new Rectangle(700, 100, 30, 30);
	
	
public breakoutComp() {
	this.addKeyListener(this);
}
	
public void resetatD() {
	
	human = new Paddle(450, 510, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT);
	b1 = new ball(495, 450, 15);
	 redpower = false;
	this.addKeyListener(human);
	hlives = lives;
}



public void reset() {
	
	human = new Paddle(450, 510, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT);
	b1 = new ball(495, 450, 15);
	this.addKeyListener(human);
	 redpower = false;
	Random r1 = new Random();
	
	lives = 3;
	hlives = 3;
	score = 0;
	
	for(int i = 0; i < 10; i++) {
		
		for(int j = 0; j < 10; j++) {
			
			int randspawn = r1.nextInt(100);
			int typeofP = r1.nextInt(7);
			int numBrick = j + i*10;
			
			if(randspawn <= 25) {
				containP[numBrick] = true;
				p1[numBrick] = new powerUp(j*109, i*26);
				p1[numBrick].typeOfPowerup(typeofP);
			}
			else {
				p1[numBrick] = new powerUp(3000, i*26);
				containP[numBrick] = false;
			}
			
			
			s1[numBrick] = new standardBrick(j*109, i*26);
			s1[numBrick].bricklivesLVL1(numBrick);
	
		}
		
	}
	
}

//Random Generated Levels

public void reset2() {
	 redpower = false;
	human = new Paddle(450, 510, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT);
	b1 = new ball(495, 450, 15);
	this.addKeyListener(human);

	Random r1 = new Random();
	
	lives = 3;
	hlives = 3;
	score = 0;
	
	for(int i = 0; i < 10; i++) {
		
		for(int j = 0; j < 10; j++) {
			
			int randspawn = r1.nextInt(100);
			int spawnBrick = r1.nextInt(100);
			int typeofP = r1.nextInt(7);
			int numBrick = j + i*10;
			
			if(spawnBrick >= 0 && spawnBrick < 15) {
				s1[numBrick] = new standardBrick(3000, i*26);
				s1[numBrick].bricklivesLVL3(numBrick);
			}
			if(spawnBrick >= 15 && spawnBrick < 30) {
				s1[numBrick] = new standardBrick(j*109, i*26);
				s1[numBrick].bricklivesLVL3(30);
			}
			if(spawnBrick >=30 && spawnBrick <= 55) {
				s1[numBrick] = new standardBrick(j*109, i*26);
				s1[numBrick].bricklivesLVL3(3);
			}
			
			if(spawnBrick >= 55) {
				s1[numBrick] = new standardBrick(j*109, i*26);
				s1[numBrick].bricklivesLVL3(50);
			}
			
			if(randspawn <= 25) {
				containP[numBrick] = true;
				p1[numBrick] = new powerUp(j*109, i*26);
				p1[numBrick].typeOfPowerup(typeofP);
			}
			else {
				p1[numBrick] = new powerUp(3000, i*26);
				containP[numBrick] = false;
			}
			
	
		}
		
	}
	
}

public void reset3() {
	 redpower = false;
	human = new Paddle(450, 510, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT);
	b1 = new ball(495, 450, 15);
	this.addKeyListener(human);

	Random r1 = new Random();
	
	lives = 3;
	hlives = 3;
	score = 0;
	
	for(int i = 0; i < 10; i++) {
		
		for(int j = 0; j < 10; j++) {
			
			int randspawn = r1.nextInt(100);
			int typeofP = r1.nextInt(7);
			int numBrick = j + i*10;
			
			if(randspawn <= 100) {
				containP[numBrick] = true;
				p1[numBrick] = new powerUp(j*109, i*26);
				p1[numBrick].typeOfPowerup(typeofP);
			}
			else {
				p1[numBrick] = new powerUp(3000, i*26);
				containP[numBrick] = false;
			}
			
			
			m1[numBrick] = new movingBrick(j*109 + 1, i*30 + 1);
			m1[numBrick].bricklivesLVL1(numBrick);
	
		}
		
	}	
	
	
}




public void keyPressed(KeyEvent e) {
	
	if(e.getKeyCode() == KeyEvent.VK_4) {
		gameState = 10;
		
	}
	
	
	if(e.getKeyCode() == KeyEvent.VK_2) {
		
		if(gameState == 0) {
			reset3();
			gameState = 3;
		}	
	}
	
	if(e.getKeyCode() == KeyEvent.VK_3) {
		reset2();
		gameState = 5;
	}
	
	if(e.getKeyCode() == KeyEvent.VK_ENTER) {
		if(gameState == 0) {
			reset();
			gameState = 1;
		}
		if(gameState == 4) {
			gameState = 0;
		}
		
	}
	
	if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
		gameState = 0;
	}
	
}


public void keyReleased(KeyEvent arg0) {
	
	
}


public void keyTyped(KeyEvent arg0) {
	
}

public int collisionDirection(Rectangle pad1, ball b12, int dx, int dy) {
	
	int previousXPos = (int)b12.getX() - dx;
	int previousYPos = (int)b12.getY() - dy;
	int height = (int)b12.getHeight();
	int width = (int)b12.getWidth();
	int result = 0;
	
	if(previousYPos + height <= pad1.getY() && b12.getY() + height >= pad1.getY()) {
		result = 1;
	} else if (previousXPos + width <= pad1.getX() && b12.getX() + width >= pad1.getX()) {
		result = 2;
	} else if (previousYPos >= pad1.getY() + pad1.height && b12.getY() <= pad1.getY() + pad1.height) {
		result = 3;
	}
	
	return result;
	
}




public void draw(Graphics2D win) {
	
	if(gameState == 0) {
		win.setColor(Color.BLACK);
		win.fill(background);
		
		win.setColor(Color.RED);
		win.setFont(new Font("Britannic Bold", Font.BOLD, 60));
		win.drawString("Breakout: Lost Comp Class Edition", 40,70);
		win.setColor(Color.WHITE);
		win.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		win.drawString("Instructions: Left and Right arrow keys to move paddle. Hit ball on bricks.", 60, 250);
		win.drawString("Catch powerups with paddle. Press 4 to see PowerUps. Random generated levels press 3.", 60, 280);
		win.drawString("Backspace to go back to this screen. Pink bricks have 1 life, red 2, dark red 3.", 60, 310);
		win.drawString("I was too lazy to make it look nice. Give me a break. I did lose my entire game basically.", 200, 400);
		win.setFont(new Font("Britannic Bold", Font.BOLD, 40));
		win.drawString("Press enter to start the main game", 250, 500);
		
		
		
	}
	
	
	if(gameState == 1) {
		
		win.setColor(Color.BLACK);
		win.fill(background);
		
		win.setColor(Color.GRAY);
		win.fill(deadzone);
		
		win.setColor(Color.WHITE);
		win.drawString("Lives:" + lives, 800, 550);
		win.drawString("Score:" + score, 200, 550);
		
		
		
		if(lives == 0) {
			gameState = 4;
		}
		
		
		human.moveAndDraw(win);
		b1.moveAndDraw(win);
		
		for(int i = 0; i < 100; i++) {
			
			s1[i].moveAndDraw(win);
			p1[i].moveAndDraw(win);
			
			
			if(b1.intersects(s1[i])) {
				
				hlives = lives;
				if(!s1[i].isDestroyed){
					s1[i].hit();
					score++;
					if(!redpower) {
					standardBrick br1 = s1[i];
					if(b1.intersects(br1)) {
						int direction = this.collisionDirection(br1, b1, (int)b1.dx, (int)b1.dy);
						// direction 0 or 2 is side hit
						if(direction == 0 || direction == 2) {
							b1.dx = -b1.dx;
						} 
						else {
					b1.dy = -b1.dy;
						}
					}
					}
					
					if(s1[i].isDestroyed){
						if(containP[i]) {
						p1[i].collided();
						p1[i].fall();
						}
					}
					
				}	
		
			
		
				
			}

		if(human.intersects(p1[i])) {
			if(p1[i].cc1) {
				redpower = true;	
			}
			
			if(p1[i].cc2) {
				if(hlives == lives) {
					lives++;
				}
				
			}
			
			if(p1[i].cc3) {
				b1.makeSlower();
			}
			
			if(p1[i].cc4) {
				human.makeBigger();
			}
			
			if(p1[i].cc5) {
				human.makeSmaller();
			}
			
			if(p1[i].cc6) {
				b1.makeFaster();
			}
			
			if(p1[i].cc7) {
				human.fasterMove();
			}
			
			
			}		
		}
		if(b1.intersects(human)) {
			
			b1.dy=-b1.dy;
			
		}	
		
		if(score == 150) {
			gameState = 2;
		}
		
		if(b1.intersects(deadzone)) {
			resetatD();
			lives--;
		}
		
	}
	
	if(gameState == 2) {
		//After level 1 winner screen
		win.setColor(Color.BLACK);
		win.fill(background);
		win.setColor(Color.WHITE);
		win.drawString("You beat level 1, beat the next one.", 400, 300);
		
	}
	
	if(gameState == 3) {
		//The second level with moving bricks
		win.setColor(Color.BLACK);
		win.fill(background);
		
		win.setColor(Color.GRAY);
		win.fill(deadzone);
		
		win.setColor(Color.WHITE);
		win.drawString("Lives:" + lives, 800, 500);
		win.drawString("Score:" + score, 200, 550);
		win.fill(bottomzone);
		
		
		
		if(lives == 0) {
			gameState = 4;
		}
		
		
		human.moveAndDraw(win);
		b1.moveAndDraw(win);
		
		for(int i = 0; i < 100; i++) {
			
			m1[i].moveAndDraw(win);
			p1[i].moveAndDraw(win);
			
			if(score > 25) {
				m1[i].lastsection();
			}
			
			if(m1[i].intersects(topzone)) {
				m1[i].dy *= -1;
			}
			
			if(m1[i].intersects(bottomzone)) {
				m1[i].y = m1[i].y - 120;; 
				m1[i].dy *= -1;
				}
			
			
			
			
			
			if(b1.intersects(m1[i])) {
				
				hlives = lives;

				if(!m1[i].isDestroyed){
					m1[i].hit();
					score++;
					if(!redpower) {
					movingBrick br1 = m1[i];
					if(b1.intersects(br1)) {
						int direction = this.collisionDirection(br1, b1, (int)b1.dx, (int)b1.dy);
						// direction 0 or 2 is side hit
						if(direction == 0 || direction == 2) {
							b1.dx = -b1.dx;
						} 
						else {
					b1.dy = -b1.dy;
						}
					}
					}
					
					if(m1[i].isDestroyed){
						if(containP[i]) {
						p1[i].collided();
						p1[i].fall();
						}
					}
					
				}	
				
			}

		if(human.intersects(p1[i])) {
			if(p1[i].cc1) {
				redpower = true;	
			}
			
			if(p1[i].cc2) {
				if(hlives == lives) {
					lives++;
				}
				
			}
			
			if(p1[i].cc3) {
				b1.makeSlower();
			}
			
			if(p1[i].cc4) {
				human.makeBigger();
			}
			
			if(p1[i].cc5) {
				human.makeSmaller();
			}
			
			if(p1[i].cc6) {
				b1.makeFaster();
			}
			
			if(p1[i].cc7) {
				human.fasterMove();
			}
			
			
			}		
		}
		if(b1.intersects(human)) {
			
			b1.dy=-b1.dy;
			
		}	
		
		if(score == 150) {
			gameState = 6;
		}
		
		if(b1.intersects(deadzone)) {
			resetatD();
			lives--;
		}
		
		
		
		
		
	}
	
	if(gameState == 4) {
		win.setColor(Color.BLACK);
		win.fill(background);
		
		win.setFont(new Font("Britannic Bold", Font.BOLD, 40));
		win.setColor(Color.WHITE);
		win.drawString("Ur bad u lost try again", 300, 300);
	}
	
	if(gameState == 5) {
		
		win.setColor(Color.BLACK);
		win.fill(background);
		
		win.setColor(Color.GRAY);
		win.fill(deadzone);
		
		win.setColor(Color.WHITE);
		win.drawString("Lives:" + lives, 800, 550);
		win.drawString("Score:" + score, 200, 550);
		
		
		
		if(lives == 0) {
			gameState = 4;
		}
		human.moveAndDraw(win);
		b1.moveAndDraw(win);
		
		for(int i = 0; i < 100; i++) {
			
			s1[i].moveAndDraw(win);
			p1[i].moveAndDraw(win);
			
			
			if(b1.intersects(s1[i])) {
				
				hlives = lives;
				if(!s1[i].isDestroyed){
					s1[i].hit();
					score++;
					if(!redpower) {
					standardBrick br1 = s1[i];
					if(b1.intersects(br1)) {
						int direction = this.collisionDirection(br1, b1, (int)b1.dx, (int)b1.dy);
						// direction 0 or 2 is side hit
						if(direction == 0 || direction == 2) {
							b1.dx = -b1.dx;
						} 
						else {
					b1.dy = -b1.dy;
						}
					}
					}
					
					if(s1[i].isDestroyed){
						if(containP[i]) {
						p1[i].collided();
						p1[i].fall();
						}
					}
					
				}	
		
			
		
				
			}

		if(human.intersects(p1[i])) {
			if(p1[i].cc1) {
				redpower = true;	
			}
			
			if(p1[i].cc2) {
				if(hlives == lives) {
					lives++;
				}
				
			}
			
			if(p1[i].cc3) {
				b1.makeSlower();
			}
			
			if(p1[i].cc4) {
				human.makeBigger();
			}
			
			if(p1[i].cc5) {
				human.makeSmaller();
			}
			
			if(p1[i].cc6) {
				b1.makeFaster();
			}
			
			if(p1[i].cc7) {
				human.fasterMove();
			}
			
			
			}		
		}
		if(b1.intersects(human)) {
			
			b1.dy=-b1.dy;
			
		}	
	
		
		if(b1.intersects(deadzone)) {
			resetatD();
			lives--;
		}
		
	}
	
	if(gameState == 6) {
		win.setColor(Color.BLACK);
		win.fill(background);
		
		win.setColor(Color.WHITE);
		win.drawString("Go to the random generated levels u win.", 300, 200);
}
	
	if(gameState == 10) {
		win.setColor(Color.BLACK);
		win.fill(background);
		
		win.setColor(new Color(255, 0, 0)); //Red. Melt thru bricks
		win.fill(c1);
		
		win.setColor(new Color(255, 255, 255));
		win.fill(c2); //White. Life Up
	
		win.setColor(new Color(0, 255, 0));
		win.fill(c3);//Green. Slower ball.
		
		win.setColor(new Color(0,0,255));
		win.fill(c4);//Blue. Bigger paddle
		win.setColor(new Color(255,0,255));
		win.fill(c5);//Purple. Smaller Paddle.
		win.setColor(new Color(100,100,100));
		win.fill(c6);//Gray. Faster ball.
		win.setColor(new Color(255,255,50));
		win.fill(c7);//Yellow. Faster paddle.
		
		win.setColor(Color.WHITE);
		win.drawString("This allows the ball to melt through the bricks.", 140, 120);
		win.drawString("This gives you one extra life", 140, 320);
		win.drawString("Slows the ball slightly", 140, 520);
		win.drawString("Paddle grows", 440, 120);
		win.drawString("Paddle shrinks", 440, 320);
		win.drawString("Speed of ball increases slightly", 440, 520);
		win.drawString("Paddle speed increase", 740, 120);
		
		
		
	}
	
	
	

}

}