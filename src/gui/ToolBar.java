package gui;

import javax.swing.*;
import java.awt.Color;
import java.awt.GridLayout;
import button.*;
import java.util.ArrayList;

public class ToolBar extends JPanel{

    private static ToolBar instance;
    private final ArrayList<AbstractButtons> buttonArray = new ArrayList<AbstractButtons>();
    private ButtonType selectedButton = null;

    private ToolBar() {
        InitButtons();
        setLayout(new GridLayout(6,1));
    }

    public static ToolBar getInstance() {
        synchronized (ToolBar.class) {
            if (instance == null) {
                instance = new ToolBar();
            }
        }
        return instance;
    }

    private void InitButtons(){

        AbstractButtons selectButton = new SelectButton();
        AbstractButtons associationButton = new AssociationButton();
        AbstractButtons generalizationButton = new GeneralizationButton();
        AbstractButtons compositionButton = new CompositionButton();
        AbstractButtons rectButton = new RectButton();
        AbstractButtons ovalButton = new OvalButton();

        add(selectButton);
        add(associationButton);
        add(generalizationButton);
        add(compositionButton);
        add(rectButton);
        add(ovalButton);

        buttonArray.add(selectButton);
        buttonArray.add(associationButton);
        buttonArray.add(generalizationButton);
        buttonArray.add(compositionButton);
        buttonArray.add(rectButton);
        buttonArray.add(ovalButton);

        setButtonsColor();
    }

    public void setButtonsColor() {
        for(AbstractButtons button : buttonArray) {
            button.setBackground(Color.LIGHT_GRAY);
        }
    }

    public void setSelectedButton(ButtonType selectedButton) {
        this.selectedButton = selectedButton;
        for(AbstractButtons button : buttonArray) {
            if(button.getButtonType() == (selectedButton)) {
                button.setBackground(Color.GRAY);
            }
        }
    }

    public ButtonType getSelectedButton() {
        return selectedButton;
    }   
};