package graphicLayer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;

import javax.swing.UIManager;

public class GString extends GBounded {
	Font font;
	FontMetrics metrics;
	String str = "";
	
	public GString() { 
		this.font = this.defaultFont();
	}
	
	public Font defaultFont() {
		return (Font) UIManager.getDefaults().get("TextField.font");
	}
	
	public GString(String str) {
		this.str = str;
	}
	
	public Color defaultColor() {
		return Color.black;
	}
	
	private void ensureFont(Graphics2D g) {
		if (font == null) {
			font = g.getFont();
		}
		if (metrics == null) {
			metrics = g.getFontMetrics(font);
		}		
	}
	
	public void setFontSize(int size) {
		this.setFont(new Font(this.font.getFontName(), this.font.getStyle(), size));
	}
	
	@Override
	public void draw(Graphics2D g) {
		ensureFont(g);
		Font previousFont = g.getFont();
		Color previousColor = g.getColor();
		g.setColor(color);
		g.setFont(font);
		g.drawString(str, getX(), (int) getDimension().getHeight() + getY());
		g.setFont(previousFont);
		g.setColor(previousColor);
	}
	
	public void setString(String s) {
		str = s;
	}
	public void setFont(Font font) {
		this.font = font;
		this.metrics = null;
	}
	
	public Dimension getDimension() {
		int hgt = metrics.getAscent();
		int adv = metrics.stringWidth(str);
		return new Dimension(adv, hgt);
	}
}
