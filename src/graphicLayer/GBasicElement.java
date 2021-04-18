package graphicLayer;

import java.awt.Color;
import java.awt.Toolkit;

public abstract class GBasicElement implements GElement {
	protected GContainer container;
	protected Color color = defaultColor();
	
	public GContainer getContainer() {
		return container;
	}
	
	public void setContainer(GContainer aContainer) {
		container = aContainer;
	}
		
	public void setColor (Color c) {
		color = c;
	}
	
	public void repaint() {
		GContainer container = this.getContainer();
		if (container == null)
			return;
		container.repaint();
		Toolkit.getDefaultToolkit().sync();
	}

}
