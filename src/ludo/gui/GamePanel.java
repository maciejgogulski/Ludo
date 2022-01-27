package ludo.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel {
    public GamePanel(){
        super();
        setSize(512,512);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        setBackground(Color.ORANGE);

        int x, y;
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 3; j++){
                x = 34 * i;
                y = 34 * j + 204;
                paintRectangle(g2d, x, y);
            }
        }

        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 3; j++){
                x = 34 * i + 306;
                y = 34 * j + 204;
                paintRectangle(g2d, x, y);
            }
        }

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 6; j++){
                x = 34 * i + 204;
                y = 34 * j;
                paintRectangle(g2d, x, y);
            }
        }

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 6; j++){
                x = 34 * i + 204;
                y = 34 * j + 306;
                paintRectangle(g2d, x, y);
            }
        }


        //RedBase
        paintRectangle(g2d, 51, 85);
        paintRectangle(g2d, 119, 85);
        paintRectangle(g2d, 85, 51);
        paintRectangle(g2d, 85, 119);
        //BlueBase
        paintRectangle(g2d,391,51);
        paintRectangle(g2d,391,119);
        paintRectangle(g2d,357,85);
        paintRectangle(g2d,425,85);
        //YellowBase
        paintRectangle(g2d,85,357);
        paintRectangle(g2d,51,391);
        paintRectangle(g2d,119,391);
        paintRectangle(g2d,85,425);
        //GreenBase
        paintRectangle(g2d,391,357);
        paintRectangle(g2d,357,391);
        paintRectangle(g2d,425,391);
        paintRectangle(g2d,391,425);
    }

    private void paintRectangle(Graphics2D g2d, int x , int y){
        g2d.setColor(new Color(255, 242, 230 ));
        g2d.fillRect(x,y, 34 ,34);
        g2d.setColor(Color.BLACK);
        g2d.drawRect(x,y, 34 ,34);
    }
}
