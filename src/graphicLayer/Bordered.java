package graphicLayer;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Stroke;

public interface Bordered {
	default Color defaultBorderColor() {
		return Color.black;
	}
	default Stroke defaultStroke() {
		return new BasicStroke(1);
	}
	void setBorderColor(Color borderColor);
	
	default void setBorderWidth(float w) {
		this.setStroke(new BasicStroke(w));
	}
	
	void setStroke(Stroke stroke);
	
	default void withoutBorder() {
		this.setWithBorder(false);
	}
	
	default void withBorder() {
		this.setWithBorder(false);
	}
	void setWithBorder(Boolean withBorder);

}
