package button;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import gui.ToolBar;

public class RectButton extends AbstractButtons implements ActionListener {

    public RectButton() {
        super("Rect", ButtonType.RECT);
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        ToolBar toolBar = ToolBar.getInstance();
        toolBar.setButtonsColor();
        toolBar.setSelectedButton(getButtonType());
        setBackground(Color.GRAY);
        System.out.println("Rect button clicked");
    }

}
