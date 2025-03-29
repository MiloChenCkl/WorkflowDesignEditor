package button;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import gui.ToolBar;

public class GeneralizationButton extends AbstractButtons implements ActionListener {

    public GeneralizationButton() {
        super("Generalization", ButtonType.GENERALIZATION);
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        ToolBar toolBar = ToolBar.getInstance();
        toolBar.setButtonsColor();
        toolBar.setSelectedButton(getButtonType());
        setBackground(Color.GRAY);
        System.out.println("Generalization button clicked");
    }
}
