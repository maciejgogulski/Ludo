package ludo.gui;

import ludo.entities.PieceColor;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    public GamePanel(){
        super();
        setSize(512,512);
        setLayout(null);

        Color red = new Color(136, 0 ,0);
        Color blue = new Color(0, 102 ,255);
        Color yellow = new Color(255, 220 ,26);
        Color green = new Color(0, 204 ,0);

        //Red
        Field[] redBase = new Field[4];
        redBase[0] = new Field(51,85, red);
        redBase[1] = new Field(119,85, red);
        redBase[2] = new Field(85,51, red);
        redBase[3] = new Field(85,119, red);

        for(int i = 0; i < 4; i++){
            add(redBase[i]);
            redBase[i].addPiece(new Piece(PieceColor.RED));
        }

        int x, y;
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 3; j++){
                x = 34 * i;
                y = 34 * j + 204;
                if(i >= 1 && j == 1 || i == 1 && j == 0){
                    add(new Field(x, y, red));
                }else {
                    add(new Field(x, y));
                }
            }
        }
        //Blue
        Field[] blueBase = new Field[4];
        blueBase[0] = new Field(391,51, blue);
        blueBase[1] = new Field(391,119, blue);
        blueBase[2] = new Field(357,85, blue);
        blueBase[3] = new Field(425,85, blue);

        for(int i = 0; i < 4; i++){
            add(blueBase[i]);
            blueBase[i].addPiece(new Piece(PieceColor.BLUE));
        }



        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 6; j++){
                x = 34 * i + 204;
                y = 34 * j;
                if(j >= 1 && i == 1 || i == 2 && j == 1){
                    add(new Field(x, y, blue));
                }else {
                    add(new Field(x, y));
                }
            }
        }
        //Yellow
        Field[] yellowBase = new Field[4];
        yellowBase[0] = new Field(85,357, yellow);
        yellowBase[1] = new Field(51,391, yellow);
        yellowBase[2] = new Field(119,391, yellow);
        yellowBase[3] = new Field(85,425, yellow);

        for(int i = 0; i < 4; i++){
            add(yellowBase[i]);
            yellowBase[i].addPiece(new Piece(PieceColor.YELLOW));
        }

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 6; j++){
                x = 34 * i + 204;
                y = 34 * j + 306;
                if(j < 5 && i == 1 || i == 0 && j == 4){
                    add(new Field(x, y, yellow));
                }else {
                    add(new Field(x, y));
                }
            }
        }
        //Green
        Field[] greenBase = new Field[4];
        greenBase[0] = new Field(391,357, green);
        greenBase[1] = new Field(357,391, green);
        greenBase[2] = new Field(425,391, green);
        greenBase[3] = new Field(391,425, green);

        for(int i = 0; i < 4; i++){
            add(greenBase[i]);
            greenBase[i].addPiece(new Piece(PieceColor.GREEN));
        }

        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 3; j++){
                x = 34 * i + 306;
                y = 34 * j + 204;
                if(i < 5 && j == 1 || i == 4 && j == 2){
                    add(new Field(x, y, green));
                }else {
                    add(new Field(x, y));
                }
            }
        }
    }

   @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //Graphics2D g2d = (Graphics2D) g;
        setBackground(Color.ORANGE);
    }

}
