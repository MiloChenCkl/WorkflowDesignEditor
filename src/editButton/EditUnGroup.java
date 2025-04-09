package editButton;

import object.AbstractShape;
import object.CompositeShape;
import gui.Canvas;

import javax.swing.*;
import java.util.List;

public class EditUnGroup {

    public static void bindTo(JMenuItem ungroupMenuItem) {
        ungroupMenuItem.addActionListener(e -> {
            List<AbstractShape> selectedShapes = Canvas.getInstance().getSelectedShapes();

            if (selectedShapes.size() != 1 || !(selectedShapes.get(0) instanceof CompositeShape)) {
                JOptionPane.showMessageDialog(null,
                        "Please select exactly one grouped shape to ungroup.",
                        "UnGroup Failed",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            CompositeShape group = (CompositeShape) selectedShapes.get(0);
            List<AbstractShape> parts = group.ungroup();

            Canvas.getInstance().removeShape(group);
            Canvas.getInstance().addShapes(parts);
            Canvas.getInstance().clearSelection();            
            for (AbstractShape shape : parts) {
                shape.setSelected(true); 
            }

            Canvas.getInstance().repaint();
        });
    }
}