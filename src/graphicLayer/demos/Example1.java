
package graphicLayer.demos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.Timer;

import graphicLayer.GBounded;
import graphicLayer.GElement;
import graphicLayer.GOval;
import graphicLayer.GSpace;

public class Example1 {

	public static void main(String[] args) {
		int population = 5000;
		Random x = new Random();
		GSpace w = new GSpace("Ecran qui rend fou", new Dimension(800, 600));
		GBounded gb = new GBounded();
		gb.setPosition(new Point(100, 100));
		gb.setDimension(new Dimension(780, 580));
		gb.setColor(Color.gray);

		w.addElement(gb);

		int width = gb.getWidth();
		int height = gb.getHeight();
		for (int i = 0; i < population; i++) {
			int ox = x.nextInt(width);
			int oy = x.nextInt(height);
			GOval oval = new GOval();
			oval.setColor(new Color((int) (Math.random() * 0x1000000)));
			oval.setDimension(new Dimension(x.nextInt(30), x.nextInt(30)));
			oval.setPosition(new Point(ox, oy));
			gb.addElement(oval);
		}
		w.open();
		int delay = 50; // milliseconds
		ActionListener taskPerformer = new ActionListener() {
			List<GElement> removed = new ArrayList<GElement>();

			public void actionPerformed(ActionEvent evt) {
				gb.setPosition(new Point(x.nextInt(11), x.nextInt(11)));
				GElement[] elements = gb.getRawContents();
				for (int i = 0; i < elements.length; i++) {
					GBounded next = (GBounded) elements[i];
					next.translate(x.nextInt(11) - 5, x.nextInt(11) - 5);
					if (x.nextInt(10) == 0) {
						removed.add(next);
					}
				}
				if (gb.getSubElements().isEmpty()) {
					gb.addAllElements(removed);
					removed.clear();
				}
				else
					for (GElement e : removed)
						gb.removeElement(e);

				gb.repaint();
			}
		};
		Timer animation = new Timer(0, taskPerformer);
		animation.setDelay(delay);
		animation.start();

	}

}
