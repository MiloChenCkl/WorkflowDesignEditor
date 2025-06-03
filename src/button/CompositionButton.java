package button;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

import gui.Canvas;
import gui.ToolBar;
import objectCreator.CompLinkCreator;

public class CompositionButton extends AbstractButtons implements ActionListener {

    public CompositionButton() {
        super("Composition");
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        ToolBar toolBar = ToolBar.getInstance();
        toolBar.setButtonsColor();

        Canvas canvas = Canvas.getInstance();
        canvas.setCreator(new CompLinkCreator());

        setBackground(Color.GRAY);
        System.out.println("Composition button clicked");
    }
    
}
