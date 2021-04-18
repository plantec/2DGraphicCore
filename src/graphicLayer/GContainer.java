package graphicLayer;
import java.awt.Point;
import java.awt.event.MouseListener;

public interface GContainer {
	Point getGlobalPosition();
	GElement[] getRawContents();
	Boolean containsPoint(Point p);
	void addElement(GElement m);
	void removeElement(GElement gElement);
	void clear();
	void addMouseListener(MouseListener listener);
	void repaint();
}
