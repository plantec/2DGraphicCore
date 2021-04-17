package graphicLayer;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
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

	public void draw(Graphics2D g) {
		Color previousColor = g.getColor();
		Stroke previousStroke = g.getStroke();

		Rectangle bounds = this.getBounds();
		g.setColor(color);
		g.fillOval(bounds.x,bounds.y,bounds.width,bounds.height);
		this.drawContents(g);
		if (this.withBorder) {
			g.setColor(this.borderColor);
			g.setStroke(this.stroke);
			g.drawOval(bounds.x, bounds.y, bounds.width, bounds.height);
		}
		
		g.setColor(previousColor);
		g.setStroke(previousStroke);
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
