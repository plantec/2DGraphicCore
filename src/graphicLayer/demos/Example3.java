
package graphicLayer.demos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import graphicLayer.GLine;
import graphicLayer.GOval;
import graphicLayer.GPolyLine;
import graphicLayer.GRect;
import graphicLayer.GSpace;
import graphicLayer.GString;

public class Example3 implements MouseListener {

	public Example3() {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}

	public void createAndShowGUI ( ) {
		GSpace w = new GSpace("Zoo", new Dimension(400, 400));
		GRect container = new GRect();
		container.withoutBorder();
		container.setColor(Color.white);
		container.setPosition(new Point(30,30));
		container.setDimension(new Dimension(300,300));
		w.addElement(container);
		
		GOval cercle = new GOval();
		cercle.setPosition(new Point(30,50));
		cercle.setDimension(new Dimension(60,60));
		cercle.setColor(Color.yellow);
		container.addElement(cercle);
		
		GOval subContainer = new GOval();
		subContainer.setColor(Color.red);
		subContainer.setPosition(new Point(50,20));
		subContainer.setDimension(new Dimension(250,250));
		container.addElement(subContainer);

		subContainer.addMouseListener(this);
		
		GString s = new GString();
		s.setPosition(new Point(10,0));
		s.setString("Click here inside this circle");
		s.setFontSize(18);
		s.setColor(Color.white);
		s.translate(0, subContainer.getCenter().y);
		subContainer.addElement(s);
		
		
		GLine line = new GLine(new Point(10,30), new Point(150,30));
		line.setColor(Color.black);
		line.setWidth(3);
		subContainer.addElement(line);
		
		GPolyLine pline = new GPolyLine();
		pline.setWidth(8);
		pline.addPoint(new Point(5,140));
		pline.addPoint(new Point(50,180));
		pline.addPoint(new Point(70,130));
		pline.addPoint(new Point(95,180));
		pline.addPoint(new Point(150,130));
		pline.addPoint(new Point(170,180));
		pline.translate(0, 100);
		container.addElement(pline);
		
		w.open();
	}
		
	public void mouseClicked(MouseEvent e) {
		System.out.println("Click " + e);
		((GOval)e.getSource()).setColor(new Color((int) (Math.random() * 0x1000000)));
		e.consume();
	}

	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	
	public void mouseEntered(MouseEvent e) {
		System.out.println("Entered " + e);
		e.consume();
	}
	
	public void mouseExited(MouseEvent e) {
		System.out.println("Exited " + e);
		e.consume();
	}
	
	public static void main(String[] args) {
		new Example3();
	}

}
