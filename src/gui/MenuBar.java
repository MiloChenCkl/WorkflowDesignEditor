package gui;

import javax.swing.*;

import editButton.EditGroup;
import editButton.EditLabelAction;
import editButton.EditUnGroup;

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

        EditGroup.bindTo(group);
        edit.add(group);

        EditUnGroup.bindTo(ungroup);
        edit.add(ungroup);

        EditLabelAction.bindTo(custom);
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