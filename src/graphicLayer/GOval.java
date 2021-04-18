package graphicLayer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Ellipse2D;

public class GOval extends GBounded implements Bordered {
	Color borderColor;
	Stroke stroke;
	boolean withBorder;
	
	public GOval() {
		withBorder = true;
		borderColor = this.defaultBorderColor();
		stroke = this.defaultStroke();
	}
	
	public Shape getClippingShape() {
		Ellipse2D ellipse = new Ellipse2D.Float();
		Rectangle bounds = this.getBounds();
		ellipse.setFrame(bounds.x,bounds.y,bounds.width,bounds.height);
		return ellipse;
	}

	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		Color previousColor = g2d.getColor();
		Stroke previousStroke = g2d.getStroke();

		Rectangle bounds = this.getBounds();
		g2d.setColor(color);
		g2d.fillOval(bounds.x,bounds.y,bounds.width,bounds.height);
		this.drawContents(g2d);
		if (this.withBorder) {
			g2d.setColor(this.borderColor);
			g2d.setStroke(this.stroke);
			g2d.drawOval(bounds.x, bounds.y, bounds.width, bounds.height);
		}
		
		g2d.setColor(previousColor);
		g2d.setStroke(previousStroke);
	}

	@Override
	public void setBorderColor(Color borderColor) {
		this.borderColor = borderColor;		
	}

	@Override
	public void setStroke(Stroke stroke) {
		this.stroke = stroke;
	}

	@Override
	public void setWithBorder(Boolean withBorder) {
		this.withBorder = withBorder;
	}
	
	@Override
	public Boolean containsPoint(Point p) {
		Rectangle bounds = this.getBounds();
		return new Ellipse2D.Double(bounds.x,bounds.y,bounds.width,bounds.height).contains(p);
	}

}
