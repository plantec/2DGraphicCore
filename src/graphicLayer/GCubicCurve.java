package graphicLayer;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.geom.CubicCurve2D;
import java.awt.geom.Point2D;

public class GCubicCurve extends GBasicElement {
	CubicCurve2D curve = new CubicCurve2D.Double();
	Stroke stroke;
	
	public GCubicCurve(Point from, Point ctrl1, Point ctrl2, Point to) {
		curve.setCurve(from.x, from.y, ctrl1.x, ctrl1.y, ctrl2.x, ctrl2.y, to.x, to.y);
		stroke = new BasicStroke();
	}
	
	public void translate(int x, int y) {
		Point2D from = curve.getP1();
		Point2D to = curve.getP2();
		Point2D ctrl1 = curve.getCtrlP1();
		Point2D ctrl2 = curve.getCtrlP1();
		from.setLocation(from.getX()+ x, from.getY()+y);
		to.setLocation(to.getX()+ x, to.getY()+ y);
		ctrl1.setLocation(ctrl1.getX()+ x, ctrl1.getY()+ y);
		ctrl2.setLocation(ctrl2.getX()+ x, ctrl2.getY()+ y);
	}
	
	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		Stroke previousStroke = g2d.getStroke();
		Color previousColor = g2d.getColor();

		g2d.setStroke(stroke);
		g2d.setColor(color);
		g2d.draw(curve);

		g2d.setColor(previousColor);
		g2d.setStroke(previousStroke);
	}
	
	public void setStroke(Stroke stroke) {
		this.stroke = stroke;
	}
	
	public void setWidth(float w) {
		setStroke(new BasicStroke(w));
	}

}
