package button;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import gui.ToolBar;

public class SelectButton extends AbstractButtons implements ActionListener {

    public SelectButton() {
        super("Select", ButtonType.SELECT);
        addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {
        ToolBar toolBar = ToolBar.getInstance();
        toolBar.setButtonsColor();
        toolBar.setSelectedButton(getButtonType());
        setBackground(Color.GRAY);
        System.out.println("Select button clicked");
    }
}
