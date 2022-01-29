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
            setBackground(color);
            repaint();
        }
    }

    public void movePiece(Field oldField, Field newField) {
        if (oldField.hasPiece()) {
            newField.addPiece(oldField.getPiece());
            oldField.removePiece();
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
        if(hasPiece()){
            if(!GamePanel.isClicked) {
                setBackground(color.darker().darker());
                GamePanel.isClicked = true;
                GamePanel.lastClicked = this;
            }else{
                setBackground(color.brighter());
                GamePanel.isClicked = false;
                GamePanel.lastClicked = null;
            }
        }else{
            if(GamePanel.isClicked){
                movePiece(GamePanel.lastClicked, this);
                GamePanel.isClicked = false;
                GamePanel.lastClicked = null;
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(!GamePanel.isClicked) {
            setBackground(color.brighter());
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(!GamePanel.isClicked) {
            setBackground(color);
        }
    }
}
