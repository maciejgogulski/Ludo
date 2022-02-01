package ludo.gui;

import ludo.enums.PieceColor;

import javax.swing.*;
import java.awt.*;

public class Piece{

    private final PieceColor color;
    private Image image;

    public Piece(PieceColor color){
        super();
        this.color = color;
        pickImage(color);
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

    public PieceColor getColor() {
        return color;
    }

    public Image getImage() {
        return image;
    }
}
