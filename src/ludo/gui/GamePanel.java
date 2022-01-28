package ludo.gui;

import ludo.entities.PieceColor;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    public GamePanel() {
        super();
        setSize(512, 512);
        setLayout(null);

        Color red = new Color(136, 0, 0);
        Color blue = new Color(0, 102, 255);
        Color yellow = new Color(255, 220, 26);
        Color green = new Color(0, 204, 0);

        //Red
        Field[] redBase = new Field[4];
        redBase[0] = new Field(51, 85, red);
        redBase[1] = new Field(119, 85, red);
        redBase[2] = new Field(85, 51, red);
        redBase[3] = new Field(85, 119, red);

        for (int i = 0; i < 4; i++) {
            add(redBase[i]);
            redBase[i].addPiece(new Piece(PieceColor.RED));
        }

        Field[] redHouse = new Field[5];
        int rx = 34;
        for(int i = 0; i < 5; i++) {
            redHouse[i] = new Field(rx, 238, red);
            add(redHouse[i]);
            rx += 34;
        }

        //Blue
        Field[] blueBase = new Field[4];
        blueBase[0] = new Field(391, 51, blue);
        blueBase[1] = new Field(391, 119, blue);
        blueBase[2] = new Field(357, 85, blue);
        blueBase[3] = new Field(425, 85, blue);

        for (int i = 0; i < 4; i++) {
            add(blueBase[i]);
            blueBase[i].addPiece(new Piece(PieceColor.BLUE));
        }

        Field[] blueHouse = new Field[5];
        int by = 34;
        for(int i = 0; i < 5; i++) {
            blueHouse[i] = new Field(238, by, blue);
            add(blueHouse[i]);
            by += 34;
        }

        //Yellow
        Field[] yellowBase = new Field[4];
        yellowBase[0] = new Field(85, 357, yellow);
        yellowBase[1] = new Field(51, 391, yellow);
        yellowBase[2] = new Field(119, 391, yellow);
        yellowBase[3] = new Field(85, 425, yellow);

        for (int i = 0; i < 4; i++) {
            add(yellowBase[i]);
            yellowBase[i].addPiece(new Piece(PieceColor.YELLOW));
        }

        Field[] yellowHouse = new Field[5];
        int yy = 306;
        for(int i = 0; i < 5; i++) {
            yellowHouse[i] = new Field(238, yy, yellow);
            add(yellowHouse[i]);
            yy += 34;
        }

        //Green
        Field[] greenBase = new Field[4];
        greenBase[0] = new Field(391, 357, green);
        greenBase[1] = new Field(357, 391, green);
        greenBase[2] = new Field(425, 391, green);
        greenBase[3] = new Field(391, 425, green);

        for (int i = 0; i < 4; i++) {
            add(greenBase[i]);
            greenBase[i].addPiece(new Piece(PieceColor.GREEN));
        }

        Field[] greenHouse = new Field[5];
        int gx = 306;
        for(int i = 0; i < 5; i++) {
            greenHouse[i] = new Field(gx, 238, green);
            add(greenHouse[i]);
            gx += 34;
        }

        //board

        Field[] board = new Field[52];
        int x = 34;
        int y = 204;
        int i = 0;
        while (i <= 4) {
            board[i] = new Field(x, y);
            add(board[i]);
            x += 34;
            i++;
        }
        while (i >= 5 && i <= 10) {
            y -= 34;
            board[i] = new Field(x, y);
            add(board[i]);
            i++;
        }
        while (i >= 11 && i <= 12) {
            x += 34;
            board[i] = new Field(x, y);
            add(board[i]);
            i++;
        }
        while (i >= 13 && i <= 17) {
            y += 34;
            board[i] = new Field(x, y);
            add(board[i]);
            i++;
        }
        y += 34;
        while (i >= 18 && i <= 23) {
            x += 34;
            board[i] = new Field(x, y);
            add(board[i]);
            i++;
        }
        while (i >= 24 && i <= 25) {
            y += 34;
            board[i] = new Field(x, y);
            add(board[i]);
            i++;
        }
        while (i >= 26 && i <= 30) {
            x -= 34;
            board[i] = new Field(x, y);
            add(board[i]);
            i++;
        }
        x -= 34;
        while (i >= 31 && i <= 36) {
            y += 34;
            board[i] = new Field(x, y);
            add(board[i]);
            i++;
        }
        while (i >= 37 && i <= 38) {
            x -= 34;
            board[i] = new Field(x, y);
            add(board[i]);
            i++;
        }
        while (i >= 39 && i <= 43) {
            y -= 34;
            board[i] = new Field(x, y);
            add(board[i]);
            i++;
        }
        y -= 34;
        while (i >= 44 && i <= 49) {
            x -= 34;
            board[i] = new Field(x, y);
            add(board[i]);
            i++;
        }
        while (i >= 50 && i <= 51) {
            y -= 34;
            board[i] = new Field(x, y);
            add(board[i]);
            i++;
        }

        board[0].setColor(red);
        board[13].setColor(blue);
        board[26].setColor(green);
        board[39].setColor(yellow);
    }

    public void movePiece(Field currentField, Field newField){
        if(currentField.hasPiece()){
            newField.addPiece(currentField.getPiece());
            currentField.removePiece();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //Graphics2D g2d = (Graphics2D) g;
        setBackground(Color.ORANGE);
    }

}
