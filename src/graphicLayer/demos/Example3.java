
package graphicLayer.demos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Timer;

import graphicLayer.GContainer;
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
		GSpace w = new GSpace("Zoo", new Dimension(500, 400));
		GRect container = new GRect();
		container.withoutBorder();
		container.setColor(Color.white);
		container.setPosition(new Point(30,30));
		container.setDimension(new Dimension(400,300));
		w.addElement(container);
		
		GOval cercle = new GOval();
		cercle.setPosition(new Point(30,50));
		cercle.setDimension(new Dimension(60,60));
		cercle.setColor(Color.yellow);
		container.addElement(cercle);
		
		GOval subContainer = new GOval();
		subContainer.setColor(Color.red);
		subContainer.setPosition(new Point(50,20));
		subContainer.setDimension(new Dimension(270,270));
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
	
	class AddedOvalMouseListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			GOval src = (GOval) e.getSource();
			ActionListener taskPerformer = new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent a) {
					GContainer container = src.getContainer();
					src.delete();
					container.repaint();
				}
			};
			e.consume();
			Timer action = new Timer(0, taskPerformer);
			action.setRepeats(false);
			action.start();
		}

		@Override
		public void mousePressed(MouseEvent e) {
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}
		
	}
		
	public void mouseClicked(MouseEvent e) {
		GOval src = (GOval) e.getSource();
		GOval clickArea = new GOval();
		clickArea.setDimension(new Dimension(20,20));
		clickArea.setCenter(e.getPoint());
		clickArea.setColor(Color.white);
		src.addElement(clickArea);
		clickArea.addMouseListener(new AddedOvalMouseListener());
		src.repaint();
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
