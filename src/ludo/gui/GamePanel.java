package ludo.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel {
    BufferedImage board;

    public GamePanel(){
        super();
        setPanelSize(new Dimension(650, 400));
        setBackground(Color.ORANGE);
    }

    public void setPanelSize(Dimension dimension){
        board = new BufferedImage(
                (int) dimension.getWidth(),
                (int) dimension.getHeight(),
                BufferedImage.TYPE_INT_RGB
        );
        setPreferredSize(dimension);
        setMaximumSize(dimension);
    }

    @Override
    protected void printComponent(Graphics g) {
        super.printComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(board, 0, 0, this);
    }
}
