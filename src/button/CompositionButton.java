package button;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import gui.ToolBar;

public class CompositionButton extends AbstractButtons implements ActionListener {

    public CompositionButton() {
        super("Composition", ButtonType.COMPOSITION);
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        ToolBar toolBar = ToolBar.getInstance();
        toolBar.setButtonsColor();
        toolBar.setSelectedButton(getButtonType());
        setBackground(Color.GRAY);
        System.out.println("Composition button clicked");
    }
    
}
