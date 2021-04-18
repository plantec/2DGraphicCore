package graphicLayer;

import java.awt.Color;
import java.awt.Graphics;
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
		
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		Rectangle bounds = this.getBounds();
		Color previousColor = g2d.getColor();
		Stroke previousStroke = g2d.getStroke();
		
		g2d.setColor(color);
		g2d.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
		if (withBorder) {
			g2d.setColor(borderColor);
			g2d.setStroke(stroke);
			g2d.drawRect(bounds.x, bounds.y, bounds.width, bounds.height);
		}
		
		g2d.setColor(previousColor);
		g2d.setStroke(previousStroke);
		
		drawContents(g);
	}

	@Override
	public void setWithBorder(Boolean withBorder) {
		this.withBorder = withBorder;
	}

	
}
