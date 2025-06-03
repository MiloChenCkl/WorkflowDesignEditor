package button;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

import gui.Canvas;
import gui.ToolBar;
import objectCreator.GeneralLinkCreator;

public class GeneralizationButton extends AbstractButtons implements ActionListener {

    public GeneralizationButton() {
        super("Generalization");
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        ToolBar toolBar = ToolBar.getInstance();
        toolBar.setButtonsColor();

        Canvas canvas = Canvas.getInstance();
        canvas.setCreator(new GeneralLinkCreator());

        setBackground(Color.GRAY);
        System.out.println("Generalization button clicked");
    }
}
