package graphicLayer.demos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.SwingUtilities;

import graphicLayer.GBounded;
import graphicLayer.GSpace;
import graphicLayer.GTextField;

public class Example5 {
	public static void main(String[] args) {
		GSpace w = new GSpace("TextField", new Dimension(800, 600));
		GBounded gb = new GBounded();
		gb.setPosition(new Point(100, 100));
		gb.setDimension(new Dimension(200, 100));
		gb.setColor(Color.gray);
		w.addElement(gb);
		GTextField tf = new GTextField("Hello", 30);
		tf.setToolTipText("Please enter some text here");
		tf.setSize(100, 30);
		gb.addElement(tf);
		w.open();
		SwingUtilities.invokeLater(new Runnable() {
		    @Override
		    public void run() {
		        tf.requestFocusInWindow();
		    }
		});
	}
}
