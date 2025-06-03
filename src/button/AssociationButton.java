package button;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import gui.ToolBar;
import objectCreator.AssocLinkCreator;
import gui.Canvas;

public class AssociationButton extends AbstractButtons implements ActionListener{

    public AssociationButton() {
        super("Association");
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        ToolBar toolBar = ToolBar.getInstance();
        toolBar.setButtonsColor();

        Canvas canvas = Canvas.getInstance();
        canvas.setCreator(new AssocLinkCreator());

        setBackground(Color.GRAY);
        System.out.println("association button clicked");
    }
    
}
