package its.pbo.PlanetDefense;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Planet extends Rectangle{
	int id;
	int health;
	Planet(int x, int y, int radius, int id){
		super(x,y,radius,radius);
		this.id = id;
		this.health = 100;
	}
	
	public void draw(Graphics g) {
		if (id == 1)
			g.setColor(Color.blue);
		else
			g.setColor(Color.red);
		g.fillOval(x, y, height, width);
	}
}
