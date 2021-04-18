package graphicLayer;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Stroke;

public class GLine extends GBasicElement {
	Point from;
	Point to;
	Stroke stroke;
	
	public GLine(Point from, Point to) {
		this.from = from;
		this.to = to;
		stroke = new BasicStroke();
	}
	
	public GLine(int fromX, int fromY, int toX, int toY) {
		this(new Point(fromX, fromY), new Point(toX, toY));
	}
	
	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		Stroke previousStroke = g2d.getStroke();
		Color previousColor = g2d.getColor();

		g2d.setStroke(stroke);
		g2d.setColor(color);
		g2d.drawLine(from.x, from.y, to.x, to.y);

		g2d.setColor(previousColor);
		g2d.setStroke(previousStroke);
	}

	public void setStroke(Stroke stroke) {
		this.stroke = stroke;
	}
	
	public void setWidth(float w) {
		setStroke(new BasicStroke(w));
	}

	public void translate(int x, int y) {
		from.translate(x, y);
		to.translate(x, y);
	}

}
