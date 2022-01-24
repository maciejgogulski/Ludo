package ludo.gui;

import javax.swing.*;

public class FrameMenu extends JMenuBar {
    private JMenu game = new JMenu("Gra");
    private JMenuItem newGame = new JMenuItem("Nowa gra");

    private JMenu settings = new JMenu("Ustawienia");
    private JMenuItem theme = new JMenuItem("Motyw");

    public FrameMenu(){
        game.add(newGame);
        add(game);
        settings.add(theme);
        add(settings);
    }
}
