package button;

import javax.swing.JButton;

public abstract class AbstractButtons extends JButton {

    private final ButtonType ButtonType;

    public AbstractButtons(String name, ButtonType type) {
        super(name);
        this.ButtonType = type;
    }

    public ButtonType getButtonType() {
        return ButtonType;
    }
}
