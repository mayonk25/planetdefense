package its.pbo.PlanetDefense;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class GamePanel extends JPanel implements Runnable{
	
	static final int GAME_WIDTH = 1280;
	static final int GAME_HEIGHT = 763;
	static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH,GAME_HEIGHT);
	int BOMB_SIZE = 40;
	int SHIELD_WIDTH = 25;
	int SHIELD_HEIGHT = 200;
	int PLANET_SIZE = 2000; // 2000 - 1000 - 925 = 75px
	// offset shield agar muat planet
	int OFFSET = 175;
	int baseDamage = 10;
	double dmgMultiplier = 0.1 ;
	int damage;
	int runGame = 1;
	
	Thread gameThread;
	Image image;
	Graphics graphics;
	Shield shield1;
	Shield shield2;
	Score score;
	Bomb bomb;
	Planet planet1;
	Planet planet2;
	Random random;
	
	GamePanel(){
		createShields();
		createBall();
		createPlanets();
		score = new Score(GAME_WIDTH, GAME_HEIGHT, planet1, planet2);
		this.setFocusable(true);
		this.addKeyListener(new ActionListener());
		this.setPreferredSize(SCREEN_SIZE);
		
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	public void createBall() {
		random = new Random();
		bomb = new Bomb((GAME_WIDTH/2)-(BOMB_SIZE/2),random.nextInt(GAME_HEIGHT-BOMB_SIZE),BOMB_SIZE,BOMB_SIZE);
	}
	
	public void createShields() {
		shield1 = new Shield(OFFSET, (GAME_HEIGHT/2)-(SHIELD_HEIGHT/2),SHIELD_WIDTH , SHIELD_HEIGHT, 1,"image/paddle1.png");
		shield2 = new Shield(GAME_WIDTH-SHIELD_WIDTH-OFFSET, (GAME_HEIGHT/2)-(SHIELD_HEIGHT/2),SHIELD_WIDTH , SHIELD_HEIGHT, 2,"image/paddle2.png");
	}
	
	public void createPlanets() {
		planet1 = new Planet(-PLANET_SIZE/2-925,(GAME_HEIGHT/2)-(PLANET_SIZE/2),PLANET_SIZE,1);
		planet2 = new Planet(GAME_WIDTH-PLANET_SIZE/2+925,(GAME_HEIGHT/2)-(PLANET_SIZE/2),PLANET_SIZE,2);
	}
	
	public void paint(Graphics g) {
		image = createImage(getWidth(),getHeight());
		graphics = image.getGraphics();
		draw(graphics);
		g.drawImage(image, 0, 0, this);
	}
	
	public void draw(Graphics g) {
		shield1.draw(g);
		shield2.draw(g);
		bomb.draw(g);
		planet1.draw(g);
		planet2.draw(g);
		score.draw(g);
	}
	
	public void move() {
		shield1.move();
		shield2.move();
		bomb.move();
	}
	
	public void checkCollision() {
		// membatasi shield agar tidak keluar border
		if (shield1.y <= 0) shield1.y = 0;
		if (shield1.y >= GAME_HEIGHT - SHIELD_HEIGHT) shield1.y = GAME_HEIGHT - SHIELD_HEIGHT;
		
		if (shield2.y <= 0) shield2.y = 0;
		if (shield2.y >= GAME_HEIGHT - SHIELD_HEIGHT) shield2.y = GAME_HEIGHT - SHIELD_HEIGHT;
		
		// memantulkan bola saat menyentuh border
		if (bomb.y <= 0) {
			bomb.setYDirection(-bomb.ySpeed);
		}
		if (bomb.y >= GAME_HEIGHT - BOMB_SIZE) {
			bomb.setYDirection(-bomb.ySpeed);
		}
		
		// memantulkan bola saat menyentuh shield
		if (bomb.intersects(shield1)) {
			bomb.xSpeed = -bomb.xSpeed;
			if (bomb.xSpeed > 0) bomb.xSpeed++;
			else bomb.xSpeed--;
			if (bomb.ySpeed > 0) bomb.ySpeed++;
			else bomb.ySpeed--;
			bomb.setXDirection(bomb.xSpeed);
			bomb.setYDirection(bomb.ySpeed);
		}
		
		if (bomb.intersects(shield2)) {
			bomb.xSpeed = -bomb.xSpeed;
			if (bomb.xSpeed > 0) bomb.xSpeed++;
			else bomb.xSpeed--;
			if (bomb.ySpeed > 0) bomb.ySpeed++;
			else bomb.ySpeed--;
			bomb.setXDirection(bomb.xSpeed);
			bomb.setYDirection(bomb.ySpeed);
		}
		
		// collision bola dgn planet
		
		if (bomb.intersects(planet1)) {
			score.player2 += 1;
		    damage = (int)(baseDamage * (double)(1 + dmgMultiplier *(double)(Math.abs(bomb.xSpeed)-bomb.initialSpeed)));
			planet1.health -= damage;
			System.out.println("Player 2 Scores!\nhit damage : " + damage + "\nhit speed: " + Math.abs(bomb.xSpeed));
			checkHealth();
		}
		if (bomb.intersects(planet2)) {
			score.player1 += 1;
			damage = (int)(baseDamage * (double)(1 + dmgMultiplier *(double)(Math.abs(bomb.xSpeed)-bomb.initialSpeed)));
			planet2.health -= damage;
			System.out.println("Player 1 Scores!\nhit damage : " + damage + "\nhit speed: " + Math.abs(bomb.xSpeed));
			checkHealth();
		}
	}
	
	public void checkHealth() {
		if (planet1.health > 0 && planet2.health > 0)
			restartStage();
		else {
			freezeGame();
			// TODO : ADD game over screen
			score.showEndGameScore();
		}
	}
	
	public void restartStage() {
		createShields();
		createBall();
		createShields();
		createBall();
	}
	
	public void run() {
		// game loop
		long lastTime = System.nanoTime();
		double amountOfTicks = 60;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;

		while (runGame == 1) {
			long now = System.nanoTime();
			delta += (now-lastTime)/ns;
			lastTime = now;
			if (delta >= 1) {
				move();
				checkCollision();
				repaint();
				delta--;
			}
		}
	}
	
	public void freezeGame() {
		runGame = 0;
		
	}
	
	public class ActionListener extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			shield1.keyPressed(e);
			shield2.keyPressed(e);
		}
		public void keyReleased(KeyEvent e) {
			shield1.keyReleased(e);
			shield2.keyReleased(e);
		}
	}
}

