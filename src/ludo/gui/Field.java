package ludo.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;

public class Field extends JLabel implements MouseListener {
    private Color color;
    private LinkedList<Piece> pieces;

    public Field(int posX, int posY){
        super();
        setLocation(posX, posY);
        setSize(35,35);
        setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        setOpaque(true);
        color = new Color(255, 242, 230 );
        pieces = new LinkedList<>();
        setBackground(color);
        addMouseListener(this);
    }

    public Field(int posX, int posY, Color color){
        super();
        this.color = color;
        setLocation(posX, posY);
        setSize(35,35);
        setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        pieces = new LinkedList<>();
        setBackground(color);
        setOpaque(true);
        addMouseListener(this);
    }

    public void addPiece(Piece piece){
        pieces.add(piece);
        repaint();
    }

    public void removePiece(){
        if(hasPiece()){
            pieces.remove();
            setBackground(color);
            repaint();
        }
    }

    public void take(Field oldField, Field newField){
        pieces.clear();
        movePiece(oldField, newField);
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

    public Color getColor() {
        return color;
    }

    public Piece getPiece() {
        return pieces.getLast();
    }


    public boolean hasPiece(){
        return pieces.size() != 0;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(hasPiece()){
            if(!GamePanel.isClicked) {
                setBackground(color.darker().darker());
                GamePanel.isClicked = true;
                GamePanel.lastClicked = this;
            }else{
                if(GamePanel.lastClicked.equals(this)) {
                    setBackground(color.brighter());
                }else{
                    if(getPiece().getColor().equals(GamePanel.lastClicked.getPiece().getColor())){
                        movePiece(GamePanel.lastClicked, this);
                    }else{
                        take(GamePanel.lastClicked, this);
                    }
                }
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

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        if(pieces.size() >= 1) {
            g2d.drawImage(getPiece().getImage(), 7 , 5, null);
            if(pieces.size() > 1) {
                String s = "";
                s += pieces.size();
                g2d.drawString(s, 1, 10);
            }
        }
        repaint();
    }
}
