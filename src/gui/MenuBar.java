package gui;

import javax.swing.*;

public class MenuBar extends JMenuBar {

    private static MenuBar instance;
    private JMenu file;
    private JMenu edit;
    private JMenuItem group;
    private JMenuItem ungroup;
    private JMenuItem custom;

    private MenuBar() {

        file = new JMenu("File");
        edit = new JMenu("Edit");

        add(file);
        add(edit);

        group = new JMenuItem("Group");
        ungroup = new JMenuItem("Ungroup");
        custom = new JMenuItem("Custom Label Style");

        edit.add(group);
        edit.add(ungroup);
        edit.add(custom);

    }

    public static MenuBar getInstance() {
        synchronized (MenuBar.class) {
            if (instance == null) {
                instance = new MenuBar();
            }
        }
        return instance;
    }
}