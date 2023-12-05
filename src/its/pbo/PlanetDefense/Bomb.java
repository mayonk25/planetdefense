package its.pbo.PlanetDefense;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Bomb extends Rectangle{
	Random random;
	int xSpeed;
	int ySpeed;
	
	int initialSpeed = 2;
	
	Bomb(int x, int y, int width, int height){
		super(x,y,width,height);
		random = new Random();
		
		int randomXDirection = random.nextInt(2);
		if (randomXDirection == 0)
			randomXDirection -= 1;
		setXDirection(randomXDirection * initialSpeed);
		
		int randomYDirection = random.nextInt(2);
		if (randomYDirection == 0)
			randomYDirection -= 1;
		setYDirection(randomYDirection * initialSpeed);
	}
	
	public void setXDirection(int randomXDirection) {
		xSpeed = randomXDirection;
	}
	
	public void setYDirection(int randomYDirection) {
		ySpeed = randomYDirection;
	}
	
	public void move() {
		x += xSpeed;
		y += ySpeed;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.pink);
		g.fillOval(x, y, height, width);
	}
}
