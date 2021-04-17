package graphicLayer;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;

public abstract class GElement  {
	protected GContainer container;
	protected Color color = defaultColor();
	Runnable repainter = new Runnable() {
        @Override
        public void run() {
        	container.repaint();
        	Toolkit.getDefaultToolkit().sync();
        }
    };

	abstract public void draw(Graphics2D g);	
		
	public GElement() { }
	
	public Color defaultColor() {
		return Color.blue;
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
	
	public void dispatchMouseClicked(MouseEvent e) {}
	public void dispatchMousePressed(MouseEvent e) {}
	public void dispatchMouseReleased(MouseEvent e) {}
	public void dispatchMouseEntered(MouseEvent e) {}
	public void dispatchMouseExited(MouseEvent e) {}	

}
