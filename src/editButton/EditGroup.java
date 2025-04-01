package editButton;

import object.AbstractShape;
import object.CompositeShape;
import gui.Canvas;

import javax.swing.*;
import java.util.List;

public class EditGroup {

    public static void bindTo(JMenuItem groupMenuItem) {
        groupMenuItem.addActionListener(e -> {
            List<AbstractShape> selectedShapes = Canvas.getInstance().getSelectedShapes();

            if (selectedShapes.size() <= 1) {
                JOptionPane.showMessageDialog(null,
                        "Please select 2 or more shapes to group.",
                        "Grouping Failed",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            CompositeShape group = new CompositeShape(selectedShapes);
            Canvas.getInstance().removeShapes(selectedShapes);
            Canvas.getInstance().addShape(group);
            Canvas.getInstance().clearSelection();
            group.setSelected(true);
            Canvas.getInstance().repaint();
        });
    }
}