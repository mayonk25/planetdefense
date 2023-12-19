package com.planetdefense;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class KeyPanel extends KeyAdapter {

	GamePanel panel;
	Random random;
	
	public KeyPanel(GamePanel panel) {
		this.panel = panel;
	}
	
	public void keyPressed(KeyEvent e) {
		
		if(panel.gameState == panel.homeState) {
			if(e.getKeyCode()==KeyEvent.VK_D || e.getKeyCode()==KeyEvent.VK_RIGHT) {
				panel.playSFX(5);
				panel.optionNum++;
				panel.repaint();
				if(panel.optionNum > 2) panel.optionNum = 0;
			}
			if(e.getKeyCode()==KeyEvent.VK_A || e.getKeyCode()==KeyEvent.VK_LEFT) {
				panel.playSFX(5);
				panel.optionNum--;
				panel.repaint();
				if(panel.optionNum < 0) panel.optionNum = 2;
			}
			if(e.getKeyChar() == '\n') {
				panel.playSFX(1);
				if(panel.optionNum == 0) {
					panel.gameState = panel.tutorialState;
					panel.repaint();
				}
				if(panel.optionNum == 1) {
					panel.gameState = panel.aboutState;
					panel.repaint();
				}
				if(panel.optionNum == 2) {
					System.exit(0);
				}
			}
		}
		
		// SKIN KEY
		else if(panel.gameState == panel.tutorialState) {

			if(e.getKeyChar() == '\n') {
				panel.playSFX(1);
				panel.gameState = panel.gPlayState;
			}
		}
		
		else if(panel.gameState == panel.aboutState) {
			if(e.getKeyChar() == KeyEvent.VK_ESCAPE) {
				panel.gameState = panel.homeState;
				panel.repaint();
			}
		}
		
		else if(panel.gameState == panel.gPlayState) {
			if(e.getKeyChar() == KeyEvent.VK_ESCAPE) {
				panel.gameState = panel.pauseState;
				panel.repaint();
			}
			panel.shieldp1.keyPressed(e);
			panel.shieldp2.keyPressed(e);
		}
		
		else if(panel.gameState == panel.pauseState) {
			if(e.getKeyCode()==KeyEvent.VK_S || e.getKeyCode()==KeyEvent.VK_DOWN) {
				panel.playSFX(5);
				panel.optionNum++;
				panel.repaint();
				if(panel.optionNum > 2) panel.optionNum = 0;
			}
			if(e.getKeyCode()==KeyEvent.VK_W || e.getKeyCode()==KeyEvent.VK_UP) {
				panel.playSFX(5);
				panel.optionNum--;
				panel.repaint();
				if(panel.optionNum < 0) panel.optionNum = 2;
			}
			if(e.getKeyChar() == '\n') {
				panel.playSFX(1);
				if(panel.optionNum == 0) {
					panel.gameState = panel.gPlayState;
					panel.repaint();
				}
				if(panel.optionNum == 1) {
					panel.gameState = panel.gPlayState;
					panel.BOMB_SIZE=40;
					panel.newBomb();
					panel.newShield();
					panel.newScore();
					
					random = new Random();
					
					panel.repaint();
				}
				if(panel.optionNum == 2) {
					panel.gameState = panel.homeState;
					panel.BOMB_SIZE=40;
					panel.newBomb();
					panel.newShield();
					panel.newScore();
					
					random = new Random();
					
					panel.repaint();
				}
			}
		}
		
		else if(panel.gameState == panel.gOverState) {
			if(e.getKeyCode()==KeyEvent.VK_S || e.getKeyCode()==KeyEvent.VK_DOWN) {
				panel.playSFX(5);
				panel.optionNum++;
				panel.repaint();
				if(panel.optionNum > 1) panel.optionNum = 0;
			}
			if(e.getKeyCode()==KeyEvent.VK_W || e.getKeyCode()==KeyEvent.VK_UP) {
				panel.playSFX(5);
				panel.optionNum--;
				panel.repaint();
				if(panel.optionNum < 0) panel.optionNum = 1;
			}
			if(e.getKeyChar() == '\n') {
				panel.playSFX(1);
				if(panel.optionNum == 0) {
					panel.gameState = panel.gPlayState;
					panel.BOMB_SIZE=40;
					panel.newBomb();
					panel.newShield();
					panel.newScore();
					
					panel.repaint();
				}
				if(panel.optionNum == 1) {
					panel.gameState = panel.homeState;
					panel.BOMB_SIZE=40;
					panel.newBomb();
					panel.newShield();
					panel.newScore();
					
					panel.repaint();
				}

			}
		}
		
	}
	
	public void keyReleased(KeyEvent e) {
		panel.shieldp1.keyReleased(e);
		panel.shieldp2.keyReleased(e);
	}
}
