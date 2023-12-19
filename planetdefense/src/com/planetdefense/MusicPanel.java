package com.planetdefense;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class MusicPanel {
	Clip clip;
	URL musicURL[] = new URL[6];
	
	public MusicPanel() {
		
		musicURL[0] = getClass().getResource("/music/mainmusic.wav");
		musicURL[1] = getClass().getResource("/music/clickbutton.wav");
		musicURL[2] = getClass().getResource("/music/collision.wav");
		musicURL[3] = getClass().getResource("/music/crash.wav");
		musicURL[4] = getClass().getResource("/music/powerupsound.wav");
		musicURL[5] = getClass().getResource("/music/switchsound.wav");
	}
	
	public void setFile(int i) {
	
		try {
			
			AudioInputStream ais = AudioSystem.getAudioInputStream(musicURL[i]);
			clip = AudioSystem.getClip();
			clip.open(ais);
			
		}catch(Exception e) {
			
		}
	}
	
	public void play() {
		clip.start();
	}
	
	public void loop() {
		
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
	
	public void stop() {
		
		clip.stop();
	}
}
