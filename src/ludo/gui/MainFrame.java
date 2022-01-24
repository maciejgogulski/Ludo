package ludo.gui;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private static final String TITLE = "Ludo";

    private final FrameMenu menu = new FrameMenu();

    private final GamePanel game = new GamePanel();

    public MainFrame() throws HeadlessException {
        super(TITLE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(
                new FlowLayout(FlowLayout.CENTER, 2, 2)
        );
        setJMenuBar(menu);
        add(game);
        matchTheContent();
        setVisible(true);
    }

    private void matchTheContent(){
        pack();
        setLocationRelativeTo(null);
    }
}
