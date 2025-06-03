package button;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

import gui.Canvas;
import gui.ToolBar;
import objectCreator.RectCreator;

public class RectButton extends AbstractButtons implements ActionListener {

    public RectButton() {
        super("Rect");
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        ToolBar toolBar = ToolBar.getInstance();
        toolBar.setButtonsColor();

        Canvas canvas = Canvas.getInstance();
        canvas.setCreator(new RectCreator());

        setBackground(Color.GRAY);
        System.out.println("Rect button clicked");
    }

}
