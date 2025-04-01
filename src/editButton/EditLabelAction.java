package editButton;

import java.util.List;

import javax.swing.*;
import object.Label;
import object.AbstractShape;
import object.CompositeShape;
import gui.Canvas;

public class EditLabelAction {

    public static void bindTo(JMenuItem menuItem) {
        menuItem.addActionListener(e -> {

            List <AbstractShape> selectedShape = Canvas.getInstance().getSelectedShapes();

            if (selectedShape.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No shape selected.", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (selectedShape.get(0) instanceof CompositeShape) {
                JOptionPane.showMessageDialog(null, "Cannot edit label of a group. Please ungroup first.", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }


            Label label = selectedShape.get(0).getLabel();
            JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(Canvas.getInstance());

            LabelEditorDialog dialog = new LabelEditorDialog(parentFrame, label);
            dialog.setVisible(true);

            if (dialog.isConfirmed()) {
                for (AbstractShape shape : selectedShape) {
                    Label lbl = shape.getLabel();
                    lbl.setName(dialog.getLabelName());
                    lbl.setShapeOfLabel(dialog.getLabelShape());
                    lbl.setColor(dialog.getSelectedColor());
                    lbl.setFontsize(dialog.getFontSize());
                }
                Canvas.getInstance().repaint();
            }
        });
    }
}