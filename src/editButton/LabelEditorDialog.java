package editButton;

import javax.swing.*;
import java.awt.*;
import object.Label;
import object.LabelShapeType;

public class LabelEditorDialog extends JDialog {
    private JTextField nameField;
    private JComboBox<LabelShapeType> shapeCombo;
    private JComboBox<String> colorCombo;
    private JComboBox<Integer> fontSizeCombo;
    private boolean confirmed = false;

    public LabelEditorDialog(Frame owner, Label label) {
        super(owner, "Custom label Style", true);
        GridLayout grid = new GridLayout(6, 2, 5, 5);
        setLayout(grid);

        add(new JLabel("Name:"));
        nameField = new JTextField(label.getName());
        add(nameField);

        add(new JLabel("Shape:"));
        shapeCombo = new JComboBox<LabelShapeType>(LabelShapeType.values());
        shapeCombo.setSelectedItem(label.getShapeOfLabel());
        add(shapeCombo);

        add(new JLabel("Color:"));
        colorCombo = new JComboBox<>(new String[] {"yellow", "pink", "white", "blue"});
        colorCombo.setSelectedItem(colorToName(label.getColor()));
        add(colorCombo);

        add(new JLabel("FontSize:"));
        fontSizeCombo = new JComboBox<>(new Integer[] {12, 16, 20, 24});
        add(fontSizeCombo);

        JButton cancelBtn = new JButton("Cancel");
        cancelBtn.addActionListener(e -> {
            confirmed = false;
            dispose();
        });
        add(cancelBtn);

        JButton okBtn = new JButton("OK");
        okBtn.addActionListener(e -> {
            confirmed = true;
            dispose();
        });
        add(okBtn);

        pack();
        setLocationRelativeTo(owner);
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public String getLabelName() {
        return nameField.getText();
    }

    public LabelShapeType getLabelShape() {
        return (LabelShapeType) shapeCombo.getSelectedItem();
    }

    public Color getSelectedColor() {
        return nameToColor((String) colorCombo.getSelectedItem());
    }

    public int getFontSize() {
        return (Integer) fontSizeCombo.getSelectedItem();
    }

    private String colorToName(Color c) {
        if (c.equals(Color.YELLOW)) return "yellow";
        if (c.equals(Color.PINK)) return "pink";
        if (c.equals(Color.BLUE)) return "blue";
        return "white";
    }

    private Color nameToColor(String name) {
        switch (name.toLowerCase()) {
            case "yellow": return Color.YELLOW;
            case "pink": return Color.PINK;
            case "blue": return Color.BLUE;
            default: return Color.WHITE;
        }
    }
}
