package ludo.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame{

    private static final String TITLE = "Ludo";

    private final FrameMenu menu = new FrameMenu();

    private final GamePanel game = new GamePanel();

    public MainFrame() throws HeadlessException {
        super(TITLE);
        setBounds(0,0,527,550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setBackground(Color.ORANGE);
        setLayout(null);
        //setJMenuBar(menu);
        add(game);
        setVisible(true);
    }

}
