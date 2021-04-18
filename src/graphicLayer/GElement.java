package graphicLayer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public interface GElement {
	void paint(Graphics g);

	default void addMouseListener(MouseListener listener) {
		this.getContainer().addMouseListener(listener);
	}

	default Color defaultColor() {
		return Color.blue;
	}

	default void delete() {
		this.getContainer().removeElement(this);
	}

	void translate(int x, int y);

	GContainer getContainer();

	void setContainer(GContainer aContainer);

	void repaint() ;

	void setColor(Color c);

	default Shape getClippingShape() {
		return null;
	}

	default void dispatchMouseClicked(MouseEvent e) {
	}

	default void dispatchMousePressed(MouseEvent e) {
	}

	default void dispatchMouseReleased(MouseEvent e) {
	}

	default void dispatchMouseEntered(MouseEvent e) {
	}

	default void dispatchMouseExited(MouseEvent e) {
	}

}
