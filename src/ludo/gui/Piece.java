package ludo.gui;

import ludo.enums.PieceColor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class Piece extends JLabel{

    private final PieceColor color;
    private Image image;

    public Piece(PieceColor color){
        super();
        this.color = color;
        pickImage(color);
        setLocation(7,5);
        setSize(21,25);
        setOpaque(false);
    }

    private void pickImage(PieceColor color){
        if(color.equals(PieceColor.RED)){
           image = new ImageIcon("img/red.png").getImage();
           image = image.getScaledInstance(21,25,Image.SCALE_SMOOTH);
        }
        if(color.equals(PieceColor.BLUE)){
            image = new ImageIcon("img/blue.png").getImage();
            image = image.getScaledInstance(21,25,Image.SCALE_SMOOTH);
        }
        if(color.equals(PieceColor.GREEN)){
            image = new ImageIcon("img/green.png").getImage();
            image = image.getScaledInstance(21,25,Image.SCALE_SMOOTH);
        }
        if(color.equals(PieceColor.YELLOW)) {
            image = new ImageIcon("img/yellow.png").getImage();
            image = image.getScaledInstance(21,25,Image.SCALE_SMOOTH);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(image, 0 , 0, null);
        repaint();
    }
}
