package com.planetdefense;

import java.util.Random;

public class Collision {
	GamePanel panel;
	Random random;
	
	public Collision(GamePanel panel) {
		this.panel = panel;
	}
	@SuppressWarnings("static-access")
	public void checkCollision() {
		
		//bounce bomb1 off top & bottom window edges
		if(panel.bomb1.y <=0) {
			panel.bomb1.setYDirection(-panel.bomb1.yVelocity);
			panel.playSFX(2);
		}
		if(panel.bomb1.y >= panel.GAME_HEIGHT-panel.BOMB_SIZE) {
			panel.bomb1.setYDirection(-panel.bomb1.yVelocity);
			panel.playSFX(2);
		}
		
		
		//bounce bomb1 off paddles
		if(panel.bomb1.intersects(panel.shieldp1)) {
			panel.playSFX(2);
			panel.bomb1.xVelocity = Math.abs(panel.bomb1.xVelocity);
			panel.bomb1.xVelocity++; //optional for more difficulty
//			if(panel.bomb1.yVelocity>0)
//				panel.bomb1.yVelocity++; //optional for more difficulty
//			else
//				panel.bomb1.yVelocity--;
			panel.bomb1.setXDirection(panel.bomb1.xVelocity);
			panel.bomb1.setYDirection(panel.bomb1.yVelocity);
		}
		if(panel.bomb1.intersects(panel.shieldp2)) {
			panel.playSFX(2);
			panel.bomb1.xVelocity = Math.abs(panel.bomb1.xVelocity);
			panel.bomb1.xVelocity++; //optional for more difficulty
//			if(panel.bomb1.yVelocity>0)
//				panel.bomb1.yVelocity++; //optional for more difficulty
//			else
//				panel.bomb1.yVelocity--;
			panel.bomb1.setXDirection(-panel.bomb1.xVelocity);
			panel.bomb1.setYDirection(panel.bomb1.yVelocity);
		}
		//stops paddles at window edges
		if(panel.shieldp1.y<=0)
			panel.shieldp1.y=0;
		if(panel.shieldp1.y >= (panel.GAME_HEIGHT-panel.shieldp1.height))
			panel.shieldp1.y = panel.GAME_HEIGHT-panel.shieldp1.height;
		if(panel.shieldp2.y<=0)
			panel.shieldp2.y=0;
		if(panel.shieldp2.y >= (panel.GAME_HEIGHT-panel.shieldp2.height))
			panel.shieldp2.y = panel.GAME_HEIGHT-panel.shieldp2.height;
		//give a player 1 point and creates new paddles & bomb1
		if(panel.bomb1.x <=60) {
			panel.playSFX(3);

			panel.HealthPointP1.barWidth-=panel.HEALTHPOINT_MIN;
			panel.newShield();
			
			panel.BOMB_SIZE=40;
			panel.bomb1.setSize(panel.BOMB_SIZE, panel.BOMB_SIZE);
			
			panel.newBomb();
			//panel.newPowerUp();
			

			
			// game over state
			if(panel.HealthPointP1.barWidth == 0) {
				panel.gameState = panel.gOverState;
				panel.playerWon = 2;
			}
			
//			System.out.println("Player 2: "+panel.score.player2);
		}
		if(panel.bomb1.x >= panel.GAME_WIDTH-panel.BOMB_SIZE-60) {
			panel.playSFX(3);
//			panel.score.player1++;
			panel.HealthPointP2.barWidth-=panel.HEALTHPOINT_MIN;
			panel.HealthPointP2.xfill+=panel.HEALTHPOINT_MIN;
			
			panel.newShield();
			
			panel.BOMB_SIZE=40;
			panel.bomb1.setSize(panel.BOMB_SIZE, panel.BOMB_SIZE);
			
			panel.newBomb();


			
			// game over state
			if(panel.HealthPointP2.barWidth == 0) {
				panel.gameState = panel.gOverState;
				panel.playerWon = 1;
			}
			
//			System.out.println("Player 1: "+panel.score.player1);
		}
		
		
		
	}
}
