package ludo.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class Dice extends JLabel implements MouseListener {

    private final Image ONE = new ImageIcon("img/dice/one.png").getImage()
            .getScaledInstance(40,40,Image.SCALE_SMOOTH);
    private final Image TWO = new ImageIcon("img/dice/two.png").getImage()
            .getScaledInstance(40,40,Image.SCALE_SMOOTH);
    private final Image THREE = new ImageIcon("img/dice/three.png").getImage()
            .getScaledInstance(40,40,Image.SCALE_SMOOTH);
    private final Image FOUR = new ImageIcon("img/dice/four.png").getImage()
            .getScaledInstance(40,40,Image.SCALE_SMOOTH);
    private final Image FIVE = new ImageIcon("img/dice/five.png").getImage()
            .getScaledInstance(40,40,Image.SCALE_SMOOTH);
    private final Image SIX = new ImageIcon("img/dice/six.png").getImage()
            .getScaledInstance(40,40,Image.SCALE_SMOOTH);

    private final Image DEFAULT = new ImageIcon("img/dice/default.png").getImage()
            .getScaledInstance(40,40,Image.SCALE_SMOOTH);


    private Image rolled;
    private int value;
    private boolean isRolled;

    public Dice(){
        super();
        setLocation(136,136);
        setSize(40,40);
        setOpaque(true);
        addMouseListener(this);
        isRolled = false;
        rolled = DEFAULT;
    }


    public void roll(){
        isRolled = true;
        Random rand = new Random();
        switch (rand.nextInt(6) + 1) {
            case 1 -> {
                rolled = ONE;
                value = 1;
            }
            case 2 -> {
                rolled = TWO;
                value = 2;
            }
            case 3 -> {
                rolled = THREE;
                value = 3;
            }
            case 4 -> {
                rolled = FOUR;
                value = 4;
            }
            case 5 -> {
                rolled = FIVE;
                value = 5;
            }
            case 6 -> {
                rolled = SIX;
                value = 6;
            }
        }
    }

    public int getValue() {
        return value;
    }

    public void setRolled(boolean rolled) {
        isRolled = rolled;
    }

    public boolean isRolled() {
        return isRolled;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(!isRolled) {
            roll();
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

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        setBackground(Color.BLACK);
        if(!isRolled){
            rolled = DEFAULT;
        }
        g2d.drawImage(rolled, 0, 0, null);
        repaint();
    }
}
