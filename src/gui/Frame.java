package gui;

import javax.swing.*;
import java.awt.BorderLayout;

public class Frame extends JFrame {

    private static Frame instance;

    private Frame() {

        setTitle("WorkflowDesignEditor");
        setLayout(new BorderLayout());

        MenuBar menuBar = MenuBar.getInstance();
        ToolBar toolBar = ToolBar.getInstance();
        Canvas canvas = Canvas.getInstance();

        add(menuBar, BorderLayout.NORTH);
        add(toolBar, BorderLayout.WEST);
        add(canvas, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 700);
        setResizable(true);
        setVisible(true);
    }

    public static Frame getInstance() {
        synchronized (Frame.class) {
            if (instance == null) {
                instance = new Frame();
            }
        }
        return instance;
    }

}