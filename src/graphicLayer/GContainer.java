package graphicLayer;
import java.awt.Point;
import java.awt.event.MouseListener;

public interface GContainer {
	void repaint();
	Point getGlobalPosition();
	GElement [] getRawContents();
	Boolean containsPoint(Point p);
	void addElement(GElement m);
	void removeElement(GElement m);
	void clear();
	void addMouseListener(MouseListener listener);
}
