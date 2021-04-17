package graphicLayer;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Stroke;

public class GRect extends GBounded implements Bordered {
	Color borderColor;
	Stroke stroke;
	boolean withBorder;
		
	public GRect() {
		withBorder = true;
		borderColor = defaultBorderColor();
		stroke = defaultStroke();
	}
		
	@Override
	public void setBorderColor(Color borderColor) {
		this.borderColor = borderColor;
	}
	
	@Override
	public void setStroke(Stroke stroke) {
		this.stroke = stroke;
	}
		
	public void draw(Graphics2D g) {
		Rectangle bounds = this.getBounds();
		Color previousColor = g.getColor();
		Stroke previousStroke = g.getStroke();
		
		g.setColor(color);
		g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
		if (withBorder) {
			g.setColor(borderColor);
			g.setStroke(stroke);
			g.drawRect(bounds.x, bounds.y, bounds.width, bounds.height);
		}
		
		g.setColor(previousColor);
		g.setStroke(previousStroke);
		
		drawContents(g);
	}

	@Override
	public void setWithBorder(Boolean withBorder) {
		this.withBorder = withBorder;
	}

	
}
