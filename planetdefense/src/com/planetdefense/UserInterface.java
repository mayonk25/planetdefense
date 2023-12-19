package com.planetdefense;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

public class UserInterface {
    GamePanel panel;
	int gWidth, gHeight;
	int y;
	
	public UserInterface(GamePanel panel, int gWidth, int gHeight) {
		this.panel = panel;
		this.gWidth = gWidth;
		this.gHeight = gHeight;
	}
	
	public void titleScreen(Graphics g) {
        
		g.drawImage(panel.homescreen, 0, 0, panel);

		g.drawImage(panel.playbutton, (gWidth / 2) - (160 / 2)- 200, 400, 160, 90, panel);
		g.drawImage(panel.aboutbutton, (gWidth / 2) - (160 / 2), 400, 160, 90, panel);
		g.drawImage(panel.exitbutton, (gWidth / 2) - (160 / 2) + 200, 400, 160, 90, panel);
		
        String score = "Use W/LArrow or D/RArrow";
        Font sfont = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr2 = g.getFontMetrics(sfont);

        g.setFont(sfont);
        g.setColor(Color.GRAY);
        g.drawString(score, ((gWidth - metr2.stringWidth(score)) / 2) + 2, gHeight - 29);
        g.setColor(Color.WHITE);        
        g.drawString(score, (gWidth - metr2.stringWidth(score)) / 2, gHeight - 30);
        
        // draw selection
        g.setColor(Color.magenta);
        if(panel.optionNum == 0) {
        	g.drawRoundRect(((gWidth / 2) - (160 / 2)) - 200 - 2, 400, 164, 89, 20, 20);
        }
        else if(panel.optionNum == 1) {
        	g.drawRoundRect(((gWidth / 2) - (160 / 2)) - 2 , 400, 164, 89, 20, 20);
        }
        else if(panel.optionNum == 2) {
        	g.drawRoundRect(((gWidth / 2) - (160 / 2)) + 200 - 2, 400, 164, 89, 20, 20);
        }
        
    }
	
	public void guideScreen(Graphics g) {
		g.drawImage(panel.guidescreen, 0, 0, gWidth, gHeight, panel);
	}

	public void alterScreen(Graphics g) {
        
		g.drawImage(panel.themescreen, 0, 0, panel);

        String score = "Press 'Enter' to select!";
        Font sfont = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr2 = g.getFontMetrics(sfont);

        g.setFont(sfont);
        g.setColor(Color.GRAY);
        g.drawString(score, ((gWidth - metr2.stringWidth(score)) / 2) + 2, gHeight - 29);
        g.setColor(Color.WHITE);        
        g.drawString(score, (gWidth - metr2.stringWidth(score)) / 2, gHeight - 30);
        
        // draw selection
        g.setColor(Color.WHITE);
        if(panel.optionNum == 0) {
        	g.drawRoundRect(48, 258, 372, 228, 20, 20);
        }
        else if(panel.optionNum == 1) {
        	g.drawRoundRect(449, 258, 372, 228, 20, 20);
        }
        else if(panel.optionNum == 2) {
        	g.drawRoundRect(850, 258, 372, 228, 20, 20);
        }
        
    }
	
	public void pauseScreen(Graphics g) {
		
		g.setColor(new Color(0, 0, 0, 10));
		g.fillRect(0, 0, gWidth, gHeight);
		
        String msg = "Paused";
        Font mfont = new Font("Eras Demi ITC", Font.BOLD, 55);
        FontMetrics metr1 = g.getFontMetrics(mfont);

        g.setFont(mfont);
        g.setColor(Color.GRAY);
        g.drawString(msg, ((gWidth - metr1.stringWidth(msg)) / 2) + 3, 155);
        g.setColor(Color.WHITE);        
        g.drawString(msg, (gWidth - metr1.stringWidth(msg)) / 2, 153);

        g.drawImage(panel.resumebutton, (gWidth / 2) - (190 / 2), 325, 190, 90, panel);
		g.drawImage(panel.retrybutton, (gWidth / 2) - (158 / 2), 415, 158, 90, panel);
		g.drawImage(panel.homebutton, (gWidth / 2) - (158 / 2), 505, 158, 90, panel);
		
        String score = "Press 'Enter' to select!";
        Font sfont = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr2 = g.getFontMetrics(sfont);

        g.setFont(sfont);
        g.setColor(Color.GRAY);
        g.drawString(score, ((gWidth - metr2.stringWidth(score)) / 2) + 2, gHeight - 29);
        g.setColor(Color.WHITE);        
        g.drawString(score, (gWidth - metr2.stringWidth(score)) / 2, gHeight - 30);
        
        // draw selection
        g.setColor(Color.magenta);
        if(panel.optionNum == 0) {
        	g.drawRoundRect(((gWidth / 2) - (190 / 2)) - 3, 327, 194, 87, 20, 20);
        }
        else if(panel.optionNum == 1) {
        	g.drawRoundRect(((gWidth / 2) - (158 / 2)) - 3, 417, 162, 87, 20, 20);
        }
        else if(panel.optionNum == 2) {
        	g.drawRoundRect(((gWidth / 2) - (158 / 2)) - 3, 507, 162, 87, 20, 20);
        }
        
    }
	
	public void gOverScreen(Graphics g) {
		
		g.drawImage(panel.gameover, 0, 0, panel);
		
		String msg = "Player " + panel.playerWon + " Won!";
        Font mfont = new Font("Consolas", Font.PLAIN, 25);
        FontMetrics metr1 = g.getFontMetrics(mfont);

        g.setFont(mfont);
        g.setColor(Color.GRAY);
        g.drawString(msg, ((gWidth - metr1.stringWidth(msg)) / 2) + 2, 342);
        g.setColor(Color.WHITE);        
        g.drawString(msg, (gWidth - metr1.stringWidth(msg)) / 2, 340);

        String score = "Press 'Enter' to select!";
        Font sfont = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr2 = g.getFontMetrics(sfont);

        g.setFont(sfont);
        g.setColor(Color.GRAY);
        g.drawString(score, ((gWidth - metr2.stringWidth(score)) / 2) + 2, gHeight - 29);
        g.setColor(Color.WHITE);        
        g.drawString(score, (gWidth - metr2.stringWidth(score)) / 2, gHeight - 30);
        
        // draw option
        g.drawImage(panel.retrybutton, (gWidth / 2) - (158 / 2), 425, 158, 90, panel);
		g.drawImage(panel.homebutton, (gWidth / 2) - (158 / 2), 530, 158, 90, panel);
        
        // draw selection
        g.setColor(Color.magenta);
        if(panel.optionNum == 0) {
        	g.drawRoundRect(((gWidth / 2) - (158 / 2)) - 3, 427, 162, 87, 20, 20);
        }
        else if(panel.optionNum == 1) {
        	g.drawRoundRect(((gWidth / 2) - (158 / 2)) - 3, 532, 162, 87, 20, 20);
        }
        
    }

}
