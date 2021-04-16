
package graphicLayer.demos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;

import graphicLayer.GBounded;
import graphicLayer.GRect;
import graphicLayer.GSpace;
import graphicLayer.GString;

public class Example2  {

	public Example2() {
		GString label;
		GSpace space = new GSpace("Un essai", new Dimension(500, 400));
		
		GRect container = new GRect();
		container.setColor(Color.white);
		container.setDimension(new Dimension(400,300));
		container.translate(new Point(50, 50));
		label = new GString("container " + container.getWidth() + "x" + container.getHeight() );
		label.setColor(Color.red);
		label.setFont(new Font("Arial", Font.BOLD, 20));
		container.addElement(label);
		container.withoutBorder();
		space.addElement(container);
		
		GRect subContainer = new GRect();
		subContainer.setColor(Color.black);
		subContainer.setPosition(new Point(30,50));
		subContainer.setDimension(new Dimension(300,200));
		subContainer.setBorderColor(Color.red);
		subContainer.setBorderWidth(4);
		label = new GString("subContainer " + subContainer.getWidth() + "x" + subContainer.getHeight() );
		label.setColor(Color.white);
		label.setFont(new Font("Arial", Font.BOLD, 18));
		subContainer.addElement(label);
		container.addElement(subContainer);
		
		GRect subsubContainer = new GRect();
		subsubContainer.setColor(Color.white);
		subsubContainer.setPosition(new Point(50,50));
		subsubContainer.setDimension(new Dimension(230,120));
		label = new GString("subsubContainer " + subsubContainer.getWidth() + "x" + subsubContainer.getHeight() );
		label.setFont(new Font("Arial", Font.BOLD, 16));
		label.setColor(Color.blue);
		subsubContainer.addElement(label);
		subsubContainer.withoutBorder();
		subContainer.addElement(subsubContainer);
		
		space.open();
		
		label = new GString("space " + space.getWidth() + "x" + space.getHeight() );
		label.setFont(new Font("Arial", Font.BOLD, 24));
		label.setColor(Color.darkGray);
		space.addElement(label);

	}

	
	public static void main(String[] args) {
		new Example2();
	}

}
