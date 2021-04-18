package graphicLayer;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public abstract class GElement  {
	protected GContainer container;
	protected Color color = defaultColor();

	abstract public void draw(Graphics2D g);
	
	public void addMouseListener(MouseListener listener) {
		this.getContainer().addMouseListener(listener);
	}
		
	public GElement() { }
	
	public Color defaultColor() {
		return Color.blue;
	}
	
	public void delete() {
		this.getContainer().removeElement(this);
	}
	
	abstract public void translate(int x, int y);

	public GContainer getContainer() {
		return container;
	}
	
	public void setContainer(GContainer aContainer) {
		container = aContainer;
	}
		
	public void repaint () {
		if (container == null) return;
	    container.repaint();
	    Toolkit.getDefaultToolkit().sync();
	}

	public void setColor (Color c) {
		color = c;
	}
	
	public Shape getClippingShape() {
		return null;
	}
	
	public void dispatchMouseClicked(MouseEvent e) {}
	public void dispatchMousePressed(MouseEvent e) {}
	public void dispatchMouseReleased(MouseEvent e) {}
	public void dispatchMouseEntered(MouseEvent e) {}
	public void dispatchMouseExited(MouseEvent e) {}	

}
