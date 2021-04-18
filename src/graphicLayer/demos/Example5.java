package graphicLayer.demos;

import java.awt.Dimension;

import graphicLayer.GSpace;
import graphicLayer.GTextField;

public class Example5 {
	public static void main(String[] args) {
		GSpace w = new GSpace("TextField", new Dimension(800, 600));
		GTextField tf = new GTextField("Hello", 30);
		w.addElement(tf);
		w.open();
	}
}
