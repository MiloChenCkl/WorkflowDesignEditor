package button;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import gui.ToolBar;

public class OralButton extends AbstractButtons implements ActionListener { 

    public OralButton() {
        super("Oral", ButtonType.ORAL);
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        ToolBar toolBar = ToolBar.getInstance();
        toolBar.setButtonsColor();
        toolBar.setSelectedButton(getButtonType());
        setBackground(Color.GRAY);
        System.out.println("Oral button clicked");
    }

}
