
package graphicLayer.demos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.util.Random;

import graphicLayer.GBounded;
import graphicLayer.GElement;
import graphicLayer.GOval;
import graphicLayer.GSpace;

public class Example1 { 

	public static void main(String[] args) {
		Random x = new Random();
		GSpace w = new GSpace("Ecran qui rend fou", new Dimension(800, 600));
		GBounded gb = new GBounded();
		gb.setPosition(new Point(100,100));
		gb.setDimension(new Dimension(780, 580));
		gb.setColor(Color.gray);
		
		w.addElement(gb);
		
		int width = gb.getWidth();
		int height = gb.getHeight();
		for (int i = 0; i < 2000; i++) {
			int ox = x.nextInt(width);
			int oy = x.nextInt(height);
			GOval oval = new GOval();
			oval.setColor(new Color((int) (Math.random() * 0x1000000)));
			oval.setDimension(new Dimension(x.nextInt(30), x.nextInt(30)));
			oval.setPosition(new Point(ox, oy));
			gb.addElement(oval);
		}
		w.open();
		while (true) {
			gb.setPosition(new Point(x.nextInt(11), x.nextInt(11)));
			GElement [] elements = gb.getRawContents();
			for (int i = 0; i < elements.length; i++) {
				GBounded next = (GBounded) elements[i];
				next.translate(x.nextInt(11)-5, x.nextInt(11)-5);
			}
			w.repaint();
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
