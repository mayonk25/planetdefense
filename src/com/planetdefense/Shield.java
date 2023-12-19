package com.planetdefense;

import java.awt.*;
import java.awt.event.*;

public class Shield extends Rectangle{

	GamePanel panel;
	int id;
	int yVelocity;
	int speed = 10;
	
	Shield(GamePanel panel, int x, int y, int PADDLE_WIDTH, int PADDLE_HEIGHT, int id){
		super(x,y,PADDLE_WIDTH,PADDLE_HEIGHT);
		this.panel = panel;
		this.id=id;
	}
	
	public void keyPressed(KeyEvent e) {
		switch(id) {
		case 1 : 
			if (e.getKeyCode() == KeyEvent.VK_W) {
				setYDirection(-speed);
				//System.out.println("w pressed");
			}
			if (e.getKeyCode() == KeyEvent.VK_S) {
				setYDirection(speed);
				//System.out.println("s pressed");
			}
			break;
		case 2 : 
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				setYDirection(-speed);
				//System.out.println("up pressed");
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				setYDirection(speed);
				//System.out.println("down pressed");
			}
			break;
		}
	}
	
	public void keyReleased(KeyEvent e) {
		switch(id) {
		case 1 : 
			if (e.getKeyCode() == KeyEvent.VK_W) {
				// hacky way to fix freezing on counter strafe
				if (yVelocity != speed) 
				// NOTE : gave another bug but gameplay much smoother imo
				setYDirection(0);
				//move();
			}
			if (e.getKeyCode() == KeyEvent.VK_S) {
				if (yVelocity != -speed)
				setYDirection(0);
				//move();
			}
			break;
		case 2 : 
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				if (yVelocity != speed) 
				setYDirection(0);
				//move();
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				if (yVelocity != -speed) 
				setYDirection(0);
				//move();
			}
			break;
		}
	}
	
	public void setYDirection(int yDirection) {
		yVelocity = yDirection;
	}
	public void move() {
		y= y + yVelocity;
	}
	public void draw(Graphics g) {
		
		if(id==1) {
			if(panel.skinState == 0) {
				g.drawImage(panel.shield1, x, y, width, height, panel);
			}
//			else if(panel.skinState == 1) {
//				g.drawImage(panel.paddle1s2, x, y, width, height, panel);
//			}
//			else if(panel.skinState == 2) {
//				g.drawImage(panel.paddle1s3, x, y, width, height, panel);
//			}
		}
		else
			if(panel.skinState == 0) {
			g.drawImage(panel.shield2, x, y, width, height, panel);
		}
//		else if(panel.skinState == 1) {
//			g.drawImage(panel.paddle2s2, x, y, width, height, panel);
//		}
//		else if(panel.skinState == 2) {
//			g.drawImage(panel.paddle2s3, x, y, width, height, panel);
//		}
	}
}
