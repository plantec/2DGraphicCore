package graphicLayer;

import java.awt.Color;
import java.awt.Point;

import javax.swing.JTextField;

public class GTextField extends JTextField implements GElement {
	private static final long serialVersionUID = 8660613563211256595L;

	protected GContainer container;
	protected Color color = defaultColor();
	protected Point position;
	
	public GTextField(String string, int i) {
		super (string, i);
	}

	@Override
	public void translate(int x, int y) {
		Point p = this.getPosition();
		this.setPosition(new Point(p.x+x, p.y+y));
	}

	public void setPosition(Point point) {
		this.position = point;
	}

	public Point getPosition() {
		return this.position;
	}

	@Override
	public GContainer getContainer() {
		return this.container;
	}

	@Override
	public void setContainer(GContainer aContainer) {
		this.container = aContainer;
	}

	@Override
	public void setColor(Color c) {
		this.color = c;
	}

}
