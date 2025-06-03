package button;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import gui.ToolBar;
import gui.Canvas;

public class SelectButton extends AbstractButtons implements ActionListener {

    public SelectButton() {
        super("Select");
        addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {
        ToolBar toolBar = ToolBar.getInstance();
        toolBar.setButtonsColor();

        Canvas canvas = Canvas.getInstance();
        canvas.setCreator(null); 

        setBackground(Color.GRAY);
        System.out.println("Select button clicked");
    }
}
