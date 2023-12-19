package com.planetdefense;

import javax.swing.ImageIcon;

public class ImageLoader {

	GamePanel panel;
	
	public ImageLoader(GamePanel panel) {
		this.panel = panel;
	}
	
	public void loadImage() {
		ImageIcon homescreen = new ImageIcon("assets/img/1mainscreenrevisi.png");
		panel.homescreen = homescreen.getImage();
		ImageIcon about = new ImageIcon("assets/img/1aboutpanel.png");
		panel.guidescreen = about.getImage();
		ImageIcon gameover = new ImageIcon("assets/img/1gameoverrev.png");
		panel.gameover = gameover.getImage();
		ImageIcon home = new ImageIcon("assets/img/1homebutton.png");
		panel.homebutton = home.getImage();
		ImageIcon retry = new ImageIcon("assets/img/1retry.png");
		panel.retrybutton = retry.getImage();
		ImageIcon play = new ImageIcon("assets/img/1playbutton.png");
		panel.playbutton = play.getImage();
		ImageIcon abutton = new ImageIcon("assets/img/1aboutbutton.png");
		panel.aboutbutton = abutton.getImage();
		ImageIcon exit = new ImageIcon("assets/img/1exitbutton.png");
		panel.exitbutton = exit.getImage();
		ImageIcon resume = new ImageIcon("assets/img/1resume.png");
		panel.resumebutton = resume.getImage();
		ImageIcon shield1 = new ImageIcon("assets/img/shield1.png");
		panel.shield1 = shield1.getImage();
		ImageIcon shield2 = new ImageIcon("assets/img/shield2.png");
		panel.shield2 = shield2.getImage();
		ImageIcon bomb = new ImageIcon("assets/img/1mine.png");
		panel.bomb = bomb.getImage();
		ImageIcon screenplay = new ImageIcon("assets/img/1bgImage1.png");
		panel.screenplay = screenplay.getImage();
		ImageIcon guide = new ImageIcon("assets/img/1miniguidescreen.png");
		panel.themescreen = guide.getImage();
		
	}
}
