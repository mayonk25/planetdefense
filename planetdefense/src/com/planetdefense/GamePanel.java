package com.planetdefense;

import java.awt.*;
import java.util.*;


import javax.swing.*;

public class GamePanel extends JPanel implements Runnable{

	static final int GAME_WIDTH = 1280;
	static final int GAME_HEIGHT = 763;
	static final int PADDLE_WIDTH = 25;
	static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH,GAME_HEIGHT);
	
	// size dan perhitungan Health Point
	int BOMB_SIZE = 40;
	int SHIELD_H = 150;
	int HEALTHPOINT_W = 250;
	int HEALTHPOINT_H = 15;
	int HEALTHPOINT_MIN = 50; //pengurangan health point ketika bomb menabrak planet
	
	// gamestate
	public int gameState;
	public int skinState;
	public int playerWon;
	public int optionNum = 0;
	public final int homeState = 0;
	public final int gPlayState = 1;
	public final int pauseState = 2;
	public final int aboutState = 3;
	public final int tutorialState = 4;
	public final int gOverState = 5;

	Collision collision = new Collision(this);
	UserInterface ui = new UserInterface(this, GAME_WIDTH, GAME_HEIGHT);
	MusicPanel music = new MusicPanel();
	MusicPanel sfx = new MusicPanel();
	ImageLoader imgloader = new ImageLoader(this);
	Thread gameThread;
	Image image;
	Graphics graphics;
	Random random;
	Shield shieldp1;
	Shield shieldp2;
	Health HealthPointP1;
	Health HealthPointP2;
	Bomb bomb1;
	
	
	//assets
	Image homescreen;
	Image gameover;
	Image guidescreen;
	Image tutorialscreen;
	Image shield1;
	Image shield2;
	Image bomb;
	Image screenplay;
	Image homebutton;
	Image retrybutton;
	Image playbutton;
	Image aboutbutton;
	Image exitbutton;
	Image resumebutton;
	

	
	GamePanel(){
		newShield();
		newBomb();
		newScore();
		
		this.setFocusable(true);
		this.addKeyListener(new KeyPanel(this));
		this.setPreferredSize(SCREEN_SIZE);
		
		imgloader.loadImage();
		gameState = homeState;
		
		random = new Random();
		
		playSound(0);
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	public void newBomb() {
		random = new Random();
		bomb1 = new Bomb(this, (GAME_WIDTH/2)-(BOMB_SIZE/2),random.nextInt(GAME_HEIGHT-BOMB_SIZE),BOMB_SIZE,BOMB_SIZE);
	}
		
	public void newShield() {
		shieldp1 = new Shield(this, 150,(GAME_HEIGHT/2)-(SHIELD_H/2),PADDLE_WIDTH,SHIELD_H,1);
		shieldp2 = new Shield(this, GAME_WIDTH-PADDLE_WIDTH-150,(GAME_HEIGHT/2)-(SHIELD_H/2),PADDLE_WIDTH,SHIELD_H,2);
	}
	
	public void newScore() {
		HealthPointP1 = new Health(50, GAME_HEIGHT - 35, HEALTHPOINT_W, HEALTHPOINT_H, Color.white, 1, 0);
		HealthPointP2 = new Health(GAME_WIDTH-HEALTHPOINT_W-50, GAME_HEIGHT - 35, HEALTHPOINT_W, HEALTHPOINT_H, Color.white, 2, HEALTHPOINT_W-90);
	}
	
	public void paint(Graphics g) {		
			image = createImage(getWidth(),getHeight());
			
			graphics = image.getGraphics();
			draw(graphics);
			g.drawImage(image,0,0,this);
	}
	
	public void draw(Graphics g) {
		if(gameState == homeState) {
			ui.titleScreen(g);
		}
		else if(gameState == aboutState) {
			ui.guideScreen(g);
		}
		else if(gameState == tutorialState) {
			ui.tutorialScreen(g);
		}
		else if(gameState == pauseState) {
			ui.pauseScreen(g);
		}
		else if(gameState == gOverState) {
			ui.gOverScreen(g);
		}
		else {
			g.drawImage(screenplay, 0, 0, this);

			shieldp1.draw(g);
			shieldp2.draw(g);
			bomb1.draw(g);
						
			HealthPointP1.draw(g);
			HealthPointP2.draw(g);

			Toolkit.getDefaultToolkit().sync();
		}

	}
	
	public void move() {
		if(gameState == gPlayState) {
			shieldp1.move();
			shieldp2.move();
			bomb1.move();
		
		}
		else if(gameState == pauseState) {
			
		}
	}
	
	public void playSound(int i) {
		music.setFile(i);
		music.play();
		music.loop();
	}
	public void playSFX(int i) {
		sfx.setFile(i);
		sfx.play();
	}
	public void stopSound() {
		music.stop();
	}

	public void run() {
		//game loop
		long lastTime = System.nanoTime();
		double amountOfTicks = 600.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		while(true) {
			long now = System.nanoTime();
			delta += (now -lastTime)/ns;
			lastTime = now;
			if(delta >=1) {
				move();
				collision.checkCollision();
				repaint();
				delta--;
			}
		}
	}

}
