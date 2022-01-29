package ludo.gui;

import ludo.enums.PieceColor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GamePanel extends JPanel {

    private final Field[] BOARD = new Field[52];

    private final Field[] RED_BASE = new Field[4];
    private final Field[] BLUE_BASE = new Field[4];
    private final Field[] GREEN_BASE = new Field[4];
    private final Field[] YELLOW_BASE = new Field[4];

    private final Field[] RED_HOUSE = new Field[5];
    private final Field[] BLUE_HOUSE = new Field[5];
    private final Field[] GREEN_HOUSE = new Field[5];
    private final Field[] YELLOW_HOUSE = new Field[5];

    private final Color RED = new Color(136, 0, 0);
    private final Color BLUE = new Color(0, 102, 255);
    private final Color YELLOW = new Color(255, 220, 26);
    private final Color GREEN = new Color(0, 204, 0);

    public static boolean isClicked;
    public static Field lastClicked;
    public static Color whosTurn;

    public GamePanel() {
        super();
        setSize(512, 512);
        setLayout(null);
        drawBases();
        drawHouses();
        drawBoard();
        whosTurn = RED;
        isClicked = false;
    }

    public void drawBoard(){
        int x = 34;
        int y = 204;
        int i = 0;
        while (i <= 4) {
            BOARD[i] = new Field(x, y);
            add(BOARD[i]);
            x += 34;
            i++;
        }
        while (i >= 5 && i <= 10) {
            y -= 34;
            BOARD[i] = new Field(x, y);
            add(BOARD[i]);
            i++;
        }
        while (i >= 11 && i <= 12) {
            x += 34;
            BOARD[i] = new Field(x, y);
            add(BOARD[i]);
            i++;
        }
        while (i >= 13 && i <= 17) {
            y += 34;
            BOARD[i] = new Field(x, y);
            add(BOARD[i]);
            i++;
        }
        y += 34;
        while (i >= 18 && i <= 23) {
            x += 34;
            BOARD[i] = new Field(x, y);
            add(BOARD[i]);
            i++;
        }
        while (i >= 24 && i <= 25) {
            y += 34;
            BOARD[i] = new Field(x, y);
            add(BOARD[i]);
            i++;
        }
        while (i >= 26 && i <= 30) {
            x -= 34;
            BOARD[i] = new Field(x, y);
            add(BOARD[i]);
            i++;
        }
        x -= 34;
        while (i >= 31 && i <= 36) {
            y += 34;
            BOARD[i] = new Field(x, y);
            add(BOARD[i]);
            i++;
        }
        while (i >= 37 && i <= 38) {
            x -= 34;
            BOARD[i] = new Field(x, y);
            add(BOARD[i]);
            i++;
        }
        while (i >= 39 && i <= 43) {
            y -= 34;
            BOARD[i] = new Field(x, y);
            add(BOARD[i]);
            i++;
        }
        y -= 34;
        while (i >= 44 && i <= 49) {
            x -= 34;
            BOARD[i] = new Field(x, y);
            add(BOARD[i]);
            i++;
        }
        while (i >= 50 && i <= 51) {
            y -= 34;
            BOARD[i] = new Field(x, y);
            add(BOARD[i]);
            i++;
        }

        BOARD[0].setColor(RED);
        BOARD[13].setColor(BLUE);
        BOARD[26].setColor(GREEN);
        BOARD[39].setColor(YELLOW);
    }

    public void drawBases(){
        RED_BASE[0] = new Field(51, 85, RED);
        RED_BASE[1] = new Field(119, 85, RED);
        RED_BASE[2] = new Field(85, 51, RED);
        RED_BASE[3] = new Field(85, 119, RED);

        for (int i = 0; i < 4; i++) {
            add(RED_BASE[i]);
            RED_BASE[i].addPiece(new Piece(PieceColor.RED));
        }

        BLUE_BASE[0] = new Field(391, 51, BLUE);
        BLUE_BASE[1] = new Field(391, 119, BLUE);
        BLUE_BASE[2] = new Field(357, 85, BLUE);
        BLUE_BASE[3] = new Field(425, 85, BLUE);

        for (int i = 0; i < 4; i++) {
            add(BLUE_BASE[i]);
            BLUE_BASE[i].addPiece(new Piece(PieceColor.BLUE));
        }

        GREEN_BASE[0] = new Field(391, 357, GREEN);
        GREEN_BASE[1] = new Field(357, 391, GREEN);
        GREEN_BASE[2] = new Field(425, 391, GREEN);
        GREEN_BASE[3] = new Field(391, 425, GREEN);

        for (int i = 0; i < 4; i++) {
            add(GREEN_BASE[i]);
            GREEN_BASE[i].addPiece(new Piece(PieceColor.GREEN));
        }

        YELLOW_BASE[0] = new Field(85, 357, YELLOW);
        YELLOW_BASE[1] = new Field(51, 391, YELLOW);
        YELLOW_BASE[2] = new Field(119, 391, YELLOW);
        YELLOW_BASE[3] = new Field(85, 425, YELLOW);

        for (int i = 0; i < 4; i++) {
            add(YELLOW_BASE[i]);
            YELLOW_BASE[i].addPiece(new Piece(PieceColor.YELLOW));
        }
    }

    public void drawHouses(){
        int rx = 34;
        for(int i = 0; i < 5; i++) {
            RED_HOUSE[i] = new Field(rx, 238, RED);
            add(RED_HOUSE[i]);
            rx += 34;
        }

        int by = 34;
        for(int i = 0; i < 5; i++) {
            BLUE_HOUSE[i] = new Field(238, by, BLUE);
            add(BLUE_HOUSE[i]);
            by += 34;
        }

        int yy = 306;
        for(int i = 0; i < 5; i++) {
            YELLOW_HOUSE[i] = new Field(238, yy, YELLOW);
            add(YELLOW_HOUSE[i]);
            yy += 34;
        }

        int gx = 306;
        for(int i = 0; i < 5; i++) {
            GREEN_HOUSE[i] = new Field(gx, 238, GREEN);
            add(GREEN_HOUSE[i]);
            gx += 34;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //Graphics2D g2d = (Graphics2D) g;
        setBackground(Color.ORANGE);
    }

}
