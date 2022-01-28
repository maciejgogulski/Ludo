package ludo.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Field extends JLabel implements MouseListener {
    private Color color;
    private Piece piece;

    public Field(int posX, int posY){
        super();
        setLocation(posX, posY);
        setSize(35,35);
        setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        setOpaque(true);
        color = new Color(255, 242, 230 );
        setBackground(color);
        addMouseListener(this);
    }

    public Field(int posX, int posY, Color color){
        super();
        this.color = color;
        setLocation(posX, posY);
        setSize(35,35);
        setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        setBackground(color);
        setOpaque(true);
        addMouseListener(this);
    }

    public void addPiece(Piece piece){
        this.piece = piece;
        add(piece);
    }

    public void removePiece(){
        if(hasPiece()){
            remove(piece);
            this.piece = null;
        }
    }

    public void setColor(Color color){
        this.color = color;
        setBackground(color);
    }

    public Piece getPiece() {
        return piece;
    }

    public boolean hasPiece(){
        return piece != null;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        setBackground(color.darker());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        setBackground(color.brighter());
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        setBackground(color.brighter());
    }

    @Override
    public void mouseExited(MouseEvent e) {
        setBackground(color);
    }




}
